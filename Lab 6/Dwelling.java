/*
* Class to represent the information of a dwelling 
* and the rooms contained in the dwelling
*/

public class Dwelling {

    protected String address;
    protected Room[] roomList;
    protected int roomsFree;
    
    public static int totalFreeRooms = 0;
    
    /*
    * Contructor that a Dwelling object with the address
    * and rooms contained in the Dwelling
    */
    public Dwelling(String address, int roomsFree) {
        this.address = address;
        this.roomList = new Room[roomsFree];
        for (int x = 0; x < roomList.length; x++) {
            roomList[x] = new Room();
        }
        this.roomsFree = roomsFree;
        totalFreeRooms += roomsFree;
    }
    
    /*
    * Accessor method to get the adress of Dwelling
    * @return Address of dwelling as a String
    */
    public String getAddress() {
        return address;
    }

    /*
    * Accessor method to get the rooms free in a Dwelling
    * @return Number of rooms free as an Int
    */
    public int getRoomsFree() {
        return roomsFree;
    }
    
    /*
    * Method to add a tenant to the dwelling and change the value of
    * total rooms free across all dwellings
    */
    public void addTenant() {
        if (roomsFree != 0) {
            roomsFree--;
            Dwelling.totalFreeRooms--;
            System.out.println("Done");
        } else {
            System.out.println("Sorry there are no rooms avaliable");
        }
    }
    
    /*
    * Method to display the information of Dwelling and 
    * each rooms information that is contained in the Dwelling
    */
    public void display() {
        int totalRooms = roomList.length;
        
        System.out.println("Address: " + address);
        System.out.println("Number of rooms: " + totalRooms);
        for (int x = 0; x < totalRooms; x++) {
            System.out.printf("  Room %s %s\n", x, roomList[x].toString());
        }
        System.out.println("Rooms used: " + (totalRooms-totalRooms));
    }
}