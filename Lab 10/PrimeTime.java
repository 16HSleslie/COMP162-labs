import java.util.ArrayList;
import java.util.Arrays;

public class PrimeTime {
    public static void main(String[] args) {       

        System.out.println(isPrime(7));
        ArrayList<Integer> primesTwo = getPrimesBetween(1, 100);
        System.out.println(primesTwo.toString());
        
        System.out.println(getPrimeFactorisation(24).toString());
        
        /*for (int x = 0; x < primes.length; x++) {
            if (primes[x]) {
                System.out.print(x + " ");
            }
        }*/
    }
    
    /*
    * Method to check if a num is prime or not by checking if
    * n is divisable by each num up to sqrt of n
    * @param x Number to check if prime or not
    * @return true/false if its a prime
    */
    public static boolean isPrime(int x) {
        if (x <= 1) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;
        
        int limit = (int) Math.sqrt(x);
        for (int y = 3; y <= limit; y += 2) {
            if (x % y == 0) {
                return false;
            } 
        }
        return true;
    }
    
    /*
    * Method to get all the prime numbers up between n and n2
    * by running the isPrime method on all the numbers in that range
    * @param a lower bound of range
    * @param b upper bound of range
    * @return ArrayList of prime numbers in range
    */
    public static ArrayList<Integer> getPrimesBetween(int a, int b) {
        ArrayList<Integer> primeNumbers = new ArrayList<Integer>();        
        
        for (int x = a; x <= b; x++) {
            if (isPrime(x)) {
                primeNumbers.add(x);
            }
        }
        
        return primeNumbers;
    }
    
    /*
    * Method to get prime factors of any given number
    * This is done by getting a list of prime number up to n
    * and dividing n by the lowest possible prime numebr until
    * not posssible any more then moving on to the next prime num in list
    * continuing until n = 0
    * @param n The number you want prime factors of
    * @return ArrayList of prime factors
    */
    public static ArrayList<Integer> getPrimeFactorisation(int n) {
        ArrayList<Integer> primeToN = erathosthenesPrime(n);
        ArrayList<Integer> primeFactors = new ArrayList<Integer>();
        
        int y = n;
        for (int x = 0; x < primeToN.size(); x++) {
            while (y % primeToN.get(x) == 0) {
                y = y / primeToN.get(x);
                primeFactors.add(primeToN.get(x));
            }
        }
        return primeFactors;
    }
    
    // I didn't comeup with this algorithm but I did create the code from the mathematical equation. I thought it was cool
    public static ArrayList<Integer> erathosthenesPrime(int n) {
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        
        ArrayList<Integer> primeNum = new ArrayList<Integer>();
        
        for (int x = 2; x < n; x++) {
            if (prime[x]) {
                primeNum.add(x);
            }
        }
        
        return primeNum;
    } 
}