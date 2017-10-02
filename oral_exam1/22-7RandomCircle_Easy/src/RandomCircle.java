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

        int radius = ran.nextInt((max - min) + 1) + min;



        g.setColor(Color.BLACK);
        g.drawOval(480-radius, 480-radius, radius*2, radius*2);

        String Radius = "The Radius is: " + radius;
        String Diameter = "The Diameter = 2 * Radius = " + radius*2;
        String pi = "\u03c0";
        String area = "The Area = " + pi + " * Radius ^ 2 = " +(Math.PI * Math.pow(radius, 2) );
        String Circumference = "The Circumference = 2 * " + pi + " * Radius = " + (2 * Math.PI * radius) ;


        g.setFont(new Font("TimesRoman", Font.PLAIN, 12));//have to set font otherwise prints on coded background

        g.drawString(Radius, 100, 100);//places information of circle on jFrame
        g.drawString(Diameter, 100, 120);
        g.drawString(area, 100, 140);
        g.drawString(Circumference, 100, 160);

    }





    public static void main(String[] args) {

        RandomCircle ran = new RandomCircle();
        ran.paint(null);
    }

}

