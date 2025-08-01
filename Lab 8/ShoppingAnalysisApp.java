import java.util.*;

public class ShoppingAnalysisApp {
    public static void main(String[] args) {
    
        // PersonalSupermarketShopping classes init with random testing data *Put in array for easier testing
        PersonalSupermarketShopping[] testArray = {new PersonalSupermarketShopping("Test Class One", 6, 3, 12, 50, 250),
                                                   new PersonalSupermarketShopping("Test Class Two", 9, 1, 8, 60, 180),
                                                   new PersonalSupermarketShopping("Test Class Three", 7, 6, 16, 20, 345)};
    
        // PersonalSupermarketShopping classes init with data from file
        PersonalSupermarketShopping s = new PersonalSupermarketShopping("Jeff", 6, "receipts.txt");
        PersonalSupermarketShopping stwo = new PersonalSupermarketShopping("Jeff", 7, "receiptsTwo.txt");
        
        System.out.println("\n Print 1 or 0 of ");
        System.out.println(s.compareTo(stwo));
        
        System.out.println("\n Print unsorted array");
        for (PersonalSupermarketShopping e : testArray) {
            System.out.println(e.getNumShops());
        }
        
        Arrays.sort(testArray);
        
        System.out.println("\n Print sorted array");
        for (PersonalSupermarketShopping e : testArray) {
            System.out.println(e.getNumShops());
        }
        
        /*
        // Testing getNumShop method
        System.out.println("*".repeat(25));
        for (PersonalSupermarketShopping shop : testArray) {
            System.out.printf("Testing getNumShop() for %s: %s\n", shop.getName(), shop.getNumShops());
        }
        System.out.println();
        
        // testing getReceiptsTotal method
        System.out.println("*".repeat(25));
        for (PersonalSupermarketShopping shop : testArray) {
            System.out.printf("Testing getReceiptsTotal() for %s: %.2f\n", shop.getName(), shop.getReceiptsTotal());
        }
        System.out.println();
        
        // testing getReceiptsAverage method
        System.out.println("*".repeat(25));
        for (PersonalSupermarketShopping shop : testArray) {
            System.out.printf("Testing getReceiptsAverage() for %s: %.2f\n", shop.getName(), shop.getReceiptsAverage());
        }
        System.out.println();
        
        // testing amountPerWeek method
        System.out.println("*".repeat(25));
        for (PersonalSupermarketShopping shop : testArray) {
            System.out.printf("Testing amountPerWeek() for %s: %.2f\n", shop.getName(), shop.amountPerWeek());
        }
        System.out.println();
        
        // testing getSmallestReceipt method
        System.out.println("*".repeat(25));
        for (PersonalSupermarketShopping shop : testArray) {
            System.out.printf("Testing getSmallestReceipt() for %s: %.2f\n", shop.getName(), shop.getSmallestReceipt());
        }
        System.out.println();
        
        // testing getLargestReceipt method
        System.out.println("*".repeat(25));
        for (PersonalSupermarketShopping shop : testArray) {
            System.out.printf("Testing getLargestReceipt() for %s: %.2f\n", shop.getName(), shop.getLargestReceipt());
        }
        System.out.println();
        
        */
        
        /*
        System.out.println(s.getNumShops());
        System.out.println(s.getReceiptsTotal());
        System.out.println(s.getReceiptsAverage());
        System.out.println(s.amountPerWeek());
        System.out.println(s.getSmallestReceipt());
        System.out.println(s.getLargestReceipt());
        */
    }
}