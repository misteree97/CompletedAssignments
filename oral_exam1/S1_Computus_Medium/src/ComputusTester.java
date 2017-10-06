import java.util.Scanner;

/**
 * @author Elliot Lohr
 * This program will test the Computus class to print out Easter Dates and how often Easter occurs on certain dates
 */
public class ComputusTester {
    /**
     * Main method that creates and computus object and displays the dates
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a year to calculate the date of Easter");
        double year = sc.nextDouble();
        Computus c = new Computus();
        c.gregorian(year);
        c.printEaster();
        System.out.println("MEDIUM PART");
        c.displayEasterDates();
    }
}
