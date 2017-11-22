/**
 * @author Elliot Lohr
 * This class tests the BucketSort class
 */
public class BucketSortTester {
    public static void main(String[] args)
    {
        int testArray[] = new int[12];
        for(int i = 0; i < 12; i++)
        {
            testArray[i] =(int)(Math.random() * 100);
        }
        System.out.println("Original Array: ");
        for(int i = 0; i < 12; i++)
        {
            System.out.print(testArray[i] + ", ");
        }
        BucketSort buckets = new BucketSort(testArray);
        buckets.sort(testArray);

        System.out.println("\nSorted Array: ");
        for(int i = 0; i < 12; i++)
        {
            System.out.print(testArray[i] + ", ");
        }


    }
}
