import java.util.*;
import java.util.stream.*;

public class OldSchoolSums {
    int[][] inputs;
    
    public OldSchoolSums(int[][] inputs) {
        this.inputs = inputs;
    }
    
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