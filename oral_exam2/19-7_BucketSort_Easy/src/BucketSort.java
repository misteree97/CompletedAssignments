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
    public void distributePass(int arrayToSort[], int bucket[][], int num)
    {
        int arrayNum, bucketNum; 
        int divider = 10;
        int count = 1;

        while(count<num)
        {
            divider = divider*10;
            count++;
        }
        for(int i = 0; i < 12; i++)
        {
            bucketNum = (arrayToSort[i] % divider - arrayToSort[i] % (divider/10))/(divider/10);
            arrayNum = ++bucket[bucketNum][0];
            bucket[bucketNum][arrayNum] = arrayToSort[i];
        }
    }
    public void gatheringPass(int arrayToSort[], int bucket[][])
    {
        int counter = 0;
        for(int i = 0; i < 10; i++)
        {
            for(int j = 1; j <= bucket[i][0]; j++)
            {
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
