import java.io.*;
import java.nio.Buffer;

public class WebServer implements Buffer {
    private String[] locations = new String[20];
    private static final String fileName = "S24_AmazonOrderProcessing_OrdersFile.csv";
    private final Buffer shippingCenter;

    /*
    public static void main(String[] args)
    {
        BufferedReader buff = null;
        FileReader file = null;

        try
        {
            file = new FileReader(fileName);
            buff = new BufferedReader(file);

            String currentLine;

            while((currentLine = buff.readLine()) != null)
            {
                System.out.println(currentLine);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace(); // FIGURE OUT WHAT THIS IS
        }
        finally
        {
            try
            {
                if(buff != null)
                {
                    buff.close();
                }
                if(file != null)
                {
                    file.close();
                }
            }
            catch(IOException e2)
            {
                e2.printStackTrace();
            }
        }
    }
     */

    public WebServer()
    {
        BufferedReader br = null;
        try
        {
            String currentLine;
            br = new BufferedReader(new FileReader("S24_AmazonOrderProcessing_OrdersFile.csv"));
            int i = 0;
            while((currentLine = br.readLine()) != null)
            {
                String[] arr = currentLine.split(",");
                System.out.println(arr[8]);
            }

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally {
            {
                try
                {
                    if(br!= null)
                    {
                        br.close();
                    }
                }
                catch(IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        }

    }

    public void run()
    {

    }
}
