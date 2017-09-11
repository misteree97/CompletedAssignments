/**
 * Programmer: Elliot Lohr
 * Date: 09/07/17
 * Description: Program that rounds a user input double to an integer, as well as tens, hundedths and thousandths place
 */

import java.util.Scanner;

public class RoundNum {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number with at least 3 decimal places to round");
        double unroundedNumber = sc.nextDouble();
        double tenths =RoundToTenths(unroundedNumber);
        double hundredths = RoundToHundredths(unroundedNumber);
        double thousandths = RoundToThousandths(unroundedNumber);
        int integer = RoundToInteger(unroundedNumber);
        System.out.println("Rounded to Thousandths: " + thousandths);
        System.out.println("Rounded to Hundredths: " + hundredths);
        System.out.println("Rounded to Tenths: " + tenths);
        System.out.println("Rounded to Integer: " + integer);
    }

    public static double RoundToTenths(double number)
    {
        double y = Math.floor((number*10)+.5)/10;
        return y;
    }
    public static double RoundToHundredths(double number)
    {
        double y = Math.floor((number*100)+.5)/100;
        return y;
    }
    public static double RoundToThousandths(double number)
    {
        double y = Math.floor((number*1000)+.5)/1000;
        return y;
    }
    public static int RoundToInteger(double number)
    {
        int y =(int)Math.floor((number*1)+.5)/1;
        return y;
    }
}
