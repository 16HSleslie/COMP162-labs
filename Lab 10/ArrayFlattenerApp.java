import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.file.*;

public class ArrayFlattenerApp {
    public static void main(String[] args) {
        int fileLineCount = 0;
        
        try {
            fileLineCount += (int)Files.lines(Path.of("numbers1.txt")).count();
            fileLineCount += (int)Files.lines(Path.of("numbers2.txt")).count();
        } catch (IOException e) {
            System.out.println("File doesnt exist");
        }
        
        int[][] nums = new int[fileLineCount][];
        
        try {
            Scanner sc = new Scanner(new File("numbers1.txt"));
            Scanner scTwo = new Scanner(new File("numbers2.txt"));            
            int index = 0;
            
            while (sc.hasNextLine() || scTwo.hasNextLine()) {
                if (sc.hasNextLine()) {
                    String[] splitString = sc.nextLine().split(" ");
                    nums[index++] = Arrays.stream(splitString)
                                          .mapToInt(x -> Integer.parseInt(x))
                                          .toArray();
                    
                }
                if (scTwo.hasNextLine()) {
                    String[] splitString = scTwo.nextLine().split(" ");
                    nums[index++] = Arrays.stream(splitString)
                                          .mapToInt(x -> Integer.parseInt(x))
                                          .toArray();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File doesnt exist");
        }
        
        for (int[] row : nums) {
            System.out.println(Arrays.toString(row));
        }
        
        System.out.println(Arrays.toString(getFlattened(nums)));
        
        
    }
    
    /*
    * Method to flatted 2d array into a single array
    * @param nums 2D array of nums
    * @return flatted array of 2d array
    */
    public static int[] getFlattened(int[][] nums) {
        return Arrays.stream(nums)
                     .flatMapToInt(x -> Arrays.stream(x))
                     .toArray();
    }
}