import java.awt.*;

/**
 * @author Elliot Lohr
 * This class will test the circle cube, square and line classes to demonstrate proper inheritance
 */
public class InheritanceTester {
    /**
     * Main method that creates shape objects and tests methods in the classes
     * @param args
     */
    public static void main(String[] args)
    {
        int xCoord = 10;
        int yCoord = 10;
        double radius = 5.0;
        System.out.println("Test Circle Class");
        Circle circle = new Circle(xCoord,yCoord,"Test Circle", Color.BLACK, radius);
        System.out.println("XCoord: " + circle.getXCoord() + " YCoord: " + circle.getYCoord() + " Name: " + circle.getName() + " Color: " + circle.getColor() + " Area: " + circle.getArea() + " Perimeter: " + circle.getPerimeter());
        System.out.println("Test Square Class");
        Square square = new Square(xCoord,yCoord, "Test square", Color.RED, radius);//creates a square with side length 5
        System.out.println("XCoord: " + square.getXCoord() + " YCoord: " + square.getYCoord() + " Name: " + square.getName() + " Color: " + square.getColor() + " Area: " + square.getArea() + " Perimeter: " + square.getPerimeter());
        System.out.println("Test Cube Class");
        Cube cube = new Cube(xCoord,yCoord,"Test Cube", Color.GREEN, radius);
        System.out.println("XCoord: " + cube.getXCoord() + " YCoord: " + cube.getYCoord() + " Name: " + cube.getName() + " Color: " + cube.getColor() + " Volume: " + cube.getVolume() + " Surface Area: " + cube.getSurfaceArea());
        System.out.println("Test Line Class");
        Line line = new Line(xCoord,yCoord,"Test Line", Color.ORANGE, radius);
        System.out.println("XCoord: " + line.getXCoord() + " YCoord: " + line.getYCoord() + " Name: " + line.getName() + " Color: " + line.getColor() + " Length: " + line.getLength());




    }
}
