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
        
        // testing instance of PersonalSupermarketShopping inited from file
        System.out.println("*".repeat(25));
        System.out.println(s.getNumShops());
        System.out.println(s.getReceiptsTotal());
        System.out.println(s.getReceiptsAverage());
        System.out.println(s.amountPerWeek());
        System.out.println(s.getSmallestReceipt());
        System.out.println(s.getLargestReceipt());
        
        // testing compareTo and equal's method
        System.out.println("*".repeat(25));
        System.out.println("testing compareTo method expected output (-1 = less than, 0 = the same, 1 = greater than)");
        System.out.println(s.compareTo(stwo) + "\n");
        System.out.println("testing equal method expected output (if compareTo = 1 or -1; false. if compareTo = 0; true)");
        System.out.println(s.equals(stwo));
        
        // testing Array.sort method to see if compareTo works as intended.
        System.out.println("*".repeat(25));
        System.out.println("Unsorted array");
        for (PersonalSupermarketShopping e : testArray) {
            System.out.println(e.getNumShops());
        }
        Arrays.sort(testArray);
        System.out.println("sorted array");
        for (PersonalSupermarketShopping e : testArray) {
            System.out.println(e.getNumShops());
        }
    }
}