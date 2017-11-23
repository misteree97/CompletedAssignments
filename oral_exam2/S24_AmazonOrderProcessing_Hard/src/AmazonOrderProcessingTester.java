import java.util.logging.Logger;
/**
 * @Author Elliot Lohr
 * This class tests the AmazonOrderProcessing nodes
 */
public class AmazonOrderProcessingTester
{
    public static void main(String[] args)
    {
        //if the file isn't found exit and notify user
        if (args.length < 1) {
            System.out.println("Missing filename");
            System.exit(1);
        }
        String filename = args[0];
        //addresses that are valid for Shipping center 1
        String[] validAddresses = new String[] {"Los Angeles", "San Francisco", "Seattle", "Denver"};
        //all addresses that are valid for Shipping center
        String[] allAddresses = new String[]{};

        //instantiates Delivery trucks with truck tagIds and max capacity of 4 orders
        DeliveryTruck truck1 = new DeliveryTruck("Truck Bob", 4);
        DeliveryTruck truck2 = new DeliveryTruck("Truck Alice", 4);
        DeliveryTruck truck3 = new DeliveryTruck("Truck John", 4);
        DeliveryTruck truck4 = new DeliveryTruck("Truck Mary", 4);

        //instantiates shipping docks that take in array of trucks
        ShippingDock shippingDock1 = new ShippingDock(new DeliveryTruck[]{truck1, truck2});
        ShippingDock shippingDock2 = new ShippingDock(new DeliveryTruck[]{truck3, truck4});

        //instantiates shipping sections that only take in orders that fit the category parameters
        ShippingSection section1 = new ShippingSection("Section-1", 'A', 'P', shippingDock1);
        ShippingSection section2 = new ShippingSection("Section-2", 'Q', 'Z', shippingDock1);
        ShippingSection section3 = new ShippingSection("Section-1", 'A', 'P', shippingDock2);
        ShippingSection section4 = new ShippingSection("Section-2", 'Q', 'Z', shippingDock2);

        //instantiates shipping centers that only take in orders that fit the City parameters
        ShippingCenter shippingCenter1 = new ShippingCenter("Shipping-Center-1", validAddresses, new ShippingSection[]{section1, section2});
        ShippingCenter shippingCenter2 = new ShippingCenter("Shipping-Center-2", allAddresses, new ShippingSection[]{section3, section4});

        //instantiates webserver that reads orders from file and sends to center
        AmazonWebServer webServer = new AmazonWebServer( filename, new ShippingCenter[] { shippingCenter1, shippingCenter2 });
        //waits until webserver processes all orders to display all done message
        webServer.waitUntilDone();

        Logger.getLogger("MAIN").info("All done");
    }
}
