import java.util.ArrayList;
/**
 * An application class to help you test your BusRoute class
 * @author Nick Meek and Karen Gray
 */
public class BusRouteApp {

    /** Feel free to add further tests . . .
    @param args the array of command line arguments (only if any are provided when being run from the command line).*/
    public static void main(String[] args) {


        BusRoute route = new BusRoute("City Circle", 720, "Bus Hub");
        System.out.println("Initialise:\n" + route);

        route.addStop("Dog Park", 60);
        route.addStop("Port", 120);
        route.addStop("Park", 180);
        route.addStop("Cemetery", 240);
        route.addStop("Cinema", 300);
        route.addStop("Mall", 360);
        route.addStop("Golf Course", 420);
        route.addStop("Swimming Pool", 480);
        route.addStop("Hospital", 540);
        route.addStop("Zoo", 600);
        route.addStop("Museum", 660);
        
        System.out.println("Initial Route for the " + route.getRouteId() + ":\n" + route);

        //add more tests

        route.addStop("New Park", 330);
        route.addStop("Vet Clinic", 40);

        route.suspendStop("Mall");
        route.suspendStop("Cinema");
        route.removeStop("Swimming Pool");
        route.activateStop("Cinema");

        System.out.println("*".repeat(40));
        System.out.println("Modified Route for the " + route.getRouteId() + ":\n" + route);
        System.out.println("*".repeat(40));
        System.out.println("Number of seconds between the Swimming Pool and the Cemetery: " + route.secondsBetween2Stops("Swimming Pool", "Cemetery"));
        System.out.println("Number of seconds between the Museum and the Port: " + route.secondsBetween2Stops("Museum", "Port"));

    }
}