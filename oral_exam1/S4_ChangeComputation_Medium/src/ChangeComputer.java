import java.lang.*;
public class ChangeComputer {
    //private float totalAmount;
    //private float customerAmount;
    private int twentys = ((int)(Math.random() * 15) + 1);
    private int tens = ((int)(Math.random() * 15) + 1);
    private int fives = ((int)(Math.random() * 15) + 1);
    private int ones = ((int)(Math.random() * 15) + 1);
    private int quarters = ((int)(Math.random() * 15) + 1);
    private int dimes = ((int)(Math.random() * 15) + 1);
    private int nickels = ((int)(Math.random() * 15) + 1);
    private int pennys = ((int)(Math.random() * 15) + 1);


    public ChangeComputer()
    {

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
    }
    public void payForItem(double itemPrice, double customerPaid)
    {
        if(twentys > 0)
        {
            int twentysDivisable = ((int)itemPrice/20);
            while(twentys > twentysDivisable && twentys > 0)
            {
                itemPrice = itemPrice % twentysDivisable;
                twentys--;
            }
        }
        if(tens > 0 )
        {
            int tensDivisable = ((int) itemPrice / 10);
            while(tens > tensDivisable && tens > 0)
            {
                itemPrice = itemPrice % tensDivisable;
                tens--;
            }
        }
        if(fives > 0)
        {
            int fivesDivisable = ((int) itemPrice / 5);
            while(fives > fivesDivisable && fives > 0)
            {
                itemPrice = itemPrice % fivesDivisable;
                fives--;
            }
        }
        if(ones > 0)
        {
            int onesDivisable = (int)itemPrice;
            while(ones > onesDivisable && ones > 0)
            {
                itemPrice = itemPrice % onesDivisable;
                ones--;
            }
        }
        if(quarters > 0)
        {
            int quartersDivisable = ((int)itemPrice / .25);
            while(quarters > quartersDivisable && quarters > 0)
            {
                itemPrice = itemPrice % quartersDivisable;
                quarters--;
            }
        }
        if(dimes > 0)
        {
            int dimesDivisable = ((int) itemPrice / .1);
            while(dimes > dimesDivisable && dimes > 0)
            {
                itemPrice = itemPrice % dimesDivisable;
                dimes--;
            }
        }
        if(nickels > 0)
        {
            int nickelsDivisable = ((int) itemPrice / .05);
            while(fives > nickelsDivisable && fives > 0)
            {
                itemPrice = itemPrice % nickelsDivisable;
                nickels--;
            }
        }
        if(pennys > 0)
        {
            int pennysDivisable = ((int) itemPrice / .01);
            while(pennys > pennysDivisable && pennys > 0)
            {
                itemPrice = itemPrice % pennysDivisable;
                pennys--;
            }
        }


    }

    public void cashRegister()
    {

    }


}
