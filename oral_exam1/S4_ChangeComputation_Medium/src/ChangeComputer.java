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
        if(twentys > 0)
        {
            int twentysDivisable = ((int)totalAmount/20);
            while(twentysDivisable >twentys  && twentys > 0)
            {
                totalAmount = totalAmount % twentysDivisable;
                twentys--;
            }
        }
        if(tens > 0 )
        {
            int tensDivisable = ((int) totalAmount / 10);
            while(tensDivisable > tens && tens > 0)
            {
                totalAmount = totalAmount % tensDivisable;
                tens--;
            }
        }
        if(fives > 0)
        {
            int fivesDivisable = ((int) totalAmount / 5);
            while(fivesDivisable > fives && fives > 0)
            {
                totalAmount = totalAmount % fivesDivisable;
                fives--;
            }
        }
        if(ones > 0)
        {
            int onesDivisable = (int)totalAmount;
            while(ones > onesDivisable && ones > 0)
            {
                totalAmount = totalAmount % onesDivisable;
                ones--;
            }
        }
        if(quarters > 0)
        {
            int quartersDivisable = (int)(totalAmount / .25);
            while(quarters > quartersDivisable && quarters > 0)
            {
                totalAmount = totalAmount % quartersDivisable;
                quarters--;
            }
        }
        if(dimes > 0)
        {
            int dimesDivisable = (int)(totalAmount / .1);
            while(dimes > dimesDivisable && dimes > 0)
            {
                totalAmount = totalAmount % dimesDivisable;
                dimes--;
            }
        }
        if(nickels > 0)
        {
            int nickelsDivisable = (int)(totalAmount / .05);
            while(fives > nickelsDivisable && fives > 0)
            {
                totalAmount= totalAmount % nickelsDivisable;
                nickels--;
            }
        }
        if(pennys > 0)
        {
            int pennysDivisable = (int)(totalAmount / .01);
            while(pennys > pennysDivisable && pennys > 0)
            {
                totalAmount = totalAmount % pennysDivisable;
                pennys--;
            }
        }
        displayCashRegister();
    }
}
