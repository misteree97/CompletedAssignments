import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Elliot Lohr
 * This class provides a blueprint for a shippingcenter node, which will only take tasks depending on the valid addresses passed in
 */
public class ShippingCenter{
    private final String shippingCenterId;
    private final String[] validAddresses;
    private final ShippingSection[] sections;
    private final ArrayBlockingQueue<AwsTask> queue;
    private final Thread thread = new WorkerThread();
    private final Logger log = Logger.getLogger("ShippingCenter");

    /**
     * Constructor for Shipping center
     * @param shippingCenterId      the shipping centerID assigned to order
     * @param validAddresses        array of valid cities that the shipping center will accept
     * @param sections              array of shipping sections that the center can send to
     */
    public ShippingCenter(String shippingCenterId, String[] validAddresses, ShippingSection[] sections)
    {
        this.shippingCenterId = shippingCenterId;
        this.validAddresses = validAddresses;
        this.sections = sections;
        this.queue = new ArrayBlockingQueue(10000);
        this.thread.start();
    }

    /* Called by the Shipping Dock to enque a new delivery task.
        If returns true, the truck wasn't full and the delivery can take place.
        Otherwise, it will return false.
    **/
    public boolean put(AwsTask task) {
        try {
            //Require delivery address to be on the valid-list of addresses.
            if (task.messageKind.equals("DELIVERY") && validAddresses.length > 0) {
                for(int i = 0; i < validAddresses.length; i++)
                {
                    if(task.address.equals(validAddresses[i])) //if the orders address matches a valid address for the center
                    {
                        task.shippingCenter = shippingCenterId; //assigns the shipping center id to the order
                        queue.put(task);
                        return true;
                    }
                }
                return false;
            }
            // Always deliver regardless of type of message. This will also take care
            // if we don't have any validAddresses (empty array).
            task.shippingCenter = shippingCenterId;
            queue.put(task);
        } catch(InterruptedException ex) {
            log.log(Level.WARNING, "ShippingCenter crashed", ex);
        }
        return true;
    }

    /**
     * Waits until the shipping sections are able to accept orders
     */
    public void waitUntilDone() {
        try {
            thread.join();
            for (int i = 0; i < sections.length; ++i) {
                sections[i].waitUntilDone();
            }
        } catch(InterruptedException ex) {
            log.log(Level.WARNING, "ShippingCenter crashed", ex);
        }
    }

    private class WorkerThread extends Thread {
        public void run() {
            try {
                while (true) {
                    AwsTask task = queue.poll(1, TimeUnit.SECONDS);
                    if (task != null) {
                        if (task.messageKind.equals("DELIVERY")) {
                            // find a section that can process this category
                            for (int i = 0; i < sections.length; ++i) {
                                if (sections[i].put(task)) {
                                    break; //breaks the for loop when it finds a section that will accept it
                                }
                            }
                        } else {
                            // this has to be "FINISHED"
                            for (int i = 0; i < sections.length; ++i) {
                                sections[i].put(task);
                            }
                            break; // stops the while loop
                        }
                    }
                }
            } catch(InterruptedException ex) {
                log.log(Level.WARNING, "Truck crashed", ex);
            }
        }
    }
}
