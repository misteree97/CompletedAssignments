import java.lang.*;
import java.util.*;

/**
 * @author Elliot Lohr
 * Represents a cash register object that will compute the change needed to be given to the customer
 */
public class ChangeComputer
{
    /**
     * The amount needed to be paid by the customer
     */
    private double totalAmount;
    /**
     * The amount the customer paid
     */
    private double customerAmount;
    /**
     * The number of twenty bills in the register
     */
    private int twentys = ((int)(Math.random() * 15)); //randomizes cash in cash register between 0-15 each
    /**
     * The number of ten bills in the register
     */
    private int tens = ((int)(Math.random() * 15));
    /**
     * The number of five bills in the register
     */
    private int fives = ((int)(Math.random() * 15));
    /**
     * The number of one bills in the register
     */
    private int ones = ((int)(Math.random() * 15));
    /**
     * The number of quarters in the register
     */
    private int quarters = ((int)(Math.random() * 15));
    /**
     * The number of dimes in the register
     */
    private int dimes = ((int)(Math.random() * 15));
    /**
     * The number of nickels in the register
     */
    private int nickels = ((int)(Math.random() * 15));
    /**
     * The number of pennys in the register
     */
    private int pennys = ((int)(Math.random() * 15));



    /**
     * No argument constructor that creates a change computer object
     */
    public ChangeComputer()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the price of the item");
        totalAmount = sc.nextDouble();
        System.out.println("Enter the amount paid");
        customerAmount = sc.nextDouble();
        //if customer doesn't pay enough, asks for more
        while(customerAmount < totalAmount)
        {
            System.out.println("You must enter an amount paid that is > the price of the item. Please enter amount paid again.");
            customerAmount = sc.nextDouble();
        }
    }

    /**
     * Displays the amount of bills/change in the cash register
     */
    public void displayCashRegister()
    {
        System.out.println("-------------------------");
        System.out.println("Cash Register Status");
        System.out.println("Twentys: " + twentys);
        System.out.println("Tens: " + tens);
        System.out.println("Fives: " + fives);
        System.out.println("Ones: " + ones);
        System.out.println("Quarters: " + quarters);
        System.out.println("Dimes: " + dimes);
        System.out.println("Nickels: " + nickels);
        System.out.println("Pennys: " + pennys);
        System.out.println("-------------------------");
    }

    /**
     * Method that updates the cash register to proper amounts, displays new cash register values and computes the change given.
     */
    public void payForItem()
    {
        double changeToGive = customerAmount - totalAmount;
        //looks to see if cash register can give any 20s for change, if it can updates cash register
        if(twentys > 0 && changeToGive >=20.00)
        {
            int twentysGiven = 0;
            while(changeToGive >= 20.00  && twentys > 0)
            {
                changeToGive = changeToGive - 20; //updates the amount of change that still needs to be give
                twentys--; //subtracts one $20 bill from register
                twentysGiven++;//updates the amount of $20 bills given to customer
            }
            System.out.println("Twenties Given: " + twentysGiven);
        }
        //looks to see if cash register can give any 10s for change
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
        //fives for change
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
        //ones for change
        if(ones > 0 && changeToGive >= 1.00)
        {
            int onesGiven = 0;
            while(changeToGive >= 1.00 && ones > 0)
            {
                changeToGive = changeToGive - 1;
                ones--;
                onesGiven++;
            }
            System.out.println("Ones Given: " + onesGiven);
        }
        //quarters for change
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
        //dimes for change
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
        //Nickels for change
        if(nickels > 0 && changeToGive >= .05)
        {
            int nickelsGiven = 0;
            while(changeToGive >= .05 && nickels > 0)
            {
                changeToGive = changeToGive -.05;
                nickels--;
                nickelsGiven++;
            }
            System.out.println("Nickels Given: " + nickelsGiven);
        }
        //Pennys for change
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
        //if cash register is empty and still need to give change, displays message and exits
        if(twentys == 0 && tens == 0 && fives == 0 && ones == 0 && quarters == 0 && dimes == 0 && nickels == 0 && pennys == 0 && changeToGive > 0.00)
        {
            System.out.println("Cash Register cannot provide the required change. Program will exit.");
            System.exit(0);
        }
    }

    /**
     * sets the total amount to be paid for the item
     * @param newAmount
     */
    public void setTotalAmount(double newAmount)
    {
        totalAmount = newAmount;
    }

    /**
     * sets the amount the customer paid to a new value
     * @param newCustomerAmount
     */
    public void setCustomerAmount(double newCustomerAmount)
    {
        customerAmount = newCustomerAmount;
    }

    /**
     * returns the total amount to be paid for the item
     * @return totalAmount      The price of the item
     */
    public double getTotalAmount()
    {
        return totalAmount;
    }

    /**
     * gets the amount the customer paid for the item
     * @return customerAmount   The amount the customer paid
     */
    public double getCustomerAmount()
    {
        return customerAmount;
    }
}
