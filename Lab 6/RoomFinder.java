import java.util.Scanner;

/* Anthony Robins
Start of RoomFinder
*/
public class RoomFinder {
    private static House[] houseList = {
        new House("947 Castle St", 4, "Old villa with modern extension", 2880.0),
        new House("951 Castle St", 3, "Refurbished villa, large back lawn", 3360.0),
        new House("931 Castle St", 4, "Old villa with second story", 2500.0)
    };
    
    //private static Hall[] ha1 = new Hall("944 Castle St", 10, "Thelwon Hall", 18021.5);

    public static void main(String[] args) {
        int menuChoice;
        
        do {
            menuChoice = displayMenu();
            
            System.out.println();
            switch (menuChoice) {
                case 1:
                    showHouses();
                    break;
                case 2:
                    System.out.printf("\nTotal free rooms in all the houses is %s\n", Dwelling.totalFreeRooms);
                    break;
                case 3:
                    
                    break;
                case 0:
                    System.out.println("Okay bye!");
                    break;
            }
        } while (menuChoice != 0);
    }
    
    public static int displayMenu() {
        System.out.printf("""
                            \nPlease choose a menu option
                              1 - To print dwellings
                              2 - To show total free rooms
                              3 - To add a tenant to a house
                              0 - To quit
                            """);
        return readInt("Please enter an int between 0 and 3(inclusive): ");
    }
    
    public static int readInt(String prompt) {
        Scanner s = new Scanner(System.in);
        System.out.print("\n" + prompt);
        return s.nextInt();
    }
    
    public static void showHouses() {
        System.out.println("LIST OF DWELLINGS");
        for (House house : houseList) {
            house.display();
        }
    }
}