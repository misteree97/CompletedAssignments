import javax.swing.*;

/**
 * Created by elohr on 11/26/17.
 */
public class ClientTest
{
    public static void main(String[] args)
    {
        Client2 application; // declare client application

        // if no command line args
        if (args.length == 0)
            application = new Client2("127.0.0.1"); // connect to localhost
        else
            application = new Client2(args[0]); // use args to connect

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runClient(); // run client application
    }
}

