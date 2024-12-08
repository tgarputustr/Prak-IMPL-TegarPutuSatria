package LatihanDefensiveProgramming;

public class Tugas1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println(divide(3, 0));
        } catch (ArithmeticException e) {
            System.err.println("Error: Division by zero is not allowed. " + e.getMessage());
        }
    }

    /**
     * Method to divide two integers
     * @param numerator the numerator
     * @param denominator the denominator
     * @return the result of division
     * @throws ArithmeticException if denominator is zero
     */
    public static int divide(int numerator, int denominator) throws ArithmeticException {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero");
        }
        return numerator / denominator;
    }
}

