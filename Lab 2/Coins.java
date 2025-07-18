import java.util.Random;

/**
 * A class to represent a series of coin tosses and 
 * provide methods to supply information about them.
 * @author Nick Meek
 */
public class Coins {

    public static final boolean HEADS = true;
    public static final boolean TAILS = false;

    private boolean[] coins;

    /*
    * Creates Coins object from a boolean array
    * @param Array of boolean values (true=heads, false=tails)
    */
    public Coins(boolean[] coins) {
        this.coins = coins;
    }
    
    /*
    * Creates Coins object from a string
    * @param String consisting of H and T chars
    */
    public Coins(String c) {
        this.coins = new boolean[c.length()];

        for (int x = 0; x < c.length(); x++) {
            if (c.charAt(x) == 'H') {
                coins[x] = true;
            } else if (c.charAt(x) == 'T') {
                coins[x] = false;
            }
        }
    }
    
    
    /*
    * Creates Coins object with randoms coin tosses of specified length
    * @param length of number of coins generated
    */
    public Coins(int length) {
        this.coins = new boolean[length];
        Random r = new Random();

        for (int x = 0; x < length; x++) {
            coins[x] = r.nextBoolean();
        }
    }


    /*
    * Counts the number of heads in coins array
    * @return The number of heads as an integer
    */
    public int countHeads() {
        int count = 0;

        for (boolean coin: coins) {
            if (coin) {
                count++;
            }
        }
        return count;
    }
   
    /*
    * Creates a string representing the coin tosses
    * @return String using H for heads and T for tails
    */
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (boolean coin: coins) {
            if (coin) {
                s.append("H");
            } else {
                s.append("T");
            }
        }
        return s.toString();
    }
    
    
    /*
    * Counts the number of runs in coins array
    * A run is a block of coins showing the same face
    * @return The number of runs as an interger
    */
    public int countRuns() {
        if (coins.length == 0) {
            return 0;
        }

        int runCount = 1;

        for (int x = 1; x < coins.length; x++) {
            if (coins[x] != coins[x - 1]) {
                runCount++;
            }
        }
        return runCount;
    }
}