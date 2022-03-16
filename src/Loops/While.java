package Loops;

//  While: A method that executes repeatedly until a specified condition is met.

import java.util.InputMismatchException;
import java.util.Scanner;

public class While {

    public static void main(String[] args) {
//      1 - Introduction: This exercise utilizes algorithms that utilize the while method.
//       1.1 - Palindrome Integer: Accepts input of a positive integer and validates if input is a Palindrome.
//        1.2 - Palindrome String: Accepts input a string and validates if input is a Palindrome.
/*         1.3 - What is a Palindrome? A word, phrase, or sequence that reads the same backwards as forwards.
*                For example, 121 is a palindrome while 123 is not.
*                   121 -> forwards equals 121
*                   121 <- backwards equals 121
*                   123 -> forwards equals 123
*                   123 <- backwards equals 321 and does not equal 123.
*/

//        Which method, Palindrome Integer or Palindrome String?

//      2 - Scanner: accepts input from user.
//          2.1 - Message Prompt at the start of executing While.main()
        System.out.println(
                         """
                         |----------------------| |----------------------|
                         |  Palindrome Integer  | |  Palindrome String   |
                         |       Generator      | |       Generator      |
                         |----------------------| |----------------------|
                         Type in INT to check if an integer is a palindrome!
                         Type in STR to check if a phrase is a palindrome!
                         """
                         );
//          2.1 - (Define) accepted user inputs
        String integer = "INT";
        String phrase = "STR";
        String response;
        int number;
//          2.2 - (Implementation) of Scanner to receive user input.
        Scanner console = new Scanner(System.in);
        do {
            response = console.nextLine();
                if (response.equals(integer) || response.equals(phrase)) {

                    break;
                } else {
                    System.out.println(
                                     """
                                     INVALID
                                     Enter "INT" to check if an integer is a palindrome!
                                     Enter "STR" to check if a phrase is a palindrome!
                                     """
                                      );
                }
        } while (true);

        if (response.equals(integer)) {
            System.out.println(
                             """
                             Is your integer a Palindrome?
                             Enter an integer.
                             """
                              );
            do {
                try {
                    number = console.nextInt();

                    if (number > 0) {
                        break;
                    } else {
                        System.out.println("" +
                                         "uh oh, " + number + " failed the first checkpoint and is not a palindrome." + '\n'
                                         + "Let's try another number."
                                          );
                    }
                } catch (InputMismatchException eMis) {
                    System.out.println(
                                     """
                                     INVALID
                                     Enter an integer.
                                     """
                                      );
                } catch (Exception e) {
                    System.out.println(
                                     """
                                     INVALID
                                     Enter an integer.
                                     """
                                      );
                } finally {
                    response = console.nextLine();
                }
            } while (true);
            System.out.println(
                             "Checking if " + number + " is a palindrome..."
                              );
            if (palindromeInt(number)) {
                System.out.println(
                                 "Yes, " + number + " is a palindrome!"
                                  );
            } else {
                System.out.println(
                                 "Sorry, " + number + " is not a palindrome!"
                                  );
            }
        }

        if (response.equals(phrase)) {
            System.out.println(
                             """
                             Is your phrase a Palindrome?
                             Enter an phrase.
                             """
                             );
            do {
                try {
                    response = console.nextLine();

                    if (response.length() > 0) {
                        break;
                    } else {
                        System.out.println(
                                         "uh oh, " + response + " failed the first checkpoint and is not a palindrome." + '\n'
                                         + "Let's try another phrase."
                                          );
                    }
                } catch (Exception e) {
                    System.out.println(
                                     """
                                     INVALID
                                     Enter a phrase.
                                     """
                                      );
                } finally {
                }
            } while (true);
            System.out.println(
                             "Checking if " + response + " is a palindrome..."
            );
            if (palindromeStr(response) == true) {
                System.out.println(
                        "Yes, " + response + " is a palindrome!"
                );
            } else {
                System.out.println(
                                 "Sorry, " + response + " is not a palindrome."
                );
            }
        }
    }

//    Palindrome Integer Method
    public static boolean palindromeInt(int input) {
        if (input < 0 || input % 10 == 0 && input != 0) {
//      1 - (What if) Invalid Cases:
//       1.1 - Invalid Case 1 - If input is a negative number (input < 0 ).
/*        1.2 - Invalid Case 2 - If input's 10's place is equal to 0 (input % 10 = 0) AND input is not 0.
*         For example, 25 % 10 = 5 and 256 % 10 = 6.
*/
            System.out.println(
                             "Integer " + input + " is not a palindrome."
                              );

            return false;
        }
        int num = 0;
        while (input > num) {
            num = (num * 10) + (input % 10);

            input /= 10;
        }
        return input == num || input == num / 10;
    }

//    Palindrome String Method
    public static boolean palindromeStr(String submission) {
        submission = submission.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
//        Define pointers
        int left = 0;
        int right = submission.length() - 1;

        while (left <= right) {
//            While Conditions:
//             1 - repeat as long as the left pointer does not pass the right pointer.
            if (submission.charAt(left) != submission.charAt(right)) {
/*              If characters at the index of the left pointer don't match characters at the index of the right pointer,
                the user's input in not a palindrome.
*/
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
