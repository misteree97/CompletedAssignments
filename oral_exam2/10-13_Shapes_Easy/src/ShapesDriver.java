public class ShapesDriver {
    private Shape testArray[] = new Shape[4];
    private TwoDShape twoDArray[] = new TwoDShape[2];
    private ThreeDShape threeDArray[] = new ThreeDShape[2];

    public ShapesDriver()
    {
        Circle testCircle = new Circle (10,30, 40);
        Cube testCube = new Cube(20,40, 25);
        Sphere testSphere = new Sphere(25, 50, 35);
        Square testSquare = new Square(40, 55, 20);


        testArray[0] = testCircle;
        testArray[1] = testCube;
        testArray[2] = testSphere;
        testArray[3] = testSquare;


        twoDArray[0] = testCircle;
        twoDArray[1] = testSquare;

        threeDArray[0] = testCube;
        threeDArray[1] = testSphere;


    }
    public void displayInfo()
    {
        for(int i = 0; i < testArray.length; i++)
        {
            System.out.println(testArray[i].getName() + ": ");
            testArray[i].print();
            System.out.println();
        }
        for(int i = 0; i < twoDArray.length; i++)
        {
            System.out.println(twoDArray[i].getName() + "'s area = " + twoDArray[i].computeArea());
        }
        for(int i = 0; i < threeDArray.length; i++)
        {
            System.out.println(threeDArray[i].getName() + "'s volume = " + threeDArray[i].computeVolume());
        }
    }

    public static void main(String [] args)
    {
        ShapesDriver test = new ShapesDriver();
        test.displayInfo();
    }
}
