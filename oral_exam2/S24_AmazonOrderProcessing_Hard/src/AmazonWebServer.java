import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Elliot Lohr
 * This class provides a blueprint for a AmazonWebServer node which reads in orders from a
 * file and sends them to the shipping centers depending on which city the order is going to
 */
public class AmazonWebServer {
    private final ShippingCenter[] shippingCenters;
    private final ArrayBlockingQueue<AwsTask> queue;
    private final Thread thread = new WorkerThread();
    private final Logger log = Logger.getLogger("AWS");
    private final AtomicBoolean finishedParsing = new AtomicBoolean(false);

    /**
     * Constructor for an AmazonWebServer
     * @param fileName
     * @param shippingCenters
     */
    public AmazonWebServer(String fileName, ShippingCenter[] shippingCenters)
    {
        this.shippingCenters = shippingCenters;
        this.queue = new ArrayBlockingQueue(10000);

        try {
            //wakes up thread and puts it in running state
            this.thread.start();

            //reads the file in and assigns the order information to variables
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                int i = 0;
                // Build a task from parsing a line.
                while ((line = br.readLine()) != null) {
                    if (i++ == 0) continue; // skip header
                    //assigns order information to variables
                    List<String> rec = Arrays.asList(line.split(","));
                    AwsTask task = new AwsTask();
                    task.address = rec.get(1);
                    task.customerName = rec.get(4);
                    task.itemOrdered = rec.get(5);
                    task.category = rec.get(6);
                    task.messageKind = "DELIVERY";
                    // queue up the task
                    queue.put(task);
                }
                finishedParsing.set(true);
            }
        } catch(Exception ex) {
            log.log(Level.WARNING, "Web server crashed", ex);
        }
    }

    public void waitUntilDone() {
        try {
            thread.join();

            // wait for all delivery tasks to run through the system
            // before sending "FINISHED" message to all nodes
            while (AwsTask.pendingTasks.get() > 0) {
                Thread.sleep(1000);
                //log.info("Pending deliveries: #"+Integer.toString(AwsTask.pendingTasks.get()));
            }

            // Once all deliveries are made, queue up FINISHED task.
            AwsTask doneTask = new AwsTask();
            doneTask.messageKind = "FINISHED";

            //sends the FINISHED message to the shipping centers
            for (int i = 0; i < shippingCenters.length; ++i) {
                shippingCenters[i].put(doneTask);
            }
        } catch(InterruptedException ex) {
            log.log(Level.WARNING, "Truck crashed", ex);
        }
    }

    private class WorkerThread extends Thread {
        public void run() {
            try {
                while ( !(finishedParsing.get() == true && queue.isEmpty()) ) {     //while the queue isn't empty, continue
                    AwsTask task = queue.poll(1, TimeUnit.SECONDS); //pulls tasks from the head of queue
                    if (task != null) {
                        //sends tasks to the shipping centers
                        for (int i = 0; i < shippingCenters.length; ++i) {
                            if (shippingCenters[i].put(task)) {
                                // log.info(String.format("shipped by %d, task ID %s", i, task.customerName));
                                break;
                            }else {
                                // log.info(String.format("rejected by %d, task ID %s", i, task.customerName));
                            }
                        }
                    }
                }
            } catch(InterruptedException ex) {
                log.log(Level.WARNING, "AWS crashed", ex);
            }
        }
    }
}
