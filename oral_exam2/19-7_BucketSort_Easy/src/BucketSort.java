/**
 * @author Elliot Lohr
 * This class provides the functionality for a bucket sort
 */
public class BucketSort
{
    /**
     * The size of the array
     */
    int size;
    /**
     * Array that needs to be sorted;
     */
    int oneDArray[];

    /**
     * Constructor for a bucketsort object
     * @param array     the array that needs to be sorted
     */
    public BucketSort(int array[])
    {
        this.oneDArray = array;
        size = array.length;
    }

    /**
     * Sort method that takes in array and sorts it
     * @param arrayToSort
     */
    public void sort(int arrayToSort[])
    {
        //bucket array used to organize number by last digit
        int bucket[][] = new int[10][12];
        int greatestNumber = oneDArray[0];
        int numberOfDigits = 0;

        //finds the greatest number in the array
        for(int i = 0; i < size; i++)
        {
            if(arrayToSort[i] > greatestNumber)
            {
                greatestNumber = arrayToSort[i];
            }
        }
        //Determines how many digits are in the number
        while(greatestNumber != 0)
        {
            numberOfDigits++;
            greatestNumber = greatestNumber / 10;
        }
        //go through every number and sort the numbers based off the value of their ones place
        for(int j = 1; j <= numberOfDigits; j++)
        {
            //places each value value of one dimensional array into a row of bucket array depending on the values rightmost digit
            distributePass(arrayToSort, bucket, j);
            //copies the values back to the original array
            gatheringPass(arrayToSort, bucket);

            //clears bucket if there is still another digits place to sort
            if(j != numberOfDigits)
            {
                clearBucket(bucket);
            }
        }
    }

    /**
     * Distributing pass method for a bucket sort
     * @param arrayToSort   the array of numbers that need to be sorted
     * @param bucket        the bucket array used to organize numbers
     * @param num
     */
    public void distributePass(int arrayToSort[], int bucket[][], int num)
    {
        int arrayNum, bucketNum; 
        int divider = 10;
        int count = 1;

        //determines the divisor to get the correct digit
        while(count<num)
        {
            divider = divider*10;
            count++;
        }
        for(int i = 0; i < 12; i++)
        {

            bucketNum = (arrayToSort[i] % divider - arrayToSort[i] % (divider/10))/(divider/10); //Received help retrieving which bucket to place the number in from John Carlson
            //determines which row element to store the number in
            arrayNum = ++bucket[bucketNum][0];
            //stores number in the bucket array according to which bucket number and the arrayNumber
            bucket[bucketNum][arrayNum] = arrayToSort[i];
        }
    }

    /**
     * Gathering pass, which takes the bucket array and puts the values back in the original array
     * @param arrayToSort   the original array that needed to be sorted
     * @param bucket        the bucket that has the numbers organized by digit
     */
    public void gatheringPass(int arrayToSort[], int bucket[][])
    {
        int counter = 0;
        for(int i = 0; i < 10; i++)
        {
            for(int j = 1; j <= bucket[i][0]; j++)
            {
                //places the sorted values from the bucket back into original array
                arrayToSort[counter++] = bucket[i][j];
            }
        }
    }

    /**
     * Clears the bucket array
     * @param bucket
     */
    public static void clearBucket(int bucket[][])
    {
        //sets each value in the bucket array to 0
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 12; j++)
            {
                bucket[i][j] = 0;
            }
        }

    }
}
