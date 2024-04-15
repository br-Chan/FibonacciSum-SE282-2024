import java.lang.Math;
import java.util.InputMismatchException;
import java.util.Scanner;

// Author: Brandon Seng Han Chan
// UPI: bcha389
// UoA Student ID: 501744077

public class Main {
    // Initialise the golden ratio and the golden ratio with a numerator of 1-sqrt(5).
    final static double goldenRatio1 = (1 + Math.sqrt(5)) / 2;
    final static double goldenRatio2 = (1 - Math.sqrt(5)) / 2;


    // This method calculates the nth Fibonacci number.
    // This method uses the explicit formula for the Fibonacci sequence,
    // explained in README.md and attached working.
    public static int fibonacci(int n) {
        // Initialise a variable equal to only 1 / sqrt(5).
        double result = 1 / Math.sqrt(5);

        // Take goldenRatio1 and 2 to the nth power.
        double golden1 = Math.pow(goldenRatio1, n);
        double golden2 = Math.pow(goldenRatio2, n);

        // Multiply their difference by 1 / sqrt(5).
        result = result * (golden1 - golden2);

        return (int)result;

        // READ: this method returns integers and only works with 0 <= n <= 46.
        // When n > 46, the maximum value for integers (2147483647) is reached.
    }

    // This method returns the sum of Fibonacci numbers from 0 to n.
    public static int fSum(int n) {
        int result = fibonacci(n + 2) - 1;

        return result;

        // READ: this method returns integers and only works with 0 <= n <= 44,
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

        // Determine which of m and n is bigger, and equate them to a and b such that a > b.
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

        System.out.println("=========================== STEP 1: Calculate the sums ==========================");

        // Calculate the sums of the first A and B Fibonacci numbers (-1 because sequence starts at n = 0).
        int fA = fSum(A - 1);
        System.out.println("Sum of the first " + A + " Fibonacci numbers = " + fA);
        int fB = fSum(B - 1);
        System.out.println("Sum of the first " + B + " Fibonacci numbers = " + fB);

        System.out.println("=========================== Step 2: Calculate the GCD ===========================");

        int result = gcd(fA, fB);
        System.out.println("==================================== ANSWER =====================================");
        System.out.println(result + "\n");
        return result;
    }

    // This method tests the above program with 4 pre-defined pairs of inputs.
    public static void testProgram() {
        boolean allPass = true;

        System.out.println("Running the algorithm on 4 pre-defined pairs of inputs...\n");

        System.out.println("4 & 3 => 2");
        if (gcdFibonacci(4, 3) != 2) allPass = false;

        System.out.println("30 & 20 => 11");
        if (gcdFibonacci(30, 20) != 11) allPass = false;

        System.out.println("2 & 3 => 1");
        if (gcdFibonacci(2, 3) != 1) allPass = false;

        System.out.println("7 & 7 => 20");
        if (gcdFibonacci(7, 7) != 20) allPass = false;
        
        System.out.print("Algorithm has been run on 4 pairs of inputs.");
        if (allPass) System.out.println("All pass!");
        else System.out.println("Not all pass.");
        System.out.println();

    }

    // This method implements the user interface that the user interacts with.
    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input 'TEST' to run a testProgram method with predefined inputs.");
        System.out.println("Input 'USER' to enter your own inputs.");
        System.out.println("Input 'EXIT' to exit.");
        String input = scanner.nextLine();

        if (input.toUpperCase().equals("TEST")) {
            testProgram();

        } else if (input.toUpperCase().equals("USER")) {
            // Prompt user for inputs.
            boolean aValid = false, bValid = false;
            int A = 0, B = 0;
            while (!aValid) {
                try {
                    System.out.print("Input A = ");
                    A = scanner.nextInt();

                    if (A <= 0 || A > 44) {
                        System.err.println("Input must be between 1 and 44.");
                        continue;
                    }

                    aValid = true;
                }
                catch (InputMismatchException e) {
                    System.err.println("Input must be an integer.");
                    scanner.next();
                    continue;
                }
            }           

            while (!bValid) {
                try {
                    System.out.print("Input B = ");
                    B = scanner.nextInt();

                    if (B <= 0 || B > 44) {
                        System.err.println("Input must be between 1 and 44.");
                        continue;
                    }

                    bValid = true;
                }
                catch (InputMismatchException e) {
                    System.err.println("Input must be an integer.");
                    scanner.next();
                    continue;
                }
            }  
            
            System.out.println("");
            gcdFibonacci(A, B);

        } else if (input.toUpperCase().equals("EXIT")) {
            System.out.println("Exiting...");
            return;
        
        } else {
            System.out.println("Invalid input.");

        }

        menu();
    }

    public static void main(String[] args) {
        menu();

        // Testing the fibonacci method.
        // for (int n = 0; n < 50; ++n) {
        //     System.out.println(n + " " + fibonacci(n));
        // }
        

    }
}
