import java.util.Scanner;
import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

public class RowCombiner {
    public static void main(String[] args) {
        String fileContent = "";
        
        try {
            Scanner sc = new Scanner(new File("numbers1.txt")).useDelimiter("\\A");
            
            fileContent = sc.hasNext() ? sc.next() : "";
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        
        String[] strArray = fileContent.split("\n");
        int strArrayLen = strArray.length;
        
        int[][] nums = new int[strArrayLen][];
        
        
        for (int row = 0; row < strArrayLen; row++) {
            String[] strValues = strArray[row].split(" "); 
            int innerArraylen = strValues.length;
            
            int[] innerValues = new int[innerArraylen];
            
            for (int col = 0; col < innerArraylen; col++) {
                innerValues[col] = Integer.parseInt(strValues[col]);
            }
            
            nums[row] = innerValues;
        }
        
        combine2Rows(nums);
    }
    
    public static int[][] combine2Rows(int[][] nums) {    
        int arrayLen = Math.ceilDiv(nums.length, 2);
        int[][] combinedRowsArray = new int[arrayLen][];
        
        int[] rowsCombined;
        int step = 0;
        
        for (int row = 0; row < nums.length; row++) {
            if (rowsCombined[0] != null) {
                int arrayLen = rowsCombined.length
                
                int[] temp = rowsCombined;
                rowsCombined = new int[arrayLen];
                
                
            } else {
                rowsCombined = nums[row];
                
            }
        }
        
        return null;
    }
}