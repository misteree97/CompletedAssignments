import java.util.logging.Logger;
/**
 * @Author Elliot Lohr
 * This class tests the AmazonOrderProcessing nodes
 */
public class AmazonOrderProcessingTester
{
    /**
     * Main method that tests programs
     * @param args the filepath for the cvs file
     */
    public static void main(String[] args)
    {
        //if the file path is missing notify user
        if (args.length < 1) {
            System.out.println("Missing filename");
            System.exit(1);
        }

        String filename = args[0];
        //array of valid addresses for the first shipping center
        String[] validAddresses = new String[] {"Los Angeles", "San Francisco", "Seattle", "Denver"};
        //empty array of addresses since second shipping center takes in any city that isn't in the array above
        String[] allAddresses = new String[]{};

        //creates 4 delivery trucks with different truck IDs
        //all trucks have the same capacity of 4 order
        DeliveryTruck truck1 = new DeliveryTruck("Truck Bob", 4);
        DeliveryTruck truck2 = new DeliveryTruck("Truck Alice", 4);
        DeliveryTruck truck3 = new DeliveryTruck("Truck John", 4);
        DeliveryTruck truck4 = new DeliveryTruck("Truck Mary", 4);

        //creates 2 shipping dock objects that take in an array of trucks that it will send orders to
        ShippingDock shippingDock1 = new ShippingDock(new DeliveryTruck[]{truck1, truck2});
        ShippingDock shippingDock2 = new ShippingDock(new DeliveryTruck[]{truck3, truck4});

        //creates 2 shipping sections that will send orders to shippingDock1 and only accept orders
        //that fit the category constraints listed in the assignment
        ShippingSection section1 = new ShippingSection("Section-1", 'A', 'P', shippingDock1);
        ShippingSection section2 = new ShippingSection("Section-2", 'Q', 'Z', shippingDock1);
        ShippingSection section3 = new ShippingSection("Section-1", 'A', 'P', shippingDock2);
        ShippingSection section4 = new ShippingSection("Section-2", 'Q', 'Z', shippingDock2);

        //creates 2 shipping centers that take in the array of cities that it will accept orders from and an array of shipping sections it will send orders to
        ShippingCenter shippingCenter1 = new ShippingCenter("Shipping-Center-1", validAddresses, new ShippingSection[]{section1, section2});
        ShippingCenter shippingCenter2 = new ShippingCenter("Shipping-Center-2", allAddresses, new ShippingSection[]{section3, section4});

        //creates an amazonwebserver that will take a csv file and create orders(AWStasks)
        //takes in array of shippingCenters that it can send orders to
        AmazonWebServer webServer = new AmazonWebServer(filename, new ShippingCenter[] {shippingCenter1, shippingCenter2});
        //wait until all threads have been processed before the all done message is sent
        webServer.waitUntilDone();

        Logger.getLogger("MAIN").info("All done");
    }
}
