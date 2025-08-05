import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.file.*;


/*
* Class to represent a persons reciepts over a period of time
*/
public class PersonalSupermarketShopping implements ShoppingDataInterface, Comparable<PersonalSupermarketShopping> {
    private String name;
    private ArrayList<Double> receiptList;
    private int weeksWentShopping;
    
    /*
    * Contructor to create an object of PersonalSupermarketShopping and init
    * receipt list from a file
    */
    public PersonalSupermarketShopping(String name, int numWeeks, String initFilePath) {
        this.name = name;
        this.weeksWentShopping = numWeeks;
        this.receiptList = initReceiptsFromFile(initFilePath);
        
    }
    
    /*
    * Contructor to create an object of PersonalSupermarketShopping and init
    * receipt list with random data for testing 
    */
    public PersonalSupermarketShopping(String name, int numWeeks, int lowLength, int highLength, int lowShop, int highShop) {
        this.name = name;
        this.weeksWentShopping = numWeeks;
        this.receiptList = generateReceiptList(lowLength, highLength, lowShop, highShop);
        System.out.println(name + " initialized with " + receiptList.size() + " receipts");
    }
    
    /*
    * Method to get the the total number of receipts in class object
    * @return Length of receiptList as int
    */
    public int getNumShops() {
        return receiptList.size();
    }
    
    /*
    * Method to get the total sum of all receipts
    * @return The sum of receiptList as double 
    */
    public double getReceiptsTotal() {
        /*
        Double total = 0;
        for (double value : receiptList) {
         total += value;
        }
        */
        return receiptList.stream()
                          .mapToDouble(x -> x)
                          .sum();
    }
    
    /*
    * Method to get the average receipt price over all receipts
    * @return Average of all receipts in receiptList as double
    */
    public double getReceiptsAverage() {
        /*
        double average = 0;
        for (doub)
        */
        return receiptList.stream()
                          .mapToDouble(x -> x)
                          .average()
                          .getAsDouble();
    }
    
    /*
    * Method to get the average amountspent each week
    * @return Total sum of all receipts devided by weeks went shopping
    */
    public double amountPerWeek() {
        return getReceiptsTotal() / weeksWentShopping;
    }
    
    /*
    * Method to return the the smallest value receipt in receiptList
    * @return Smalled value in receiptList
    */
    public double getSmallestReceipt() {
        return receiptList.stream()
                          .mapToDouble(x -> x)
                          .min()
                          .getAsDouble();
    }
    
    /*
    * Method to return the the largest value receipt in receiptList
    * @return largestest value in receiptList
    */
    public double getLargestReceipt() {
        return receiptList.stream()
                          .mapToDouble(x -> x)
                          .max()
                          .getAsDouble();
    }
    
    /*
    * Method to get receipts from a text file and init an arraylist with the values
    * as doubles
    * @param FilePath The path to the text file with receipt values
    * @return ArrayList init with values that were read from file
    */
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
    
    /*
    * Method to init an ArrayList with random receipt values between provided ranges
    * @return ArrayList with randomly generate receipt values
    */
    private ArrayList<Double> generateReceiptList(int lowLength, int highLength, int lowShop, int highShop) {
        Random random = new Random();
        int listLength = lowLength + random.nextInt(highLength - lowLength + 1);
        ArrayList<Double> receiptList = new ArrayList<Double>();
        
        
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
    
    /*
    * Method to compare if is two instances of PersonalSupermarketShopping are different
    * in respect to the number of shops contained in each one.
    * @return An int to represent each possible outcome: -1 = smaller, 0 = equal, 1 = greater.
    */
    @Override
    public int compareTo(PersonalSupermarketShopping e) {
        return this.getNumShops() - e.getNumShops();
    }
    
    /*
    * Method to compare if is two instances of PersonalSupermarketShopping are equal
    * in repect to the number of shops contained in each one
    * @return Boolean value of true or false. 
    */
    public boolean equals(Object e) {
        PersonalSupermarketShopping shop = (PersonalSupermarketShopping) e;
        return (getNumShops() == shop.getNumShops());
    }
}