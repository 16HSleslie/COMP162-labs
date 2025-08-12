import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.file.*;

public class OldSchoolSumsApp {
    public static void main(String[] args) {
        int[][] inputs = new int[5][];
        
        try {
            Scanner s = new Scanner(new File("sums.txt"));
            
            for (int x = 0; x < 5; x++) {
                Scanner lineScanner = new Scanner(s.nextLine());
                
                inputs[x] = lineScanner.useDelimiter(" ")
                                       .tokens()
                                       .mapToInt(y -> Integer.valueOf(y))
                                       .toArray();
            }    
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }
        
        OldSchoolSums sums = new OldSchoolSums(inputs);
        
        sums.displaySums();
    }
}