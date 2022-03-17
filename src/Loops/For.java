package Loops;

/*

For: A for loop repeats until a specified condition evaluates false. The structure of a for loop consist of three expressions.
        1 - an initialization expression,
         1.1 - a conditional expression,
          1.2 - an incremental expression
    For example, for ( [initialExpression]; [conditionExpression]; [incrementExpression]) {
        Block Statement
}

 */

import java.util.*;

public class For {

    public static void main(String[] args) {
//      1 - Introduction: This exercise utilizes various algorithms that utilize for loops.
//       1.1 - FizzBuzz: Returns a string array of numbers and implements three conditionals Fizz, Buzz and FizzBuzz.
//        1.2 - Two Sum: Reads through an array of numbers and returns the index of two numbers where it's sum matches a target number.
//      2 - Scanner: accepts input from user.
//       2.1 - Message Prompt at the start of executing Recursion.main()
        System.out.println(
                         """
                         |----------------------| |----------------------|
                         |        FizzBuzz      | |       Two Sum        |
                         |----------------------| |----------------------|
                         Type in FIZZ to run FizzBuzz!
                         Type in SUM to run Two Sum!
                         """
                          );
//          2.2 - (Define) accepted user inputs
        String fizzBuzzResponse = "FIZZ";
        String twoSumResponse = "SUM";
//          2.3 - (Implementation) of Scanner to receive user input.
        Scanner console = new Scanner(System.in);
        String response;
        int target;
        int[] capacity;
        int capacityInt;

        do {
            response = console.nextLine();
//          2.4 - (What if?) user input matches accepted user inputs 2.2
            if (response.equals(fizzBuzzResponse) || response.equals(twoSumResponse)) {
                break;
//          2.5 - (What if?) user inputs doesn't match accepted user inputs 2.2: run error message
            } else {
                System.out.println(
                                 """
                                 INVALID
                                 Enter "FIZZ" to run FizzBuzz!
                                 Enter "SUM" to run Two Sum!
                                 """
                                  );
            }
//         2.6 - Keep repeating 2.4 error message if 2.4 persists.
        } while (true);

        if (response.equals(fizzBuzzResponse)) {
//         2.7 - (What if?) user inputs match accepted user inputs 2.2
            System.out.println(
                    """
                            Lets run FizzBuzz!
                            FizzBuzz will generate a list of numbers up to the number you input.
                            FizzBuzz will then:
                            1. replace all numbers in the list divisible by 3 with the phrase "Fizz"
                            2. replace all numbers in the list divisible by 5 with the phrase "Buzz"
                            3. replace all numbers in the list divisible by both 3 and 5 with the phrase "FizzBuzz"
                            Let's start!
                            Enter a number greater than 15
                            """
            );
        }
        do {
            capacityInt = console.nextInt();
            try {
                if (capacityInt > 15) {
                    break;
                } else {
                    System.out.println(
                            "Invalid, enter a number larger than " + capacityInt + "."
                    );
                }
            } catch (InputMismatchException eInput) {
                System.out.println(
                        "Invalid, enter a number larger than 15."
                );
            } catch (Exception e) {
                System.out.println(
                        "Invalid, enter a number larger than " + capacityInt + "."
                );
            } finally {
                response = console.nextLine();
            }
        } while (true);
        System.out.println(
                "Calculating numbers up to " + capacityInt + " ..." + '\n'
                + "Calculating FIZZ... " + '\n'
                + "Calculating BUZZ... " + '\n'
                + "Calculation FIZZBUZZ..."
        );
        System.out.println(fizzBuzzMethod(capacityInt));

        if (response.equals(twoSumResponse)) {
            System.out.println(
                             """
                            Lets run Two Sum!
                            Two Sum will generate an array of random numbers and will accept a target number.
                            Two sum will then find 
                            Two Sum will then:
                            1. replace all numbers in the list divisible by 3 with the phrase "Fizz"
                            2. replace all numbers in the list divisible by 5 with the phrase "Buzz"
                            3. replace all numbers in the list divisible by both 3 and 5 with the phrase "FizzBuzz"
                            Let's start!
                            Enter a number greater than 15
                            """
            );
        }
    }

    //    FizzBuzz Method
    public static List<String> fizzBuzzMethod (int capacity) {
        List<String> fizzBuzzData = new ArrayList<>();

        for (int number = 1; number <= capacity; number++) {
            if (number % 15 == 0) {
                fizzBuzzData.add("FizzBuzz");

            } else if (number % 5 == 0) {
                fizzBuzzData.add("Buzz");

            } else if (number % 3 == 0) {
                fizzBuzzData.add("Fizz");

            } else {
                fizzBuzzData.add(String.valueOf(number));
            }
        }
        return fizzBuzzData;
    }

    //      Two Sum Method
    public static int[] twoSumMethod (int[] capacity, int target) {
        return null;
    }
}