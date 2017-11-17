public class BucketSort {
    static int size = 12;
    public static void main(String[] args)
    {
        int oneDArray[] = new int[size];

        for(int i = 0; i < size; i++)
        {
            oneDArray[i] =(int)(Math.random() * 100);
        }
        System.out.println("Original Array: ");
        for(int i = 0; i < size; i++)
        {
            System.out.print(oneDArray[i] + ", ");
        }
        sort(oneDArray);
        System.out.println("Sorted Array: ");
        for(int i = 0; i < size; i++)
        {
            System.out.print(oneDArray[i] + ", ");
        }
    }
    public static void sort(int arrayToSort[])
    {
        int bucket[][] = new int[10][12];
        int greatestNumber = arrayToSort[0];
        int numberOfDigits = 0;


        for(int i = 0; i < arrayToSort.length; i++)
        {
            if(arrayToSort[i] > greatestNumber)
            {
                greatestNumber = arrayToSort[i];
            }
        }
        while(greatestNumber != 0)
        {
            numberOfDigits++;
            greatestNumber = greatestNumber / 10;
        }
        for(int i = 0; i <= numberOfDigits; i++)
        {
            distributePass(arrayToSort, bucket, i);
            gatheringPass(arrayToSort, bucket);

            if(i != numberOfDigits)
            {
                clearBucket(bucket);
            }

        }
    }
    public static void distributePass(int arrayToSort[], int bucket[][], int num)
    {
        int arrayNum, bucketNum; 
        int divider = 10;
        int count = 0;
        while(count!=num)
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
    public static void gatheringPass(int arrayToSort[], int bucket[][])
    {
        int counter = 0;
        for(int i = 0; i < 10; i++)
        {
            for(int j = 1; j < bucket[i][0]; j++)
            {
                arrayToSort[counter++] = bucket[i][j];
            }
        }
    }
    public static void clearBucket(int bucket[][])
    {
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 12; j++)
            {
                bucket[i][j] = 0;
            }
        }

    }
}
