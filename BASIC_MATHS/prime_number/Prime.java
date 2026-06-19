public class Prime {

    // Method to check whether a number is prime or not
    public static boolean isPrime(int n) {

        // Prime numbers are greater than 1
        if (n <= 1) {
            return false;
        }

        // Check divisibility from 2 to square root of n
        for (int i = 2; i * i <= n; i++) {

            // If n is divisible by i, then it is not prime
            if (n % i == 0) {
                return false;
            }
        }

        // If no factor is found, then number is prime
        return true;
    }

    public static void main(String[] args) {

        int num = 29;

        // Calling the method
        if (isPrime(num)) {
            System.out.println(num + " is a Prime Number");
        } else {
            System.out.println(num + " is NOT a Prime Number");
        }
    }
}