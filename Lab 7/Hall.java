/*
* Class to represent the information of a Hall.
* Hall is an subclass of Dwelling and inheriets the
* common variables and methods
*/

public class Hall extends Dwelling {
    
    private String name;
    private double roomCostPerYear;
    
    /*
    * Contructor that creats an object of Hall with the name of the Hall
    * and the cost per year, additional calls the contructor of Dwelling with
    * the address and rooms contained in the Hall
    */
    public Hall(String address, int roomsFree, String name, double roomCostPerYear) {
        super(address, roomsFree);
        this.name = name;
        this.roomCostPerYear = roomCostPerYear;
    }
    
    /*
    * method to calculate the rent per month from the rent per year and
    * print the value to the screen
    */
    public void calcRoomPerMonth() {
        System.out.printf("The cost per room at %s\n", super.address);
        System.out.printf("is $%.2f per month\n", roomCostPerYear / 12);
    }
    
    /*
    * Method that overrides the default behaviour of display method
    * from Dweeling and outs the desired information accociated with this Hall
    */
    @Override
    public void display() {
        System.out.println("*".repeat(60));
        System.out.println("Hall");
        super.display();
        System.out.println("Name of Hall: " + name);
        System.out.printf("Room cost per year: $%.2f", roomCostPerYear);
    }
}