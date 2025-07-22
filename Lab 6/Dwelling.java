public class Dwelling {

    protected String address;
    protected Room[] roomList;
    protected int roomsFree;
    
    public static int totalFreeRooms = 0;
    
    public Dwelling(String address, int roomsFree) {
        this.address = address;
        this.roomList = new Room[roomsFree];
        for (int x = 0; x < roomList.length; x++) {
            roomList[x] = new Room();
        }
        this.roomsFree = roomsFree;
        totalFreeRooms += roomsFree;
    }

    public String getAddress() {
        return address;
    }

    public int getRoomsFree() {
        return roomsFree;
    }
    
    public void addTenant() {
        if (roomsFree != 0) {
            roomsFree--;
            Dwelling.totalFreeRooms--;
            System.out.println("Done");
        } else {
            System.out.println("Sorry there are no rooms avaliable");
        }
    }
    
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