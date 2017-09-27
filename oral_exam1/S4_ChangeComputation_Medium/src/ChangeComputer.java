import java.lang.*;
import java.util.*;
public class ChangeComputer
{
    private double totalAmount;
    private double customerAmount;
    private int twentys = ((int)(Math.random() * 15));
    private int tens = ((int)(Math.random() * 15));
    private int fives = ((int)(Math.random() * 15));
    private int ones = ((int)(Math.random() * 15));
    private int quarters = ((int)(Math.random() * 15));
    private int dimes = ((int)(Math.random() * 15));
    private int nickels = ((int)(Math.random() * 15));
    private int pennys = ((int)(Math.random() * 15));


    public ChangeComputer()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the price of the item");
        totalAmount = sc.nextDouble();
        System.out.println("Enter the amount paid");
        customerAmount = sc.nextDouble();
        while(customerAmount < totalAmount)
        {
            System.out.println("You must enter an amount paid that is > the price of the item. Please enter amount paid again.");
            customerAmount = sc.nextDouble();
        }
    }
    public void displayCashRegister()
    {
        System.out.println("Cash Register Status");
        System.out.println("Twentys: " + twentys);
        System.out.println("Tens: " + tens);
        System.out.println("Fives: " + fives);
        System.out.println("Ones: " + ones);
        System.out.println("Quarters: " + quarters);
        System.out.println("Dimes: " + dimes);
        System.out.println("Nickels: " + nickels);
        System.out.println("Pennys: " + pennys);
        System.out.println("");
    }
    public void payForItem()
    {
        double changeToGive = customerAmount - totalAmount;
        if(twentys > 0 && changeToGive >=20.00)
        {
            int twentysGiven = 0;
            //int twentysDivisable = ((int)changeToGive/20);
            while(changeToGive >= 20.00  && twentys > 0)
            {
                changeToGive = changeToGive - 20;
                twentys--;
                twentysGiven++;
            }
            System.out.println("Twenties Given: " + twentysGiven);
        }
        if(tens > 0 && changeToGive >= 10.00)
        {
            int tensGiven = 0;
            while(changeToGive >= 10.00 && tens > 0)
            {
                changeToGive = changeToGive - 10;
                tens--;
                tensGiven++;
            }
            System.out.println("Tens Given: " + tensGiven);
        }
        if(fives > 0 && changeToGive >= 5.00)
        {
            int fivesGiven = 0;
            while(changeToGive >= 5.00 && fives > 0)
            {
                changeToGive = changeToGive - 5;
                fives--;
                fivesGiven++;
            }
            System.out.println("Fives Given: " + fivesGiven);
        }
        if(ones > 0 && changeToGive >= 1.00)
        {
            int onesGiven = 0;
            //int onesDivisable = (int)totalAmount;
            while(changeToGive >= 1.00 && ones > 0)
            {
                changeToGive = changeToGive - 1;
                ones--;
                onesGiven++;
            }
            System.out.println("Ones Given: " + onesGiven);
        }
        if(quarters > 0 && changeToGive >= .25)
        {
            int quartersGiven = 0;
            while(changeToGive >= .25 && quarters > 0)
            {
                changeToGive = changeToGive - .25;
                quarters--;
                quartersGiven++;
            }
            System.out.println("Quarters Given: " + quartersGiven);
        }
        if(dimes > 0 && changeToGive >= .10)
        {
            int dimesGiven = 0;
            while(changeToGive >= .10 && dimes > 0)
            {
                changeToGive = changeToGive - .1;
                dimes--;
                dimesGiven++;
            }
            System.out.println("Dimes Given: " + dimesGiven);
        }
        if(nickels > 0 && changeToGive >= .05)
        {
            int nickelsGiven = 0;
            //int nickelsDivisable = (int)(totalAmount / .05);
            while(changeToGive >= .05 && nickels > 0)
            {
                changeToGive = changeToGive -.05;
                nickels--;
                nickelsGiven++;
            }
            System.out.println("Nickels Given: " + nickelsGiven);
        }
        if(pennys > 0 && changeToGive >= .01)
        {
            int pennysGiven = 0;
            while(changeToGive >= .01 && pennys > 0)
            {
                changeToGive = changeToGive -.01;
                pennys--;
                pennysGiven++;
            }
            System.out.println("Pennies Given: " + pennysGiven);
        }
        displayCashRegister();
    }
}
