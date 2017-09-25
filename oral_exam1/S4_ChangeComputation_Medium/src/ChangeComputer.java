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
            float twentysDivisable = ((int)itemPrice/20);
        }
    }

    public void cashRegister()
    {

    }


}
