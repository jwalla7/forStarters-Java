package Loops;

import java.util.InputMismatchException;
import java.util.Scanner;

//  Recursion: When the method performs an action and calls itself.
//  Base Case: When the method returns a value without making any additional calls to itself.


public class Recursion {

    public static void main(String[] args) {
//      1 - Introduction:
//        1.1 - Recursion Factorial Calculator: Accepts input of a positive integer and returns the integer's factorial.
//          1.2 - Greatest Common Divisor Calculator: Accepts input of a larger and smaller integer and returns the greatest common divisor.
//            1.3 - Reverse Words Generator: Accepts input of a string and returns the string backwards.

//  Which Calculator or Generator to use?

//      2 - Scanner: accepts input from user. (More in-depth in Scanner Package)
//          2.1 - Message Prompt at the start of executing Recursion.main()
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
//          2.2 - (Define) accepted user inputs
        String factorial = "FACT";
        String greatestCommonDivisor = "GCD";
        String reverseWords = "WORDS";
//          2.3 - (Implementation) of Scanner to receive user input.
        Scanner console = new Scanner(System.in);
        double calculate;
        String response;
//          2.4 - (What if?) user input matches or doesn't match accepted user inputs 2.2
        do {
            response = console.nextLine();
//         2.4.1 - (What if?) user input matches accepted user inputs 2.2
            if (response.equals(factorial) || response.equals(greatestCommonDivisor) || response.equals(reverseWords)) {
                break;
//          2.4.2 - (What if?) user inputs doesn't match accepted user inputs 2.2: run error message
            } else {
                System.out.println(
                                 """
                                 INVALID
                                 Enter "FACT" to calculate factorials!
                                 Enter "GCD" to calculate greatest common divisors!
                                 Enter "WORDS" to reverse a word!EXCEPTION
                                 """
                                  );
                }
//         2.4.3 - Keep repeating 2.4.2 error message if 2.4.2 persists.
        } while (true);


//       3 - Factorials
//          3.1 - (What if?) user inputs matches accepted user inputs 2.2
        if (response.equals(factorial)) {
//          3.2 - (What if?) user inputs matches accepted user inputs 2.2
            System.out.println(
                    """
                    Lets find some factorials!
                    Enter an integer greater or equal to 0.
                    """
            );
            do {
//          3.3 - (What if?) do user inputs meet the requirements of new prompt
                try {
                    calculate = console.nextDouble();
//          3.4 - (Continue) user inputs meet requirements
                    if (calculate >= 0) {
                        break;
                    }
//          3.5 - (What if) user inputs are different data types such as a string?
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
//         3.6 - Keep repeating error message if user input does not meet prompt requirements greater or equal to 0
            while (calculate < 0) {
                System.out.println(
                                 """
                                 INVALID
                                 Enter a number greater or equal to 0.
                                 """
                                  );
                calculate = console.nextDouble();
            }
//          3.7 (Implementation) Continue by passing user input into recursiveFactorial method to calculate user input
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
            do {
                System.out.println(
                                 """
                                 INVALID
                                 Enter "FACT" to calculate factorials!
                                 Enter "GCD" to calculate greatest common divisors!
                                 Enter "WORDS" to reverse a word!REVERSE
                                 """
                                  );
                response = console.nextLine();
            } while (!response.equals(factorial) || !response.equals(greatestCommonDivisor) || !response.equals(reverseWords));
        }
    }


    //    Factorial Calculate Method
    public static double recursiveFactorial(double input) {
        if (input > 0) {
            System.out.println("Input: " + input + " Next Input: " + (input - 1));

            return input * recursiveFactorial(input - 1);
        } else {
            return 1;
        }
    }


//    Greatest Common Divisor Method
    public static int gcd(int largerNum, int smallerNum) {
        int remainder = 0;

        while (largerNum % smallerNum > 0) {
            remainder = largerNum % smallerNum;
            largerNum = smallerNum;
            smallerNum = remainder;
        }
        return smallerNum;
    }


//    Reverse Method
    public static String reverseWord(String text){
        if (text.length() == 0) {

            return text;
        } else {
            return reverseWord(text.substring(1)) + text.charAt(0);
        }
    }
}
