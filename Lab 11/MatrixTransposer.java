import java.util.Random;
import java.util.Arrays;

public class MatrixTransposer {
    public static void main(String[] args) {
        int arrayRow = randNum(3, 7);
        int arrayColumn = randNum(3, 7);
        
        int[][] jagged = {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9}
        };
                
        int[][] nums = new int[arrayRow][arrayColumn];
        
        for (int y = 0; y < nums.length; y++) {
            for (int x = 0 ; x < nums[y].length; x++) {
                nums[y][x] = randNum(1, 50);
            }
        }
        
        for (int[] row : nums) {
            System.out.println(Arrays.toString(row));
        }
        
        int[][] transMatrix = transposeMatrix(nums);
        
        int[][] transArray = raggedTranspose(jagged);
        
        System.out.println("");
        for (int[] row : transMatrix) {
            System.out.println(Arrays.toString(row));
        }
        
        System.out.println("");
        for (int[] row : jagged) {
            System.out.println(Arrays.toString(row));
        }
        
        System.out.println("");
        for (int[] row : transArray) {
            System.out.println(Arrays.toString(row));
        }
    }
    
    /*
    * Method to return the transpose of a given 2D matrix.
    * @param nums 2D matrix that is to be transposed
    * @return Transposed version of 2D matrix
    */
    public static int[][] transposeMatrix(int[][] nums) {
        int rowLength = nums.length;
        int columnLength = nums[0].length;    
        
        int[][] transMatrix = new int[columnLength][rowLength];
        
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < columnLength; col++) {
                transMatrix[col][row] = nums[row][col];
            }
        }
       
        return transMatrix;
    }
    
    /*
    * Method to return the transpose of a given ragged 2D matrix.
    * @param nums 2D matrix that is to be transposed
    * @return Transposed version of 2D matrix
    */
    public static int[][] raggedTranspose(int[][] nums) {
        int maxCols = 0;
        int rowLength = nums.length;
        
        for (int[] row: nums) {
            int colLength = row.length;
            
            if (colLength > maxCols) maxCols = colLength;
        }
        
        int[][] transArray = new int[maxCols][rowLength];
        
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < maxCols; col++) {
                if (col < nums[row].length) {
                    transArray[col][row] = nums[row][col];
                }
            }
        }
        
        return transArray;
    }
    
    /*
    * Method to generate a random number between a range
    * @param min Min number of the range
    * @param max Max number of the range
    */
    public static int randNum(int min, int max) {
        Random rand = new Random();
        
        return rand.nextInt(min, max + 1);
    }
}