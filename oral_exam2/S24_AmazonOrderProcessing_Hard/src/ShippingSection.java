import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Elliot Lohr
 * This program provides a blueprint for a ShippingSection node, which will only take in orders that fit the bounds on the category of the order
 */
public class ShippingSection {
    private final String shippingSectionId;
    private final ShippingDock dock;
    private final char lowerBound;
    private final char upperBound;
    private final ArrayBlockingQueue<AwsTask> queue;
    private final Thread thread = new WorkerThread();
    private final Logger log = Logger.getLogger("TRUCK");

    /**
     * Constructor for a shipping section
     * @param shippingSectionId     the ID for the shipping section
     * @param lowerBound            the lower bound for characters that the shipping section will accept
     * @param upperBound            the upper bound for characters that the shipping section will accept
     * @param dock                  the ShippingDock that the ShippingSection will send orders to
     */
    public ShippingSection(String shippingSectionId, char lowerBound, char upperBound, ShippingDock dock)
    {
        this.shippingSectionId = shippingSectionId;
        this.queue = new ArrayBlockingQueue(10000);
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.dock = dock;
        this.thread.start();
    }

    /* Called by the Shipping Center to enque a new delivery task.
        Returns true if the shipping address met lower-upper bound criteria.
        Otherwise, returns false.
    **/

    /**
     * Called by Shipping Center to enqeue a new delivery task
     *
     * @param task
     * @return true if the shipping address met the lower/upper bound criteria. Otherwise returns false
     */
    public boolean put(AwsTask task) {
        try {
            if (task.messageKind.equals("DELIVERY")) {
                char letter = task.category.toUpperCase().charAt(0);
                //determines if the item category fits the lower/upper bound criteria
                if (letter >= lowerBound && letter <= upperBound) {
                    task.shippingSection = this.shippingSectionId;
                    queue.put(task);
                    return true;
                }
            } else {
                queue.put(task);
                return true;
            }
        } catch(InterruptedException ex) {
            log.log(Level.WARNING, "ShippingSection crashed", ex);
        }
        return false;
    }

    /**
     * Waits until the dock can accept tasks
     */
    public void waitUntilDone() {
        try {
            thread.join();
            dock.waitUntilDone();
        } catch(InterruptedException ex) {
            log.log(Level.WARNING, "ShippingSection crashed", ex);
        }
    }

    /**
     * Passes every task in the queue to shipping dock
     */
    private class WorkerThread extends Thread {
        public void run() {
            try {
                while (true) {
                    AwsTask task = queue.poll(1, TimeUnit.SECONDS); //creates tasks from the head of the queue
                    if (task != null) {
                        Thread.sleep(ThreadLocalRandom.current().nextInt(0, 6) * 1000);
                        dock.put(task);
                        if (task.messageKind.equals("FINISHED")) {
                            break;
                        }
                    }
                }
            } catch(InterruptedException ex) {
                log.log(Level.WARNING, "ShippingSection crashed", ex);
            }
        }
    }
}
