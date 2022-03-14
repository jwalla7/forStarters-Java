package Loops;

import java.util.InputMismatchException;
import java.util.Scanner;

//  Recursion: When the method performs an action and calls itself.
//  Base Case: When the method returns a value without making any additional calls to itself.


public class Recursion {

    public static void main(String[] args) {
//       1 - Recursion Factorial Calculator: accepts input of a positive integer and returns the integer's factorial.
//        2 - Scanner
        System.out.println(
                         """
                         |----------------------| |----------------------| |----------------------|
                         |       Factorial      | |    Greatest Common   | |        Reverse       |
                         |       Calculator     | |  Divisor Calculator  | |         Words        |
                         |----------------------| |----------------------| |----------------------|
                         Type in FACT to calculate factorials!
                         Type in GCD to calculate greatest common divisors!
                         Type in WORDS to reverse a word!
                         """
                          );

        String factorial = "FACT";
        String greatestCommonDivisor = "GCD";
        String reverseWords = "WORDS";

        Scanner console = new Scanner(System.in);
        String response = console.nextLine();

        do {
            try {
//                response = console.nextLine();

                if (response == response) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(
                                 """
                                 INVALID
                                 Enter "FACT" to calculate factorials!
                                 Enter "GCD" to calculate greatest common divisors!
                                 Enter "WORDS" to reverse a word!
                                 """
                                  );
            } finally {
            }
        } while (true);
//      3 Methods: The following Factorial, Greatest Common Divisor, and Reverse Words methods will implement recursion
//       4 Factorials
        if (response.equals(factorial)) {
            double calculate;

            do {
                try {
                    System.out.println(
                                     """
                                     Lets find some factorials!
                                     Enter an integer greater or equal to 0.
                                     """
                                      );
                    calculate = console.nextDouble();

                    if (calculate == calculate) {
                        break;
                    }
                } catch (InputMismatchException eMismatch) {
                    System.out.println(
                                     """
                                     INVALID
                                     Enter a number greater or equal to 0.
                                     """
                                      );
                } finally {
                    response = console.nextLine();
                }
            } while (true);

            while (calculate < 0) {
                System.out.println(
                                 """
                                 INVALID
                                 Enter a number greater or equal to 0.
                                 """
                                  );
                calculate = console.nextDouble();
            }

            if (calculate > 0) {
                System.out.println("Calculating factorial...");
                System.out.println(recursiveFactorial(calculate));
            }
//      5. Greatest Common Divisor
        } else if (response.equals(greatestCommonDivisor)) {
            System.out.println(
                                """
                                Lets find the greatest common divisor!
                                Let's start by entering the larger number.
                                """
                              );
//      6. Reverse Words
        } else if (response.equals(reverseWords)) {
            System.out.println(
                                """
                                Lets find some factorials!
                                Enter an integer greater or equal to 0.
                                """
                              );
            response = console.nextLine();
        } else {
            while (!response.equals(factorial) || !response.equals(greatestCommonDivisor) || !response.equals(reverseWords)) {
                System.out.println(
                                 """
                                 INVALID
                                 Enter "FACT" to calculate factorials!
                                 Enter "GCD" to calculate greatest common divisors!
                                 Enter "WORDS" to reverse a word!
                                 """
                                  );
                response = console.nextLine();
            }
        }
    }

//    Factorial Input
    public static void inputFactorial(Scanner console) {

    }
//    Factorial Method
    public static double recursiveFactorial(double input) {
//        Function: Use recursion to find factorial of input.
        if (input > 0) {
            System.out.println("Input: " + input + " Next Input: " + (input - 1));
            return input * recursiveFactorial(input - 1);
        } else {
            return 1;
        }
    }
//    Greatest Common Divisor Input
//    Greatest Common Divisor Method
//    Reverse Input
//    Reverse Method
    public static String reverseWord(String text){
        if (text.length() == 0) {
            return text;
        } else {
            return reverseWord(text.substring(1)) + text.charAt(0);
        }
    }
}
