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
public class AmazonWebServer
{
    /**
     * an array of ShippingCenters that the webserver can send orders to
     */
    private final ShippingCenter[] shippingCenters;
    /**
     * queue used as a buffer between nodes
     */
    private final ArrayBlockingQueue<AwsTask> queue;
    /**
     * thread that runs until it finds a shippingCenter that will accept the order
     */
    private final Thread thread = new WorkerThread();
    /**
     * Thread safe output to console
     */
    private final Logger log = Logger.getLogger("AWS"); //Learned Logger from http://www.vogella.com/tutorials/Logging/article.html
    /**
     * Atomic boolean tracks whether the filereader is done parsing
     */
    private final AtomicBoolean finishedParsing = new AtomicBoolean(false);

    /**
     * Constructor for an AmazonWebServer
     * @param fileName  the name of the file being read from
     * @param shippingCenters   array of ShippingCenters that the webserver can send orders to
     */
    public AmazonWebServer(String fileName, ShippingCenter[] shippingCenters)
    {
        this.shippingCenters = shippingCenters;
        this.queue = new ArrayBlockingQueue(10000); //Queue has large capacity because there are no limitations on WebServer capacity

        try
        {
            this.thread.start();
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) //learned how to use BufferedReader and FileReader from https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
            {
                String line;
                int i = 0;
                // Build a task from parsing a line.
                while ((line = br.readLine()) != null)
                {
                    if (i++ == 0) continue; // skip header
                    List<String> list = Arrays.asList(line.split(","));
                    AwsTask task = new AwsTask();
                    task.address = list.get(1);
                    task.customerName = list.get(4);
                    task.itemOrdered = list.get(5);
                    task.category = list.get(6);
                    task.messageKind = "DELIVERY"; //assigns delivery message so nodes know that this is an order and not the done message to notify nodes to shutdown
                    // queue up the task
                    queue.put(task);
                }
                finishedParsing.set(true); //once file has been read, set to true
            }
        }
        catch(Exception ex)
        {
            log.log(Level.WARNING, "Web server crashed", ex);
        }
    }

    /**
     * Method to join the AmazonWebServer threads with the main thread, waits for the nodes to join threads
     */
    public void waitUntilDone()
    {
        try
        {
            thread.join(); // joins the amazonwebserver thread and the main thread
            for (int i = 0; i < shippingCenters.length; i++)
            {
                shippingCenters[i].waitUntilDone();
            }
        }
        catch(InterruptedException ex)
        {
            log.log(Level.WARNING, "Web server crashed", ex);
        }
    }

    /**
     * Thread created that holds information about AWStasks and pulls information from queue and assigns it to the correct ShippingCenter
     */
    private class WorkerThread extends Thread
    {
        /**
         * Runs thread until it finds a shippingCenter to assign the task, then terminates thread
         */
        public void run()
        {
            try
            {
                //while server is not finished reading file and the queue is not empty, create more orders
                while(!(finishedParsing.get() == true && queue.isEmpty()))
                {
                    AwsTask task = queue.poll(1, TimeUnit.SECONDS); //takes orders from the queue
                    if (task != null)
                    {
                        for(int i = 0; i < shippingCenters.length; i++)
                        {
                            if(shippingCenters[i].put(task))//assigns tasks to the shipping center that fits the city constraints
                            {
                                break;
                            }
                        }
                    }
                }

                // Once all deliveries are scheduled, queue FINISHED task.
                AwsTask doneTask = new AwsTask();
                doneTask.messageKind = "FINISHED";
                //notifies shipping centers that all orders have been processed
                for (int i = 0; i < shippingCenters.length; i++)
                {
                    shippingCenters[i].put(doneTask);
                }

            }
            catch(InterruptedException ex)
            {
                log.log(Level.WARNING, "AWS crashed", ex);
            }
        }
    }
}
