import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.file.*;

public class PersonalSupermarketShopping implements ShoppingDataInterface {
    private String name;
    private ArrayList<Double> receiptList;
    private int weeksWentShopping;
    
    public PersonalSupermarketShopping(String name, int numWeeks, String initFilePath) {
        this.name = name;
        this.weeksWentShopping = numWeeks;
        this.receiptList = initReceiptsFromFile(initFilePath);
        
    }
    
    public PersonalSupermarketShopping(String name, int numWeeks, int lowLength, int highLength, int lowShop, int highShop) {
        this.name = name;
        this.weeksWentShopping = numWeeks;
        this.receiptList = generateReceiptList(lowLength, highLength, lowShop, highShop);
        System.out.println(name + " initialized with " + receiptList.size() + " receipts");
    }
    
    public int getNumShops() {
        return receiptList.size();
    }
    
    public double getReceiptsTotal() {
        return receiptList.stream()
                            .mapToDouble(x -> x)
                            .sum();
    }
    
    public double getReceiptsAverage() {
        return receiptList.stream()
                            .mapToDouble(x -> x)
                            .average()
                            .getAsDouble();
    }
    
    public double amountPerWeek() {
        return getReceiptsTotal() / weeksWentShopping;
    }
    
    public double getSmallestReceipt() {
        return receiptList.stream()
                            .mapToDouble(x -> x)
                            .min()
                            .getAsDouble();
    }
    
    public double getLargestReceipt() {
        return receiptList.stream()
                            .mapToDouble(x -> x)
                            .max()
                            .getAsDouble();
    }
    
    private ArrayList<Double> initReceiptsFromFile(String filePath) {
        ArrayList<Double> receipts = new ArrayList<Double>();
        
        try {
            Scanner s = new Scanner(new File(filePath));
            
            receipts = s.useDelimiter(",")
                      .tokens()
                      .mapToDouble(x -> Double.parseDouble(x))
                      .boxed()
                      .collect(Collectors.toCollection(ArrayList::new));
              
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }
        
        return receipts;
    }
    
    private ArrayList<Double> generateReceiptList(int lowLength, int highLength, int lowShop, int highShop) {
        Random random = new Random();
        int listLength = lowLength + random.nextInt(highLength - lowLength + 1);
        ArrayList<Double> receiptList = new ArrayList<Double>();
        
        System.out.println("Debug - listLength calculated as: " + listLength);
        
        for (int x = 0; x < listLength; x++) {
            receiptList.add(lowShop + (highShop - lowShop) * random.nextDouble());
        }
        
        return receiptList;
    }
    
    /*
    * Method to return the name of the class for testing purpose
    * @return Name
    */
    public String getName() {
        return name;
    }
}