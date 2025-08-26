import java.util.Arrays;

public class TableauApp {
    public static void main(String[] args) {
        final int[][] valid = {{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 9, 12}, {7}};
        System.out.println(TableauApp.toString(valid));
        System.out.println(rowLengthsDecrease(valid));
        System.out.println(rowValueIncreases(valid));
        System.out.println(columnValuesIncrease(valid));
        System.out.println(isSetOf1toN(valid));
        
        System.out.println(isTableau(valid));
        
    }
    
    public static boolean isTableau(int[][] t) {
        boolean rowLenDecrease = rowLengthsDecrease(t);
        boolean rowValIncrease = rowValueIncreases(t);
        boolean colValIncrease = columnValuesIncrease(t);
        boolean oneToN = isSetOf1toN(t);
        
        return rowLenDecrease && rowValIncrease && colValIncrease && oneToN;
    }
    
    public static boolean rowLengthsDecrease(int[][] t) {
        for (int row = 1; row < t.length; row++) {
           if (t[row].length > t[row-1].length) {
               return false;
           }
        }
        
        return true;    
    }
    
    public static boolean rowValueIncreases(int[][] t) {  
        for (int row = 0; row < t.length; row++) {  
            for (int col = 1; col < t[row].length; col++) {
                if (t[row][col] < t[row][col-1]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static boolean columnValuesIncrease(int[][] t) {
        for (int row = 1; row < t.length; row++) {  
            for (int col = 0; col < t[row].length; col++) {
                if (t[row][col] < t[row-1][col]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static boolean isSetOf1toN(int[][] t) {
        int cellCount = 0;
        for (int[] row : t) {
            cellCount += row.length;
        }
        
        
        boolean[] seen = new boolean[cellCount];
        
        for (int[] row : t) {
            for (int num : row) {
                if (num < 1 || num > cellCount || seen[num-1]) {
                    return false;
                }
                
                seen[num-1] = true;
            }
        }
        
        return true;
    }
    
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length-1) {
                result.append("\n");
            }
        }
        
        return result.toString();
    }
}