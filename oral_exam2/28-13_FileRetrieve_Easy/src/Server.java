import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//can't test because programmed on personal laptop, need to be tested on class laptops
public class Server {
    private ServerSocket server;
    private Socket connector;
    private BufferedReader reader;
    private BufferedWriter writer;

    public Server()
    {
        try
        {
            server = new ServerSocket(23500, 13); //23500 = portnumber where server waits for connections from client (acceptable values for 2217 = 23500-23999
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void runServer()
    {
        String readFile;
        try
        {
            connector = server.accept(); //Listens for a connection to be made to this socket, returns a socket when connection with client is established
            writer = new BufferedWriter(new OutputStreamWriter(connector.getOutputStream())); //gets a reference to the sockets output stream
            reader = new BufferedReader(new InputStreamReader(connector.getInputStream())); //gets a reference to the sockets input streams
            System.out.println("What file are you looking for?");
            String fileName = reader.readLine();
            File checkFile = new File(fileName);

            boolean fileExists = checkFile.exists();

            if(fileExists)
            {
                BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(checkFile)));

                writer.write("File: ", 0, 6);
                writer.flush();


                readFile = input.readLine();

                while(readFile != null)
                {
                    writer.write(readFile, 0, readFile.length());
                    writer.flush();
                    readFile = input.readLine();
                }
                reader.close();
                writer.close();
                connector.close();
            }
            else //file doesn't exisst
            {
                writer.write(checkFile.getName() + "DNE");
                writer.flush();

                reader.close();
                writer.close();
                connector.close();
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
            System.exit(0);
        }

    }
    public static void main(String[] args)
    {
        Server runServer = new Server();
        runServer.runServer();
    }

}
