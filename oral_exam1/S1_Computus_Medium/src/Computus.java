public class Computus {
    private double month;
    private double day;
    private double year = 0.0;

    public Computus() {
        year = 0;
    }

    public void Gregorian(double year) {
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

        if(month == 3.0)
        {
            System.out.println("Easter is March " + day);
        }
        if(month == 4.0)
        {
            System.out.println("Easter is April " + day);
        }
    }

    public void DisplayEasterDates() {
        int[][] date = new int[2][32];

        for(double i = 1.0; i <= 5700000.0; ++i) {
            this.Gregorian(i);
            int iDay = (int)this.day;
            if (this.month == 3.0) {
                ++date[0][iDay];
            }

            if (this.month == 4.0) {
                ++date[1][iDay];
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

    public double getMonth() {
        return this.month;
    }

    public double getYear() {
        return this.year;
    }

    public double getDay() {
        return this.day;
    }

    public void setMonth(double month) {
        this.month = month;
    }

    public void setDay(double day) {
        this.day = day;
    }

    public void setYear(double year) {
        this.year = year;
    }
}