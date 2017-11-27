import javax.swing.*;

/**
 * Created by elohr on 11/26/17.
 */
public class ServerTest {
    public static void main(String[] args) {
        Server2 application = new Server2(); // create server
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runServer(); // run server application
    }
}
