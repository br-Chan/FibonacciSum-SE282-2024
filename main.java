public class main {
    // Author: Brandon Seng Han Chan
    // UPI: bcha389
    // UoA Student ID: 501744077

    // This method returns the greatest common divisor of
    // the sums of the first A Fibonacci numbers and first B Fibonacci numbers.
    public static int gcdFibonacci(int A, int B) {
        return -1;
    }

    //This method tests the above program, and shows the progress of the program.
    public static void testProgram(int A, int B) {
        System.out.println("Inputs: " + A + " and " + B);
        System.out.println("Result: " + gcdFibonacci(A, B));
        System.out.println();
    }

    public static void main(String[] args) {
        testProgram(4, 3);
    }
}
