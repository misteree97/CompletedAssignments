import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.util.Random;
import javax.swing.JFrame;



public class RandomCircle extends JFrame {

    public RandomCircle (){

        setTitle("RandomCircle Generator");
        setSize(960,960);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g){
        Random ran = new Random();

        int max = 400;
        int min = 100;

        int x = ran.nextInt((max - min) + 1) + min;



        g.setColor(Color.BLACK);
        g.drawOval(480-x, 480-x, x*2, x*2);

        String Radius = "The Radius is: " + x;
        String Diameter = "The Diameter = 2 * Radius = " + x*2;
        String pi = "\u03c0";
        String area = "The Area = " + pi + " * Radius ^ 2 = " +(Math.PI * Math.pow(x, 2) );
        String Circumference = "The Circumference = 2 * " + pi + " * Radius = " + (2 * Math.PI * x) ;

        g.setFont(new Font("TimesRoman", Font.PLAIN, 12));

        g.drawString(Radius, 100, 100);
        g.drawString(Diameter, 100, 120);
        g.drawString(area, 100, 140);
        g.drawString(Circumference, 100, 160);

    }





    public static void main(String[] args) {

        RandomCircle ran = new RandomCircle();
        ran.paint(null);
    }

}

