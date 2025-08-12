public static ArrayList<Integer> sieveAtkin(int limit) {
        int[] arr = new int[limit+1];
        Arrays.fill(arr, 0);
        
        if (limit > 2) arr[2] = 1;
        if (limit > 3) arr[3] = 1;
        
        for (int x = 1; x * x <= limit; x++) {
            for (int y = 1; y * y <= limit; y++) {
                
                int n = (4 * x * x) + (y * x);
                if (n <= limit && (n % 12 == 1 || n % 12 ==5)) {
                    arr[n] = (arr[n] + 1) % 2;
                }
                
                n = (3 * x * x) + (y * y);
                if (n <= limit && n % 12 == 7) {
                    arr[n] = (arr[n] + 1) % 2;
                }
                
                n = (3 * x * x) - (y * y);
                if (x > y && n <= limit && n % 12 == 11) {
                    arr[n] = (arr[n] + 1) % 2;
                }
            }
        }
        
        for (int i = 5; i * i <= limit; i++) {
            if (arr[i] == 0) continue;
            for (int j = i * i; j <= limit; j += i * i) {
                arr[j] = 0;
            }
        }
        
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (arr[i] == i) {
                primes.add(i);
            }
        }
        
        return primes;
    }

    public static BitSet erathosthenesPrimeLarge(int n) {
        if (n < 2) {
            return new BitSet(Math.max(0, n + 1));
        }
        
        // BitSet can handle much larger sizes than boolean arrays
        BitSet prime = new BitSet(n + 1);
        prime.set(2, n + 1);
        
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (prime.get(i)) {
                long iSquared = (long) i * i;
                if (iSquared <= n) {
                    for (long j = iSquared; j <= n; j += i) {
                        prime.clear((int) j);
                    }
                }
            }
        }
        
        return prime;
    } 
