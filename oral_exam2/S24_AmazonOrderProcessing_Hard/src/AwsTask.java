import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class provides the blueprint for an order from amazon
 */
public class AwsTask
{
    /**
     * Constructor for an AwsTask
     */
    AwsTask()
    {
        // When creating a task ncrement the number of pending tasks
        AwsTask.pendingTasks.incrementAndGet();
    }

    /**
     * The address of the order
     */
    public String address;
    /**
     * The customers name
     */
    public String customerName;
    /**
     * The item the customer ordered
     */
    public String itemOrdered;
    /**
     * The Item's category
     */
    public String category;
    /**
     * Shipping Center tag that is assigned when order passes through a shipping center
     */
    public String shippingCenter;
    /**
     * Shipping Section tag that is assigned when order passes through a shipping section
     */
    public String shippingSection;
    /**
     * Message that helps nodes know whether the order is a delivery or if the done message has been sent to shut down nodes
     */
    public String messageKind; // DELIVERY, FINISHED
    // Used for debugging to determine if all files have been delivered
    public static AtomicInteger pendingTasks = new AtomicInteger(); //Received help learning about Atomic Integer from my uncle John Carlson
}