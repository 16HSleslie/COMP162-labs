import java.util.Random;

public class TriangleArray {
    public static void main(String[] args) {
        int[][] nums = new int[randNum(3,7)][];
        
        for (int y = 0; y < nums.length; y++) {
            nums[y] = new int[randNum(3,7)];
            for (int x = 0; x < nums[y].length; x++) {
                nums[y][x] = randNum(1,50);
            }
        }
        
        print2DArray(nums);
        
        System.out.println();
        
        print2DArray(getTriangleArray(nums));
    }
    
    public static int[][] getTriangleArray(int[][] nums) {
        int totalCells = 0;
        
        for (int[] row : nums) {
            totalCells += row.length;
        }
        
        int totalRows = (int) Math.ceil((Math.sqrt(1 + (8 * totalCells)) - 1) / 2);
        
        int[][] triNums = new int[totalRows][];
        int currentRow = 0;
        int currentCol = 0;
        
        triNums[0] = new int[1];
        
        for (int[] row : nums) {
            for (int num : row) {
                triNums[currentRow][currentCol++] = num;
                
                if (currentCol == currentRow + 1) {
                    currentRow++;
                    currentCol = 0;
                    
                    if (currentRow < totalRows) {
                        triNums[currentRow] = new int[currentRow + 1];
                    }
                }
            }
        }
        
        return triNums;
    }
    
    public static int randNum(int min, int max) {
        Random rand = new Random();
        
        return rand.nextInt(min, max + 1);
    }
    
    public static void print2DArray(int[][] nums) {
        for (int y = 0; y < nums.length; y++) {
            for (int x = 0; x < nums[y].length; x++) {
                System.out.printf("%-" + 4 + "d", nums[y][x]);
            }
            System.out.println();
        }
    }
}