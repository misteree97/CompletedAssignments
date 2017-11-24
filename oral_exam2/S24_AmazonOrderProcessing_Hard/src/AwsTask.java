import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class provides the blueprint for an order from amazon
 */
public class AwsTask
{
    public String address;
    public String customerName;
    public String itemOrdered;
    public String category;
    public String shippingCenter;
    public String shippingSection;
    public String messageKind; // DELIVERY, FINISHED
    public static AtomicInteger pendingTasks = new AtomicInteger();

    AwsTask() {
        // When creating a task, we increment the number of pending tasks.
        AwsTask.pendingTasks.incrementAndGet();
    }
}