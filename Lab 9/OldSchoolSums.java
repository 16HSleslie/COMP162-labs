import java.util.*;
import java.util.stream.*;

/*
* A class to represent int values that can then
* be added together to return a final sum
*/
public class OldSchoolSums {
    int[][] inputs;
    
    /*
    * Constructor method to init OldSchoolSum object with
    * 2D array of int values
    */
    public OldSchoolSums(int[][] inputs) {
        this.inputs = inputs;
    }
    
    /*
    * Method to display values contained in each inner array
    * and formatting in a way to identify what is being added,
    * Finally it displayed to calculated valued of the ints summed
    * together
    */
    public void displaySums() {
        int width = 6;
        String formatTemplate = "%n" + "%" + width + "s%n" +
                                "%" + width + "s%n" +
                                "+" + "%" + (width-1) + "s%n" +
                                "-".repeat(6) + "\n" +
                                "%" + width + "s%n%n" +
                                "*".repeat(8) + "%n";
                                
        
        
        for (int[] row : inputs) {
            System.out.printf(formatTemplate, row[0], row[1], row[2], IntStream.of(row).sum());
        }
    }
}