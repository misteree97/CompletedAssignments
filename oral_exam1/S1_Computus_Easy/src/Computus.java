/**
 *
 */
import java.util.Scanner;
import java.lang.*;
public class Computus {
    private double month;
    private double day;
    private double year;

    public Computus(double year)
    {
        this.year = year;
    }
    public void Gregorian()
    {
        double a = year%19;
        double b = Math.floor(year/100);
        double c = year%100;
        double d = Math.floor(b/4);
        double e = b % 4;
        double f = Math.floor((b+8)/25);
        double g = Math.floor((b-f+1)/3);
        double h = ((19*a) + b - d - g + 15) % 30;
        double i = Math.floor(c/4);
        double k = c % 4;
        double l = (32 + (2*e) + (2*i) - h - k)%7;
        double m = Math.floor((a+(11*h)+(22*l))/451);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
        System.out.println(i);
        System.out.println(k);
        System.out.println(l);
        System.out.println(m);

        month = Math.floor((h+l-(7*m)+114)/31);
        day = ((h+l-(7*m)+114)%31)+1;
    }
    public double getMonth()
    {
        return month;
    }
    public double getDay()
    {
        return day;
    }

}
