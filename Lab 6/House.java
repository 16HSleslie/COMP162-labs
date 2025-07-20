public class House extends Dwelling {
    
    private String description;
    private double rentPerMonth;
    
    public House(String address, int roomsFree, String description, double rentPerMonth) {
        super(address, roomsFree);
        this.description = description;
        this.rentPerMonth = rentPerMonth;
    }
    
    @Override
    public void display() {
        System.out.println("*".repeat(60));
        System.out.println("House");
        super.display();
        System.out.println("Description: " + description);
        System.out.printf("Rent per month: $%.2f\n", rentPerMonth);
    }
}