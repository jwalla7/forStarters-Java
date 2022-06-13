package Lambdas;

import java.util.function.BiConsumer;

public class ExceptionHandlingLambdas {
    public static void main(String[] args) {
        int [] arrayOfNumbers = {1, 2, 3, 4};
        int key = 2;
        int throwExceptionKey = 0;

        process(arrayOfNumbers, key, (j, k) -> System.out.print(j * k + " "));
        System.out.println("------ Original Lambda - Multiplication ------");

        System.out.println("------ Test Lambda - BiConsumer ------");
        process(arrayOfNumbers, throwExceptionKey, testWrapperLambda((j, e) -> System.out.print(j / e + " ")));


        process(arrayOfNumbers, key, addWrapperLambda((j, k) -> System.out.println(j * k)));
        System.out.println("------ Wrapped Lambda - Addition ------");

        process(arrayOfNumbers, key, divisorWrapperLambda((j, k) -> System.out.println(j * k )));
        System.out.println("------ Wrapped Lambda - Division ------");

        System.out.println("------ Wrapped Lambda - is Number Even? ------");
        process(arrayOfNumbers, key, isEvenLambda((j, k) -> System.out.println(j * k)));

    }

    private static void process(int[] numbers, int key, BiConsumer<Integer, Integer> consumer) {
        for (int n : numbers) {
            consumer.accept(n, key);
        }
    }

    private static BiConsumer<Integer, Integer> testWrapperLambda(BiConsumer<Integer, Integer> consumer) {
        return (p, q) -> {
          try {
              consumer.accept(p, q);
          } catch (ArithmeticException aE) {
              System.out.println(p + "/" + q + " Exception caught in testWrapperLambda");
            }
        };
    }

    private static BiConsumer<Integer, Integer> addWrapperLambda(BiConsumer<Integer, Integer> consumer) { // Lambda to Handle Exceptions
//         Accepts then overrides Lambda that is passed through consumer.
//          for example (j , k) -> System.out.println(j * k); becomes (a , b) -> System.out.println(a + b);
        return (a, b) -> System.out.print(a + b + " ");
    }

    private static BiConsumer<Integer, Integer> divisorWrapperLambda(BiConsumer<Integer, Integer> consumer) {
        return (x, y) -> System.out.print(x / y + " ");
    }
    
    private static BiConsumer<Integer, Integer> isEvenLambda(BiConsumer<Integer, Integer> consumer) {
        return (BiConsumer<Integer, Integer>) (o, n) -> {
            if ((o % n == 0)) {
                System.out.println( o + " is even");
            } else {
                System.out.println(o +" is odd");
            }
        };
    }

}
