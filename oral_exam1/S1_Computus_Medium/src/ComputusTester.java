import java.util.Scanner;

public class ComputusTester {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a year to calculate the date of Easter");
        double year = sc.nextDouble();
        Computus c = new Computus();
        c.gregorian(year);
        System.out.println("Month: " + c.getMonth() + " Day: " + c.getDay());
        System.out.println("MEDIUM PART");
        c.displayEasterDates();
    }
}
