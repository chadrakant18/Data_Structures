package factorial;

public class factorial {

    // Recursive method to calculate factorial
    private static int fact(int n) {

        // Base condition
        if (n == 0 || n == 1) {
            return 1;
        }

        // Recursive call
        return n * fact(n - 1);
    }

    public static void main(String[] args) {

        int n = 5;

        int result = fact(n);

        System.out.println("Factorial of " + n + " is: " + result);
    }
}