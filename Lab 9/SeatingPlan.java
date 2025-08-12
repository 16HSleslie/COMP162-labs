import java.util.*;

/*
* Class to represent a seating plan for a set amount of rows/seats
*/
public class SeatingPlan {
    private boolean[][] seats;
    
    /*
    * Contsructor method to init the SeatingPlan object with
    * a 2d array of boolean values representing seats
    */
    public SeatingPlan(boolean[][] seats) {
        this.seats = seats;
    }
    
    /*
    * Method to find a sequence of n seats contained in each row,
    * and return the index of starting seat in sequence
    * @return String with information on index of starting seat
    */
    public String findSeats(int numSeatsReq) {
        for (int y = 0; y < seats.length; y++) {
            int count = 0;
            for (int x = 0; x < seats[y].length; x++) {
                count = !seats[y][x] ? count + 1 : 0;
                if (count == numSeatsReq) {
                    return String.format("row: %s seat: %s", y, x - numSeatsReq + 1);
                }
            }
        }
        return String.format("No Seats found");
    }
    
    /*
    * Method to display each seat contained in 2D array
    * as a string, Additionally gives information if the
    * is occupied or not
    */
    public void displaySeats() {
        StringBuilder output = new StringBuilder();
        
        for (boolean[] row : seats) {
            for (boolean seat : row) {
                output.append(seat ? "o " : "x ");
            }
            output.append('\n');
        }
        System.out.print(output);
    }
}