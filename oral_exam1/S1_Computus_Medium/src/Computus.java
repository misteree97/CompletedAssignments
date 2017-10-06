/**
 * @author Elliot Lohr
 * This class will create a computus object, which is capable of computing the date of easter given a year and displaying how many times easter occurs on each day in a gregorian cycle
 */
public class Computus {
    /**
     * The month that easter will occur in
     */
    private double month;
    /**
     * The day that easter will occur on
     */
    private double day;
    /**
     * The year that program will determine the date of easter in
     */
    private double year;



    /**
     * No argument constructor
     */
    public Computus() {
        year = 0;
    }

    /**
     * computes and prints the month and day easter is on in a certain year
     *
     * @param year        the year to compute when easter is
     */
    public void gregorian(double year) {
        //gregorian formula for calculating date of easter given year
        double a = year % 19.0;
        double b = Math.floor(year / 100.0);
        double c = year % 100.0;
        double d = Math.floor(b / 4.0);
        double e = b % 4.0;
        double f = Math.floor((b + 8.0) / 25.0);
        double g = Math.floor((b - f + 1.0) / 3.0);
        double h = (19.0D * a + b - d - g + 15.0) % 30.0;
        double i = Math.floor(c / 4.0);
        double k = c % 4.0;
        double l = (32.0 + 2.0 * e + 2.0 * i - h - k) % 7.0;
        double m = Math.floor((a + 11.0 * h + 22.0 * l) / 451.0);
        this.month = Math.floor((h + l - 7.0 * m + 114.0) / 31.0);
        this.day = (int)(h + l - 7.0 * m + 114.0) % 31.0 + 1.0;
    }
    public void printEaster()
    {
        //easter will only occur in march or april so looks for month 3.0 and 4.0
        if(month == 3.0)
        {
            System.out.println("Easter is March " + day);
        }
        if(month == 4.0)
        {
            System.out.println("Easter is April " + day);
        }

    }

    /**
     * computes and prints the amount of times easter occurs on each day for an entire gregorian cycle
     */
    public void displayEasterDates() {
        int[][] date = new int[2][32]; //creates 2d array to contain all the dates of march and april

        for(double i = 1.0; i <= 5700000.0; ++i) { //runs through an entire gregorian cycle
            this.gregorian(i);
            int iDay = (int)this.day;
            if (this.month == 3.0) {
                ++date[0][iDay]; //adds one to the march row and the day column calculated through gregorian()
            }

            if (this.month == 4.0) {
                ++date[1][iDay];//adds one to the april row and the day column calculated through gregorian()
            }
        }

        int k;
        int j;
        for(j = 0; j < 1; ++j) {
            for(k = 1; k < 32; ++k) {
                System.out.println("Easter occurs " + date[j][k] + " times on March " + k);
            }
        }

        for(j = 1; j < 2; ++j) {
            for(k = 1; k < 31; ++k) {
                System.out.println("Easter occurs " + date[j][k] + " times on April " + k);
            }
        }

    }

    /**
     * returns a double representation of the month
     * @return month
     */
    public double getMonth() {
        return this.month;
    }

    /**
     * returns a double representation of the year
     * @return year
     */
    public double getYear() {
        return this.year;
    }

    /**
     * returns a double representation of the dy
     * @return day
     */
    public double getDay() {
        return this.day;
    }

    /**
     * updates the month variable to new value
     * @param month
     */
    public void setMonth(double month) {
        this.month = month;
    }

    /**
     * updates the day variable to a new value
     * @param day
     */
    public void setDay(double day) {
        this.day = day;
    }

    /**
     * updates the year variable to a new value
     * @param year
     */
    public void setYear(double year) {
        this.year = year;
    }
}