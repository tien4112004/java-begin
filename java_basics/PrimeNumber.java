import java.util.Scanner;

public class PrimeNumber {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);  

        System.out.print("Enter number: ");
        int n = s.nextInt();
        if (isPrime(n)) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }
    }

    public static boolean isPrime(int n) {
        // sieve of eratosthenes
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i < n; i++) prime[i] = true;
        prime[0] = prime[1] = false;
        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == false) continue;
            for (int i = p * p; i <= n; i += p) {
                prime[i] = false;
            }
        }

        return prime[n];
    }
}
