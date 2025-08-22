import java.util.Scanner;
import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

public class RowCombiner {
    public static void main(String[] args) {   
        String fileContent = getFileContents("numbers1.txt");
        
        String[] strArray = fileContent.split("\n");
        int strArrayLen = strArray.length;
        
        int[][] nums = new int[strArrayLen][];
        
        for (int row = 0; row < strArrayLen; row++) {
            String[] strValues = strArray[row].split(" "); 
            int innerArraylen = strValues.length;
            
            int[] innerValues = new int[innerArraylen];
            
            for (int col = 0; col < innerArraylen; col++) {
                innerValues[col] = Integer.parseInt(strValues[col].strip());
            }
            
            nums[row] = innerValues;
        }
        
        combine2Rows(nums);
    }
    
    public static int[][] combine2Rows(int[][] nums) {    
        int arrayLen = (int) Math.ceil(nums.length / 2.0);
        int[][] combinedRowsArray = new int[arrayLen][];
        
        System.out.println(arrayLen);
        
        int[] tempArray;
        
        for (int row = 0; row < nums.length; row++) {
            if (tempArray[0] == null) {
                tempArray = nums[row];
            } else {
                
            }
        }
        
        return null;
    }
    
    public static String getFileContents(String fileName){
      String fileContents = "";
      try {
         fileContents = Files.readString(Path.of(fileName));
      } catch (IOException e) {
         System.out.println("File not found.");
      }
      return fileContents;
   }
}