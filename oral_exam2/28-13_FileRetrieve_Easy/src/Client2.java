// Fig. 28.5: Client.java
// Client portion of a stream-socket connection between client and server.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author ELliot Lohr
 * This class provides a client template that can communicate with a server. Code from in class example is reused in this assignment
 */
public class Client2 extends JFrame {
    /**
     * textField used to enter information in Client
     */
    private JTextField enterField;
    /**
     * TextArea to display messages
     */
    private JTextArea displayArea;
    /**
     * Output to the server
     */
    private ObjectOutputStream output;
    /**
     * input from the server
     */
    private ObjectInputStream input;
    /**
     * message from server
     */
    private String message = "";
    /**
     * host server for application
     */
    private String chatServer;
    /**
     * socket to communicate with server
     */
    private Socket client;


    /**
     * Initialize client and set up gui
     * @param host  server which client connects
     */
    public Client2(String host) {
        super("Client");

        chatServer = host; // set server to which this client connects

        enterField = new JTextField(); // create enterField
        enterField.setEditable(false);
        enterField.addActionListener(
                new ActionListener() {
                    // send message to server
                    public void actionPerformed(ActionEvent event) {
                        sendData(event.getActionCommand());
                        enterField.setText("");
                    }
                }
        );

        add(enterField, BorderLayout.NORTH);

        displayArea = new JTextArea(); // create displayArea
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setSize(300, 150); // set size of window
        setVisible(true); // show window
    }

    /**
     *  used to run the client and connect to server
     */
    public void runClient() {
        try // connect to server, get streams, process connection
        {
            connectToServer(); // create a Socket to make connection
            getStreams(); // get the input and output streams
            processConnection(); // process connection
        } catch (EOFException eofException) {
            displayMessage("\nClient terminated connection");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            closeConnection(); // close connection
        }
    }

    /**
     * Connects to server
     * @throws IOException
     */
    private void connectToServer() throws IOException {
        displayMessage("Attempting connection\n");

        // create Socket to make connection to server
        client = new Socket(InetAddress.getByName(chatServer), 12345);

        // display connection information
        displayMessage("Connected to: " +
                client.getInetAddress().getHostName());
    }

    /**
     * get streams to send and receive data
     * @throws IOException
     */
    private void getStreams() throws IOException {
        // set up output stream for objects
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush(); // flush output buffer to send header information

        // set up input stream for objects
        input = new ObjectInputStream(client.getInputStream());

        displayMessage("\nGot I/O streams\n");
    }


    /**
     * process connection with server
     * @throws IOException
     */
    private void processConnection() throws IOException {
        // enable enterField so client user can send messages
        setTextFieldEditable(true);

        do // process messages sent from server
        {
            try // read message and display it
            {
                message = (String) input.readObject(); // read new message
                displayMessage("\n" + message); // display message
            } catch (ClassNotFoundException classNotFoundException) {
                displayMessage("\nUnknown object type received");
            }

        } while (!message.equals("SERVER>>> TERMINATE"));
    }

    /**
     * close streams and socket
     */
    private void closeConnection() {
        displayMessage("\nClosing connection");
        setTextFieldEditable(false); // disable enterField

        try {
            output.close(); // close output stream
            input.close(); // close input stream
            client.close(); // close socket
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    // send message to server

    /**
     * send message to server
     * @param message   the message
     */
    private void sendData(String message) {
        try // send object to server
        {
            output.writeObject(message);
            output.flush(); // flush data to output
            displayMessage("\nCLIENT>>> " + message);
        } catch (IOException ioException) {
            displayArea.append("\nError writing object");
        }
    }

    /**
     * alters displayArea in the event-dispatch thread
     * @param messageToDisplay
     */
    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // updates displayArea
                    {
                        displayArea.append(messageToDisplay);
                    }
                }
        );
    }

    /**
     * manipulates enterField in the event-dispatch thread
     * @param editable
     */
    private void setTextFieldEditable(final boolean editable) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // sets enterField's editability
                    {
                        enterField.setEditable(editable);
                    }
                }
        );
    }
}