import java.util.ArrayList;
import java.util.Arrays;

public class PrimeTime {
    public static void main(String[] args) {       

        System.out.println(isPrime(7));
        ArrayList<Integer> primesTwo = getPrimesBetween(1, 1000);
        System.out.println(erathosthenesPrime(100).toString());
        
        /*for (int x = 0; x < primes.length; x++) {
            if (primes[x]) {
                System.out.print(x + " ");
            }
        }*/
    }
    
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
    
    public static ArrayList<Integer> getPrimesBetween(int a, int b) {
        ArrayList<Integer> primeNumbers = new ArrayList<Integer>();        
        
        for (int x = a; x <= b; x++) {
            if (isPrime(x)) {
                primeNumbers.add(x);
            }
        }
        
        return primeNumbers;
    }
    
    public static ArrayList<Integer> getPrimeFactorisation(int x) {
        return null;
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