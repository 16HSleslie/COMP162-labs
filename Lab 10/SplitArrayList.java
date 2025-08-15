import java.util.ArrayList;
import java.util.Random;

public class SplitArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        Random rand = new Random();
        int limit = rand.nextInt(30 - 20 + 1) + 20;
        
        for (int x = 0; x < limit; x++) {
            nums.add(rand.nextInt(100) + 1);
        }
        
        System.out.println(nums.toString());
        System.out.println(getSplit(nums).toString());
    }
    
    /*
    * Method to sory an arraylist into even and odd sections preserciving the
    * the original order of the list
    * @param num ArrayList of int number
    * @return an arraylist of sorted into even numbers are the start and odd nums after
    */
    public static ArrayList<Integer> getSplit(ArrayList<Integer> nums) {
        ArrayList<Integer> evenNums = new ArrayList<Integer>();
        ArrayList<Integer> oddNums = new ArrayList<Integer>();
        
        for (Integer i : nums) {
            if (i % 2 == 0) {
                evenNums.add(i);
            } else {
                oddNums.add(i);
            }
        }
        evenNums.addAll(oddNums);
        
        return evenNums;
    }
}