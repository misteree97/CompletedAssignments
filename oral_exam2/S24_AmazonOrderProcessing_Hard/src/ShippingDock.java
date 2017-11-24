import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Elliot Lohr
 * This class provides a blueprint for a Shipping Dock node, which receives orders from the ShippingSections and sends them to available DeliveryTrucks
 */
public class ShippingDock  {
    /**
     * Array of delivery trucks that the shipping dock can send orders to
     */
    private final DeliveryTruck[] trucks;
    /**
     * Thread
     */
    private final Thread thread = new WorkerThread();
    /**
     * queue used to queue tasks while they are completed
     */
    private final ArrayBlockingQueue<AwsTask> queue;
    /**
     * Thread safe output
     */
    private final Logger log = Logger.getLogger("ShippingDock");

    /**
     * Constructor for a Shipping dock
     * @param trucks an array of delivery trucks
     */
    public ShippingDock(DeliveryTruck[] trucks) {
        this.trucks = trucks;
        this.queue = new ArrayBlockingQueue(10000); // really big queue buffer because the dock doesn't seem to have a space constraint
        this.thread.start();
    }

    /* Invoked by the Shipping Section to dispatch to one of its trucks. */
    public void put(AwsTask task) {
        try {
            queue.put(task);
        } catch(InterruptedException ex) {
            log.log(Level.WARNING, "Shipping dock crashed", ex);
        }
    }

    /**
     * Method that waits until the threads are processed through the node
     */
    public void waitUntilDone() {
        try {
            thread.join();
        } catch(InterruptedException ex) {
            log.log(Level.WARNING, "Shipping dock crashed", ex);
        }
    }

    /* Simulates deliveries. Picks up tasks from the queue until the last task (aka FINISHED) is received. */
    private class WorkerThread extends Thread {
        private void notifyAllTrucks(AwsTask task) {
            for(int i = 0; i < trucks.length; i++) {
                trucks[i].put(task);
            }
        }

        /**
         * Method that waits for trucks to finish deliveries
         */
        private void waitForAllTrucksToFinish() {
            for(int i = 0; i < trucks.length; i++) {
                trucks[i].waitUntilDone();
            }
        }

        /**
         * Assigns a task to an available truck
         * @param task
         */
        private void assignToNextAvailableTruck(AwsTask task) {
            try {
                boolean pickedUp = false;
                while (!pickedUp) {
                    for (int i = 0; i < trucks.length; i++) {
                        pickedUp = trucks[i].put(task);
                        if (pickedUp) {
                            break;
                        }
                    }
                    if (!pickedUp) {
                        Thread.sleep(1000);
                    }
                }
            } catch(InterruptedException ex) {
                log.log(Level.WARNING, "Shipping dock crashed", ex);
            }
        }

        /**
         * Takes tasks from the queue and assigns it to available trucks
         */
        public void run() {
            try {
                while (true) {
                    AwsTask task = queue.poll(1, TimeUnit.SECONDS);
                    if (task != null) {
                        if (task.messageKind.equals("DELIVERY")) {
                            assignToNextAvailableTruck(task);
                        } else {
                            // this has to be "FINISHED"
                            notifyAllTrucks(task);
                            waitForAllTrucksToFinish();
                            break;
                        }
                    }
                }
            } catch(InterruptedException ex) {
                log.log(Level.WARNING, "Truck crashed", ex);
            }
        }
    }
}
