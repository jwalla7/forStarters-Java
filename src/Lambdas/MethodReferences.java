package Lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferences {
    public static void main(String[] args) {
//        Example 1.0
        System.out.println("------ Example 1.0 ------");
        Thread thread_1 = new Thread(MethodReferences::noArgumentMethodMessage);
        thread_1.start(); // MethodReferences::noArgumentMethodMessage = () -> noArgumentMethodMessage();

//        Example 1.2
        List<Person> teammates = Arrays.asList(
                new Person ("Jeremy", "Bronze", 22),
                new Person ("Benjamin", "Lewis", 65)
        );
        System.out.println("------ Example 1.2 ------");
        performSearch(teammates, p -> true, System.out::println); // p -> performSearch(p);
        System.out.println();

    }

    private static void noArgumentMethodMessage () {
        System.out.println("This method has no arguments and is using Method Referencing ");
    }

    private static void performSearch(List<Person> t, Predicate<Person> p, Consumer<Person> c) {
        for (Person i : t) {
            p.test(i);
            c.accept(i);
        }
    }


}
