import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Elliot Lohr
 * This program provides a blueprint for a ShippingSection node, which will only take in orders that fit the bounds on the category of the order
 */
public class ShippingSection
{
    /**
     * Section ID that will be tagged to orders that are processed through ShippingSection
     */
    private final String shippingSectionId;
    /**
     * Shipping Dock that the Shipping Section will send orders to
     */
    private final ShippingDock dock;
    /**
     * Lower character bound on Item Category that ShippingSection will accept
     */
    private final char lowerBound;
    /**
     * Upper character bound on Item Category that ShippinSection will accept
     */
    private final char upperBound;
    /**
     * Queue used as a buffer between nodes
     */
    private final ArrayBlockingQueue<AwsTask> queue;
    /**
     *
     */
    private final Thread thread = new WorkerThread();
    /**
     * Thread safe output to console
     */
    private final Logger log = Logger.getLogger("ShippingSection");

    /**
     * Constructor for ShippingSection object
     * @param shippingSectionId     ShippingSection ID that is tagged to orders that pass through ShippingSection
     * @param lowerBound            Lower char bound on Item category
     * @param upperBound            Upper char bound on Item category
     * @param dock                  ShippingDock that orders will be sent to
     */
    public ShippingSection(String shippingSectionId, char lowerBound, char upperBound, ShippingDock dock)
    {
        this.shippingSectionId = shippingSectionId;
        this.queue = new ArrayBlockingQueue(10000);
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.dock = dock;

        // Tell Dock this shipping section is using it for deliveries.
        // This way a Dock tracks the number of sections it serves and can wait
        // for all of them to finish before it forwards FINISHED to its trucks.
        dock.incrementFeedCount();

        this.thread.start();
    }

    /**
     * Called in Shipping Center to eneqeue a new delivery task
     * @param task  order to be enqueued
     * @return      true if the order's category met the lower-upper bound criteria, otherwise return false
     */
    public boolean put(AwsTask task)
    {
        try
        {
            if (task.messageKind.equals("DELIVERY"))
            {
                char letter = task.category.toUpperCase().charAt(0); //gets the first letter of the orders item category
                if (letter >= lowerBound && letter <= upperBound) //if the letter fits the lower-upper bound item category constraint, assign shipping sections id and sends order to the ShippingDock node
                {
                    task.shippingSection = this.shippingSectionId;
                    queue.put(task);
                    return true;
                }
            }
            else
            {
                queue.put(task); //notifies shipping dock to shut down if done message is received
                return true;
            }
        }
        catch(InterruptedException ex)
        {
            log.log(Level.WARNING, "ShippingSection crashed", ex);
        }
        return false;
    }

    /**
     * Joins the Shipping Center thread with the ShippingSection thread
     */
    public void waitUntilDone()
    {
        try
        {
            thread.join(); //joins the shipping center thread with the shipping section thread
            dock.waitUntilDone(); //waits for dock to join thread with delivery truck
        }
        catch(InterruptedException ex)
        {
            log.log(Level.WARNING, "ShippingSection crashed", ex);
        }
    }

    /**
     * Used to pass every task in queue to the ShippingDock
     */
    private class WorkerThread extends Thread
    {
        /**
         * Thread runs until it finds
         */
        public void run()
        {
            try
            {
                while (true)
                {
                    AwsTask task = queue.poll(1, TimeUnit.SECONDS); //pulls tasks from queue
                    if (task != null)
                    {
                        Thread.sleep(ThreadLocalRandom.current().nextInt(0, 6) * 1000); //randomized time to process order in shipping section
                        dock.put(task); //gives task to Shipping Dock
                        if (task.messageKind.equals("FINISHED"))
                        {
                            break; //breaks while loop and ends threads run
                        }
                    }
                }
            }
            catch(InterruptedException ex)
            {
                log.log(Level.WARNING, "ShippingSection crashed", ex);
            }
        }
    }
}
