import java.lang.Math;

// Author: Brandon Seng Han Chan
// UPI: bcha389
// UoA Student ID: 501744077

public class Main {
    // Initialise the golden ratio and the golden ratio with a numerator of 1-sqrt(5).
    final static double goldenRatio1 = (1 + Math.sqrt(5)) / 2;
    final static double goldenRatio2 = (1 - Math.sqrt(5)) / 2;


    // This method calculates the nth Fibonacci number,
    // with initial conditions F(0) = 0 and F(1) = 1.
    // This method uses the explicit formula for the Fibonacci sequence,
    // explained in README.md and attached working.
    public static int fibonacci(int n) {
        // Start with only 1 / sqrt(5).
        double result = 1 / Math.sqrt(5);

        // Take goldenRatio1 and 2 to the nth power.
        double golden1 = Math.pow(goldenRatio1, n);
        double golden2 = Math.pow(goldenRatio2, n);

        // Multiply the difference by 1 / sqrt(5).
        result = result * (golden1 - golden2);

        return (int)result;

        // READ: this method only works with 0 <= n <= 46.
        // When n > 46, the maximum value for integers (2147483647) is reached.
        // For values larger than 46, a method returning a double should be used instead.
    }

    // This method returns the sum of Fibonacci numbers from 0 to n.
    public static int fSum(int n) {
        int result = fibonacci(n + 2) - 1;

        return result;

        // READ: this method only works with 0 <= n <= 44,
        // for the same reasons as above.
    }

    // This method returns the greatest common divisor of integers m and n.
    public static int gcd(int n, int m) {
        System.out.println("GCD(" + n + ", " + m + ") = ? (using Euclidean Algorithm)");

        // Edge case: n = m, return n.
        if (n == m) {
            System.out.println(n + " equals " + m + ", so return " + n + ".");

            return n;
        }

        // Determine which of m and n is bigger, and ensure that a > b.
        System.out.println("We use a = qb + r.");
        int a = 0, b = 0;
        if (m > n) {
            a = m;
            b = n;
        } else {
            a = n;
            b = m;
        }
        System.out.print("a = " + a + ", b = " + b);

        // Find the initial remainder of a / b.
        int r = a % b;
        System.out.println(" -> r = " + r);

        while (r != 0) {
            // Change a and b as follows.
            a = b;
            b = r;
            System.out.print("a = " + a + ", b = " + b);

            // Find the new remainder of a / b.
            r = a % b;
            System.out.println(" -> r = " + r);
        }

        // Return b if the remainder of a / b is 0.
        System.out.println("So return " + b + ".");
        return b;
    }

    // This method returns the greatest common divisor of
    // the sums of the first A Fibonacci numbers and first B Fibonacci numbers.
    public static int gcdFibonacci(int A, int B) {
        System.out.println(
            "PROMPT: Find the GCD of the sums of the first " + A + " and " + B + " Fibonacci numbers."
        );

        System.out.println("============ STEP 1: Calculate the sums ===========");

        // Calculate the sums of the first A and B Fibonacci numbers (-1 because sequence starts at n = 0).
        int fA = fSum(A - 1);
        System.out.println("Sum of the first " + A + " Fibonacci numbers = " + fA);
        int fB = fSum(B - 1);
        System.out.println("Sum of the first " + B + " Fibonacci numbers = " + fB);

        System.out.println("============ Step 2: Calculate the GCD ============");

        int result = gcd(fA, fB);
        System.out.println("===================== ANSWER ======================");
        System.out.println(result);
        System.out.println();
        return result;
    }

    //This method tests the above program.
    public static void testProgram(int A, int B) {
        System.out.println("Inputs: " + A + " and " + B);
        System.out.println("Result: " + gcdFibonacci(A, B));
        System.out.println();
    }

    public static void main(String[] args) {
        gcdFibonacci(30, 20);

        // for (int n = 0; n < 50; ++n) {
        //     System.out.println(n + ": " + fSum(n));
        // }

        //testProgram(4, 3);
    }
}
