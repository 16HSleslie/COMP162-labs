import java.util.Scanner;
import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

public class RowCombiner {
    public static void main(String[] args) {   
        String fileContent = getFileContents("numbers2.txt");
        
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
        
        printArray(nums);
        System.out.println();
        printArray(combine2Rows(nums));
    }
    
    /*
    * Method to combine rows of a 2D array 2 at a time
    * @param nums 2D array to be combined
    * @return combined 2D array
    */
    public static int[][] combine2Rows(int[][] nums) {    
        int arrayLen = (int) Math.ceil(nums.length / 2.0);
        int[][] combinedRowsArray = new int[arrayLen][];
        
        int index = 0;
        
        for (int row = 0; row < nums.length; row += 2) {
            if (row >= arrayLen) {
                combinedRowsArray[index] = nums[row];
                continue;
            }
            
            combinedRowsArray[index] = new int[nums[row].length + nums[row + 1].length];
            
            System.arraycopy(nums[row], 0, combinedRowsArray[index], 0, nums[row].length);
            System.arraycopy(nums[row + 1], 0, combinedRowsArray[index++], nums[row].length, nums[row + 1].length);
        }
        
        return combinedRowsArray;
    }
    
    public static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    
    /*
    * Method to get file contents from a given path
    * @param fileName Path to file that is to be read
    * @return file content that has been read
    */
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