public class BucketSort {
    static int size = 12;
    public static void main(String[] args)
    {
        int size = 12;
        int oneDArray[] = new int[size];

        for(int i = 0; i < oneDArray.length; i++)
        {
            oneDArray[i] =(int)Math.random() * 100;
        }
        System.out.println("Original Array: ");
        for(int i = 0; i < oneDArray.length; i++)
        {
            System.out.print(oneDArray[i] + ", ");
        }
    }
    public static void sort(int arrayToSort[])
    {
        int bucket[][] = new int[10][size];
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
            distributePass();
            gatheringPass();
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
        for(int i = 0; i < size; i++)
        {

        }
    }
    public static void gatheringPass()
    {

    }
}
