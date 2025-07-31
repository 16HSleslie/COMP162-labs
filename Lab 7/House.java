/*
* Class to represent the information of a House.
* a House is an subclass of Dwelling and inheriets the
* common variables and methods
*/
public class House extends Dwelling {
    
    private String description;
    private double rentPerMonth;
    
    /*
    * Contructor that creats an object of House with a description of the House
    * and the rent per month, additionally calls the contructor of Dwelling with
    * the address and rooms contained in the House
    */
    public House(String address, int roomsFree, String description, double rentPerMonth) {
        super(address, roomsFree);
        this.description = description;
        this.rentPerMonth = rentPerMonth;
    }
    
    public void calcRoomPerMonth() {
        System.out.printf("The cost per room at %s\n", super.address);
        System.out.printf("is $%.2f per month\n", rentPerMonth);
    }
    
    /*
    * Method that overrides the default behaviour of display method
    * from Dweeling and outs the desired information accociated with this House
    */
    @Override
    public void display() {
        System.out.println("*".repeat(60));
        System.out.println("House");
        super.display();
        System.out.println("Description: " + description);
        System.out.printf("Rent per month: $%.2f\n", rentPerMonth);
    }
}