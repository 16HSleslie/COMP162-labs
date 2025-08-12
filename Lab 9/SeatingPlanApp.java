import java.util.*;
import java.io.*;
public class SeatingPlanApp {

    private static boolean[][] seats;
    
    public static void main(String[] args) {
        seats = new boolean[15][20];
        initSeatsFromFile("seats.txt");
        
        SeatingPlan seatPlan = new SeatingPlan(seats);
        
        seatPlan.displaySeats();
        System.out.println(seatPlan.findSeats(readInt("How many seats would you like to book:")));
    }

    /** Takes a String which is used to prompt the user to enter an int which is then returned
        @param prompt The instruction to the user
        @return the int entered by the user
    */
    public static int readInt(String prompt) {
        boolean goodToGo = false;
        int i = -1;
        Scanner sc = new Scanner(System.in);
        do {
            try {

                System.out.println(prompt);
                i = sc.nextInt();
                goodToGo = true;
            } catch (InputMismatchException e) {
                System.out.println("Sorry = that is not an int!");
                sc.nextLine(); // keeps scanner from skipping and causing an infinite loop         
            }
        } while (!goodToGo);
        return i;
    }

    public static void initSeatsFromFile(String path) {
        try {
            Scanner sc = new Scanner(new File(path));
            int row = 0;
            
            while (sc.hasNextLine()) {
                for (int col = 0; col < 20; col++) {
                    seats[row][col] = sc.next().charAt(0) == 'o';
                }
                row++;
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}