import java.util.*;

public class SeatingPlan {
    private boolean[][] seats;
    
    public SeatingPlan(boolean[][] seats) {
        this.seats = seats;
    }
    
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