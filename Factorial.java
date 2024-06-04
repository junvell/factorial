import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.InputMismatchException;


// Factorial of integer
// This class contains a method to calculate the factorial of a given number
// and write the result to a file.
public class Factorial {

    
    //Calculates the factorial of a given number.
    //the number to calculate the factorial for
    //the factorial of the number as a BigInteger
    
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    
    // It calculates the factorial of a specified number and writes the result to a file.
     
    public static void main(String[] args) {
        Scanner factorial = new Scanner(System.in);
        int num = 0;
        boolean validInput = false;
        
        // Loop until a valid integer is entered
        while (!validInput) {
            System.out.print("Enter a number to calculate its factorial: ");
            try {
                num = factorial.nextInt();
                validInput = true; // Input is valid, exit the loop
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter an integer.");
                factorial.next(); // Clear the invalid input
            }
        }
        
        BigInteger result = factorial(num);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Factorialresult.txt"))) {
            writer.write("Factorial of " + num + " is: " + result.toString());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
        
        factorial.close();
    }
}
