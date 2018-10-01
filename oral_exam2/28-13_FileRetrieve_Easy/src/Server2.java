import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 extends JFrame
{
    /**
     * textField used to enter information in Server
     */
    private JTextField enterField;
    /**
     * TextArea to display messages
     */
    private JTextArea displayArea;
    /**
     * Output stream to client
     */
    private ObjectOutputStream output;
    /**
     * inputStream from client
     */
    private ObjectInputStream input;
    /**
     * Server socket
     */
    private ServerSocket server;
    /**
     * Connection to client
     */
    private Socket connection;
    /**
     * Counter unnecessary
     */
    private int counter = 1;


    /**
     * Constructor for Server2 object
     */
    public Server2() {
        super("Server");

        enterField = new JTextField(); // create enterField
        enterField.setEditable(false);
        enterField.addActionListener(
                new ActionListener() {
                    // send message to client
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
     * set up and run server
     */
    public void runServer() {
        try // set up server to receive connections; process connections
        {
            server = new ServerSocket(12345, 100); // create ServerSocket

            while (true) {
                try {
                    waitForConnection(); // wait for a connection
                    getStreams(); // get input & output streams
                    processConnection(); // process connection
                } catch (EOFException eofException) {
                    displayMessage("\nServer terminated connection");
                } finally {
                    closeConnection(); //  close connection
                    ++counter;
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * Wait for connection to arrive, then display connection info
     * @throws IOException
     */
    private void waitForConnection() throws IOException {
        displayMessage("Waiting for connection\n");
        connection = server.accept(); // allow server to accept connection
        displayMessage("Connection " + counter + " received from: " +
                connection.getInetAddress().getHostName());
    }
    /**
     * get streams to send and receive data
     * @throws IOException
     */
    private void getStreams() throws IOException {
        // set up output stream for objects
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush(); // flush output buffer to send header information

        // set up input stream for objects
        input = new ObjectInputStream(connection.getInputStream());

        displayMessage("\nGot I/O streams\n");
    }


    /**
     * process connection with client
     * @throws IOException
     */
    private void processConnection() throws IOException {
        String message = "Connection successful INPUT FILEPATH NOT NAME";
        sendData(message); // send connection successful message

        // enable enterField so server user can send messages
        setTextFieldEditable(true);

        do // process messages sent from client
        {
            try // read message and display it
            {
                message = (String)input.readObject(); // read new message
                displayMessage(fileContents(message)); // display message
                sendData(fileContents(message));
            } catch (ClassNotFoundException classNotFoundException) {
                displayMessage("\nUnknown object type received");
            }

        } while (!message.equals("CLIENT>>> TERMINATE"));
    }


    /**
     * close streams and socket
     */
    private void closeConnection() {
        displayMessage("\nTerminating connection\n");
        setTextFieldEditable(false); // disable enterField

        try {
            output.close(); // close output stream
            input.close(); // close input stream
            connection.close(); // close socket
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * send message to client
     * @param message
     */
    private void sendData(String message) {
        try // send object to client
        {
            output.writeObject("SERVER>>> " + message);
            output.flush(); // flush output to client
            displayMessage("\nSERVER>>> " + message);
        } catch (IOException ioException) {
            displayArea.append("\nError writing object");
        }
    }

    /**
     * manipulates displayArea in the event-dispatch thread
     * @param messageToDisplay
     */
    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // updates displayArea
                    {
                        displayArea.append(messageToDisplay); // append message
                    }
                }
        );
    }

    /**
     * Method used to displayContents of file if it exists
     * @param filename
     * @return
     */
    private String fileContents(String filename)
    {
        String returnString="";
        try
        {

            BufferedReader fileReader = new BufferedReader(new FileReader(filename));
            String output="";
            while((output = fileReader.readLine())!=null) //reads file while there is more info to print
            {
                returnString = returnString + "\n"+ output;// prints file information
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            displayMessage("FILE NOT FOUND"); //if file not found displays error message
            sendData("FILE NOT FOUND");
        }
        return returnString;
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



