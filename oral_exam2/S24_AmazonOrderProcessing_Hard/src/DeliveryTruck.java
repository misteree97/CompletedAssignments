import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeliveryTruck {
    private final String truckId;
    private final ArrayBlockingQueue<AwsTask> queue;
    private final Thread thread = new WorkerThread();
    private final Logger log = Logger.getLogger("TRUCK");

    public DeliveryTruck(String truckId, int capacity)
    {
        this.truckId = truckId;
        this.queue = new ArrayBlockingQueue(capacity);
        this.thread.start();
    }

    /* Called by the Shipping Dock to enque a new delivery task.
        If returns true, the truck wasn't full and the delivery can take place.
        Otherwise, it will return false.
    * */
    public boolean put(AwsTask task) {
        try {
            if (task.messageKind.equals("DELIVERY")) {
                return queue.offer(task);
            }
            queue.put(task);
        } catch(InterruptedException ex) {
            log.log(Level.WARNING, "Truck crashed", ex);
        }
        return true;
    }

    public void waitUntilDone() {
        try {
            thread.join();
        } catch(InterruptedException ex) {
            log.log(Level.WARNING, "Truck crashed", ex);
        }
    }

    private void printInformation(AwsTask task)
    {
        log.info(String.format("Delivery information:\n  Address: %s\n  Customer name: %s\n  Item ordered: %s\n  Category: %s\n  Shipping center: %s\n  Shipping section: %s\n  Delivery truck: %s",
                task.address, task.customerName, task.itemOrdered, task.category, task.shippingCenter, task.shippingSection, this.truckId));
        task.pendingTasks.decrementAndGet();
    }

    /* Simulates deliveries. Picks up tasks from the queue until the last task (aka FINISHED) is received. */
    private class WorkerThread extends Thread {
        public void run() {
            try {
                while (true) {
                    AwsTask task = queue.poll(1, TimeUnit.SECONDS);
                    if (task != null) {
                        if (task.messageKind.equals("DELIVERY")) {
                            // if we have a delivery to do, simulate route
                            // Thread.sleep(ThreadLocalRandom.current().nextInt(0, 11) * 1000);
                            Thread.sleep(ThreadLocalRandom.current().nextInt(0, 1) * 1000);
                            printInformation(task);
                        } else {
                            // this has to be "FINISHED"
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
