public class Hall extends Dwelling {
    
    private String name;
    private double roomCostPerYear;
    
    public Hall(String address, int roomsFree, String name, double roomCostPerYear) {
        super(address, roomsFree);
        this.name = name;
        this.roomCostPerYear = roomCostPerYear;
    }
    
    @Override
    public void display() {
        System.out.println("*".repeat(60));
        System.out.println("Hall");
        super.display();
        System.out.println("Name of Hall: " + name);
        System.out.printf("Room cost per year: $%.2f", roomCostPerYear);
    }
}