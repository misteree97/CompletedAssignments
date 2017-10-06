import java.util.*;
public class ChangeComputerDriver {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ChangeComputer register = new ChangeComputer();
        int x = 0;
        //runs until user decides to exit or cash register is empty
        while(x == 0)
        {
            register.displayCashRegister();
            register.payForItem();
            register.displayCashRegister();
            System.out.println("If you'd like to buy another item, enter 0");
            x = sc.nextInt();
            if(x == 0)
            {
                System.out.println("Enter the price of the item");
                double newTotalAmount = sc.nextDouble();
                System.out.println("Enter the cash given to cashier");
                double newCustomerAmount = sc.nextDouble();
                register.setCustomerAmount(newCustomerAmount);
                register.setTotalAmount(newTotalAmount);

            }
        }
    }
}
