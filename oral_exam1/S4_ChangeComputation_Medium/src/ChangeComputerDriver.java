import java.util.*;
public class ChangeComputerDriver {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the price of the object");
        double itemPrice = sc.nextDouble();
        System.out.println("Enter the amount paid");
        double customerPaid = sc.nextDouble();
        if(customerPaid < itemPrice)
        {
            System.out.println("Please enter a value larger than the Item Price");
        }
        ChangeComputer register = new ChangeComputer();
        register.displayCashRegister();
    }
}
