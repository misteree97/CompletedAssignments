import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server2 extends JFrame {
    private JTextArea displayArea;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private BufferedReader bReader;
    private BufferedWriter bWriter;
    private ServerSocket server;
    private Socket connection;
    private int counter = 1; //counter of number of connections
    private String fileName;
    private File file;

    public Server2()
    {
        super("Server");

        displayArea = new JTextArea();
        add(displayArea);

        setSize(300,150);
        setVisible(true);

    }

    public void runServer()
    {
        try
        {
            server = new ServerSocket(12345, 100);

            while(true)
            {
                try
                {
                    waitForConnection(); // wait for a connection
                    getStreams(); // get input & output streams
                    processConnection(); // process connection
                }
                catch(EOFException eofException)
                {
                    displayMessage("\nServer terminated connection");
                }
                finally
                {
                    closeConnection();
                }
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    private void waitForConnection() throws IOException {
        displayMessage("Waiting for connection\n");
        connection = server.accept(); // allow server to accept connection
        displayMessage("Connection " + counter + " received from: " +
                connection.getInetAddress().getHostName());
    }
    private void getStreams() throws IOException {
        // set up output stream for objects
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush(); // flush output buffer to send header information

        // set up input stream for objects
        input = new ObjectInputStream(connection.getInputStream());

        displayMessage("\nGot I/O streams\n");
    }
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
    private void sendData(String message)
    {
        String readFile;
        try // send object to client
        {
            if(file.exists())
            {
                BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                message = "file exists!";
                output.writeObject("SERVER>>> " + message);
                readFile = input.readLine();
                while(readFile != null)
                {
                    bWriter.write(readFile, 0, readFile.length());
                    bWriter.flush();
                    readFile = input.readLine();
                }

            }
            else//file does not exist
            {
                message = "file does not exist";
                output.writeObject("SERVER>>> " + message);
            }
            output.writeObject("SERVER>>> " + message);
            output.flush(); // flush output to client
            displayMessage("\nSERVER>>> " + message);
        } catch (IOException ioException) {
            displayArea.append("\nError writing object");
        }
    }
    private void processConnection() throws IOException{
        String message = "Connection Successful";
        output.writeObject("SERVER>>>" + message);

        do //process messages from client
        {
            try //read message
            {
               fileName = (String)input.readObject();
            }
            catch(ClassNotFoundException classNotFoundException)
            {
                displayMessage("\nUnknown object type received");
            }

        }
        while(!fileName.equals("CLIENT>>> TERMINATE"));
    }
    private void closeConnection() {
        displayMessage("\nTerminating connection\n");

        try {
            output.close(); // close output stream
            input.close(); // close input stream
            connection.close(); // close socket
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
