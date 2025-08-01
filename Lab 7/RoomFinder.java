import java.util.Scanner;

/* Anthony Robins
Start of RoomFinder
*/
public class RoomFinder {
    private static Dwelling[] dwellingList = {
        new House("947 Castle St", 4, "Old villa with modern extension", 2880.0),
        new House("951 Castle St", 3, "Refurbished villa, large back lawn", 3360.0),
        new House("931 Castle St", 4, "Old villa with second story", 2500.0),
        new Hall("944 Castle St", 10, "Thelwon Hall", 18021.5)
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
                    selectAndAddTenant();
                    break;
                case 4:
                    showRentPerMonth();
                    break;
                case 5:
                    showSmallestRooms();
                case 0:
                    System.out.println("Okay bye!");
                    break;
            }
        } while (menuChoice != 0);
    }
    
    /*
    * Method to display option menu
    * @return Int of the user choice
    */
    public static int displayMenu() {
        System.out.printf("""
                            \nPlease choose a menu option
                              1 - To print dwellings
                              2 - To show total free rooms
                              3 - To add a tenant to a house
                              4 - To show the monthly cost of rooms
                              5 - To show the smallest rooms
                              0 - To quit
                            """);
        return readInt("Please enter an int between 0 and 5(inclusive): ");
    }

    /*
    * Method to allow a tenant to added to a dwelling with space avaliable
    */
    public static void selectAndAddTenant() {
        int dwellingListLength = dwellingList.length;
        Dwelling dwelling;
                    
        showRoomsAvaliable();
        System.out.println("Which dwelling do you wish to add a tenant to?");
                    
        try {
            int choiceIndexNum = readInt(String.format("PLease enter an in between 0 and %s (inclusive): ", dwellingListLength - 1));
            dwelling = dwellingList[choiceIndexNum];
                        
            if (dwelling.getRoomsFree() > 0) {
                dwelling.addTenant();
            } else {
                System.out.println("Sorry, that one is full!");
            }
        } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: The house you chose doesn't exist");
        }
    }
    
    /*
    * Method to retive input from user as Int and return the Int value
    * @param prompt String of prompt to displayed
    * @return Input of use as an Int
    */
    public static int readInt(String prompt) {
        Scanner s = new Scanner(System.in);
        System.out.print("\n" + prompt);
        return s.nextInt();
    }
    
    /*
    * Method to display list of each dwelling and how many rooms are avaliabel
    */
    public static void showRoomsAvaliable() {
      for (int x = 0; x < dwellingList.length; x++) {
         Dwelling dwelling = dwellingList[x];
         System.out.printf("Dwelling %s %s has %s rooms free\n", x, dwelling.getAddress(), dwelling.getRoomsFree());
      }
    }
    
    /*
    * Method to display the rent per month for each room in a dwelling in dwellingList
    */
    public static void showRentPerMonth() {
        for (Dwelling dwelling : dwellingList) {
            dwelling.calcRoomPerMonth();
        }
    }
    
    /*
    * Method to display the smallest room in a dwelling in dwellingList
    */
    public static void showSmallestRooms() {
        for (Dwelling dwelling : dwellingList) {
            dwelling.getSmallestRoom();
        }
    }
    
    /*
    * Method to display the information of each house along with
    * the rooms contained in each house
    */
    public static void showHouses() {
        System.out.println("LIST OF DWELLINGS");
        
        for (Dwelling dwelling : dwellingList) {
            dwelling.display();
        }
        
        System.out.println();
    }
}