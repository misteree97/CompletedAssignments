import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Elliot Lohr
 * This class provides a blueprint for a shippingcenter node, which will only take tasks depending on the valid addresses passed in
 */
public class ShippingCenter
{
    /**
     * Shipping Center ID that will be assigned to orders that pass through the Shipping Center
     */
    private final String shippingCenterId;
    /**
     * Array of cities that the Shipping Center will accept orders from
     */
    private final String[] validAddresses;
    /**
     * Array of ShippingSections that the ShippingCenter can send orders to
     */
    private final ShippingSection[] sections;
    /**
     * Queue used as a buffere between nodes
     */
    private final ArrayBlockingQueue<AwsTask> queue;
    /**
     *
     */
    private final Thread thread = new WorkerThread();
    /**
     * Thread safe output to console
     */
    private final Logger log = Logger.getLogger("ShippingCenter");

    /**
     * Constructor for a ShippingCenter object
     * @param shippingCenterId  the ShippingCenterID that will tagged to orders that pass through
     * @param validAddresses    array of cities that the shipping center will accept orders from
     * @param sections          array of ShippingSections the the ShippingCenter can send orders to
     */
    public ShippingCenter(String shippingCenterId, String[] validAddresses, ShippingSection[] sections)
    {
        this.shippingCenterId = shippingCenterId;
        this.validAddresses = validAddresses;
        this.sections = sections;
        this.queue = new ArrayBlockingQueue(10000);
        this.thread.start();
    }

    /**
     * Method called by AmazonWebServer to enqeue a new delivery task
     * @param task  order sent from AmazonWebServer
     * @return true if the orders city matches one of the valid cities of the shipping center, otherwise return false
     */
    public boolean put(AwsTask task)
    {
        try
        {
            // If message is of "DELIVERY" type...
            if (task.messageKind.equals("DELIVERY") && validAddresses.length > 0)
            {
                // Go over each valid address looking for a match
                for(int i = 0; i < validAddresses.length; i++)
                {
                    //if the order's address matches a valid address of the shipping center
                    if(task.address.equals(validAddresses[i]))
                    {
                        //attaches shipping center ID to the order and enqueues the task for the shipping section
                        task.shippingCenter = shippingCenterId;
                        queue.put(task);
                        return true;
                    }
                }
                // no match found
                return false;
            }
            // Always deliver regardless of type of message. This will also take care
            // if we don't have any validAddresses
            task.shippingCenter = shippingCenterId;
            queue.put(task);
        }
        catch(InterruptedException ex)
        {
            log.log(Level.WARNING, "ShippingCenter crashed", ex);
        }
        return true;
    }

    /**
     * Method to join the AmazonWebServer threads and the Shipping Center threads
     */
    public void waitUntilDone()
    {
        try
        {
            thread.join();//joins the AmazonWebServer threads and the shipping center threads

            for (int i = 0; i < sections.length; i++)
            {
                sections[i].waitUntilDone();
            }
        }
        catch(InterruptedException ex)
        {
            log.log(Level.WARNING, "ShippingCenter crashed", ex);
        }
    }
    /**
     * Thread created that holds information about AWStasks and pulls information from queue and assigns it to the correct ShippingSection
     */
    private class WorkerThread extends Thread
    {
        public void run()
        {
            try
            {
                while (true)
                {
                    //pulls task from the queue
                    AwsTask task = queue.poll(1, TimeUnit.SECONDS);
                    if (task != null)
                    {
                        if (task.messageKind.equals("DELIVERY"))
                        {
                            // finds a shipping section that can process this category.
                            // The "put" function returns true if the shipping section accepted the route.
                            for (int i = 0; i < sections.length; i++)
                            {
                                if (sections[i].put(task)) //puts the task onto the shipping section queue
                                {
                                    break; //breaks for loop since we found the section that accepted category
                                }
                            }
                        }
                        else
                        {
                            // this has to be "FINISHED" message
                            for (int i = 0; i < sections.length; i++)
                            {
                                sections[i].put(task); //notifies the shipping sections that there are no more orders to process
                            }
                            break; //breaks while loop and ends this thread's run
                        }
                    }
                }
            }
            catch(InterruptedException ex)
            {
                log.log(Level.WARNING, "ShippingCenter crashed", ex);
            }
        }
    }
}
