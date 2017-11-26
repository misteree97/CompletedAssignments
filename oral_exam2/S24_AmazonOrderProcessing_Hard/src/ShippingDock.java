import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Elliot Lohr
 * This class provides a blueprint for a Shipping Dock node, which receives orders from the ShippingSections and sends them to available DeliveryTrucks
 */
class ShippingDock {
    /**
     *Array of DeliveryTrucks that the ShippingDock can send orders to
     */
    private final DeliveryTruck[] trucks;
    /**
     *
     */
    private final Thread thread = new WorkerThread();
    /**
     *Queue used as a buffer between nodes
     */
    private final ArrayBlockingQueue<AwsTask> queue;
    /**
     *Thread safe output to console
     */
    private final Logger log = Logger.getLogger("ShippingDock");
    /**
     * Used to diagnose bugs
     */
    private final AtomicInteger feedCount = new AtomicInteger();

    /**
     * Constructor for a ShippingDock object
     * @param trucks    array of trucks that dock can send orders to
     */
    public ShippingDock(DeliveryTruck[] trucks)
    {
        this.trucks = trucks;
        this.queue = new ArrayBlockingQueue(10000); // really big queue buffer because the dock doesn't have a space constraint
        this.thread.start();
    }

    /* Invoked by the Shipping Section to dispatch to one of its trucks. */

    /**
     * Called in shipping section to enqueue a new delivery task
     * @param task
     */
    public void put(AwsTask task)
    {
        try
        {
            //gives task to the delivery truck
            queue.put(task);
        }
        catch(InterruptedException ex)
        {
            log.log(Level.WARNING, "Shipping dock crashed", ex);
        }
    }

    /**
     * Joins the shipping section thread with the shipping dock thread
     */
    public void waitUntilDone()
    {
        try
        {
            thread.join(); //joins the shipping section thread with the shipping dock thread
        }
        catch(InterruptedException ex)
        {
            log.log(Level.WARNING, "Shipping dock crashed", ex);
        }
    }

    /**
     * When a new shipping section is created, feedCount is incremented so the dock knows how many done messages should be received
     */
    public void incrementFeedCount()
    {
        feedCount.incrementAndGet();
    }

    /**
     * Takes tasks from queue and gives to an available delivery truck, stops when doneTask is received
     */
    private class WorkerThread extends Thread
    {
        private void notifyAllTrucks(AwsTask task)
        {
            for(int i = 0; i < trucks.length; i++)
            {
                trucks[i].put(task); //gives tasks to the delivery truck that is available
            }
        }

        /**
         *
         */
        private void waitForAllTrucksToFinish()
        {
            for(int i = 0; i < trucks.length; i++) {
                trucks[i].waitUntilDone();
            }
        }

        private void assignToNextAvailableTruck(AwsTask task) {
            try {
                boolean pickedUp = false;
                while (!pickedUp) {
                    for (int i = 0; i < trucks.length; i++) {
                        pickedUp = trucks[i].put(task); //gives order to truck, returns false if the order hasn't been picked up
                        if (pickedUp) {
                            break; //breaks for loop once order picked up
                        }
                    }
                    if (!pickedUp) {
                        Thread.sleep(1000); //if the order hasn't been picked up, wait until it can be picked up
                    }
                }
            } catch(InterruptedException ex) {
                log.log(Level.WARNING, "Shipping dock crashed", ex);
            }
        }

        public void run() {
            try {
                while (true) {
                    AwsTask task = queue.poll(1, TimeUnit.SECONDS); //pulls a task from the queue
                    if (task != null) {
                        if (task.messageKind.equals("DELIVERY")) {
                            assignToNextAvailableTruck(task); //assigns orders to the next available truck
                        } else {
                            // On "FINISHED" message, decrement feed-count and
                            // if no more Stations are left, shutdown Trucks.
                            if (feedCount.decrementAndGet() < 1) { //Only notify trucks to shutdown if feedCount reaches 0
                                notifyAllTrucks(task); //once all sections are finished processing orders, notify trucks with done task
                                waitForAllTrucksToFinish();
                                break;
                            }
                        }
                    }
                }
            } catch(InterruptedException ex) {
                log.log(Level.WARNING, "ShippingDock crashed", ex);
            }
        }
    }
}
