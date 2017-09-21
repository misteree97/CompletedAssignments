/**
 *
 */
import java.util.Scanner;
import java.lang.*;
public class Computus {
    private double month;
    private double day;
    private double year;

    public Computus()
    {
        year = 0;
    } //public Computus(double year){this.year = year;}
    public void Gregorian(double year)
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


        month = Math.floor((h+l-(7*m)+114)/31);
        day = ((h+l-(7*m)+114)%31)+1;
    }
    public void DisplayEasterDates()
    {
        int [][] date = new int[2][32];
        for(double i = 1; i <= 5700000; i++)
        {
            Gregorian(i);
            //System.out.println("Month: " + month + " Day: " + day);
            int iDay = (int)day;
            if(month == 3.0)
            {
                date[0][iDay]++;
            }
            if(month == 4.0)
            {
                date[1][iDay]++;
            }
        }
        for(int j = 0; j < 1; j++)
        {
            for(int k = 1; k <32; k++)
            {
                    System.out.println("Easter occurs " + date[j][k] + " times on March " + k);
            }
        }
        for(int j = 1; j < 2; j++)
        {
            for(int k = 1; k <31; k++)
            {
                System.out.println("Easter occurs " + date[j][k] + " times on April " + k);
            }

        }

    }
    public double getMonth()
    {
        return month;
    }
    public double getYear()
    {
        return year;
    }
    public double getDay()
    {
        return day;
    }
    public void setMonth(double month)
    {
        this.month = month;
    }
    public void setDay(double day)
    {
        this.day = day;
    }
    public void setYear(double year)
    {
        this.year = year;
    }


}
