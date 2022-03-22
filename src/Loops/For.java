package Loops;

/*

For: A for loop repeats until a specified condition evaluates false. The structure of a for loop consists of three expressions.
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
/*

    1 - Introduction: This exercise utilizes various algorithms that utilize for loops.
     1.1 - FizzBuzz: Returns a string array of numbers and implements three conditionals Fizz, Buzz and FizzBuzz.
      1.2 - Two Sum: Reads through an array of numbers and returns the index of two numbers where it's sum matches a target number.
    2 - Scanner: accepts input from user.
     2.1 - Message Prompt at the start of executing Recursion.main()

*/
        System.out.println(
                         """
                         |----------------------| |----------------------|
                         |        FizzBuzz      | |       Two Sum        |
                         |----------------------| |----------------------|
                         Type in FIZZ to run FizzBuzz!
                         Type in SUM to run Two Sum!
                         """
                          );
        Scanner console = new Scanner(System.in);
        String fizzBuzzResponse = "FIZZ";
        String twoSumResponse = "SUM";
        String response;
        int target;
        int capacity;
        int capacityInt;
        int [] randomNumbersArray;

        do {
            response = console.nextLine();

            if (response.equals(fizzBuzzResponse) || response.equals(twoSumResponse)) {
                break;
            } else {
                System.out.println(
                                 """
                                 INVALID
                                 Enter "FIZZ" to run FizzBuzz!
                                 Enter "SUM" to run Two Sum!
                                 """
                                  );
            }
        } while (true);

        if (response.equals(fizzBuzzResponse)) {
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
            do {
                capacityInt = console.nextInt();
                try {
                    if (capacityInt > 15) {
                        break;
                    } else {
                        System.out.println( "Invalid, enter a number larger than " + capacityInt + "." );
                    }
                } catch (InputMismatchException eInput) {
                    System.out.println( "Invalid, enter a number larger than 15." );
                } catch (Exception e) {
                    System.out.println( "Invalid, enter a number larger than " + capacityInt + "." );
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
        }

        if (response.equals(twoSumResponse)) {
            System.out.println(
                             """
                             Lets run Two Sum!
                             1. Two Sum will generate an array of random integers and will accept a target integer.
                             2. Two sum will then find the first occurrence of two random integers equal to the target integer.
                             3. Two sum will return the indices of the first occurrence.
                             Let's start!
                             Enter a number greater than 3
                             """
                              );

            do {
                capacity = console.nextInt();
                try {
                    if (capacity > 3) {
                        break;
                    } else {
                        System.out.println( "Invalid, enter a integer larger than " + capacity + "." );
                    }
                } catch (InputMismatchException eMis) {
                    System.out.println( "Invalid, enter a integer larger than 3." );
                } catch (Exception e) {
                    System.out.println( "Invalid, enter a integer larger than 3." );
                } finally {
                    response = console.nextLine();
                }
            } while (true);

            randomNumbersArray = generateRandomNumbers(capacity);
            System.out.println(
                    "Calculating " + capacity + " random integers..." + '\n'
                            + "Creating integers..." + Arrays.toString(randomNumbersArray) + '\n'
                            + """
                           Now, lets enter in an integer you want the sum of two random integers to equal.
                           Enter in an integer greater than 0.
                             """
                              );
            do {
                target = console.nextInt();
                try {
                    if (target > 0) {
                        break;
                    } else {
                        System.out.println( "Invalid, enter a integer larger than " + target + "." );
                    }
                } catch (InputMismatchException eMis) {
                    System.out.println( "Invalid, enter a integer larger than 0." );
                } catch (Exception e) {
                    System.out.println( "Invalid, enter a integer larger than 0." );
                } finally {
                    response = console.nextLine();
                }
            } while (true);

            System.out.println(
                    "Searching through list of random integers... " + Arrays.toString(randomNumbersArray) + '\n'
                            + "Finding which indices have the first occurrence of when two random integers equals " + target + " ..."
            );
            System.out.println(Arrays.toString(twoSumMethod(randomNumbersArray, target)));
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

//    Random Integers Array Generator Method
    public static int[] generateRandomNumbers (int capacity) {
        Random randomNumberGenerator = new Random();
        int [] generatedArray = new int[capacity];

        for (int integers = 0; integers < generatedArray.length; integers++) {
            generatedArray[integers] = randomNumberGenerator.nextInt(capacity);
        }
        return generatedArray;
    }

//    Two Sum Method
    public static int[] twoSumMethod (int [] capacity, int target) {
        Map<Integer, Integer> consolidate = new HashMap<>();
        int [] occurrence = new int [2];

        for (int integer = 0; integer < capacity.length; integer++) {
            if (consolidate.containsKey(target - capacity[integer])) {
                occurrence[1] = integer;
                occurrence[0] = consolidate.get(target - capacity[integer]);

                return occurrence;
            }
            consolidate.put(capacity[integer], integer);
        }
        if (occurrence[0] == 0 && occurrence[1] == 0) {
            System.out.println(" There are no instances of Two Sum in this array, try again.");
        }
        return occurrence;
    }
}