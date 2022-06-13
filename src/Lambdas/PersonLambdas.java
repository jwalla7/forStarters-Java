package Lambdas;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PersonLambdas {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Boyd", 64),
                new Person("Lewis", "Carter", 34),
                new Person("Thomas", "McKnight", 64),
                new Person("Charlotte", "Hairston", 64),
                new Person("Matthew", "Perry", 64)
        );

        System.out.println("------ All Names in list sorted by Last Name ------");
 /*
*             Collections.sort(people, new Comparator<Person>() {
 *
 *              @Override
 *              public int compare(Person o1, Person o2) {
 *                  return o1.getLastName().compareTo(o2.getLastName());
 *              }
*            });
  */
        Collections.sort(people, (Person p1, Person p2) -> p1.getLastName().compareTo(p2.getLastName()));
        printConditionally(people, p -> true, p -> System.out.println(p));
        System.out.println();

        System.out.println("------ All Names in list sorted by First Name ------");
//        Collections.sort(people, (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
        Collections.sort(people, Comparator.comparing(Person::getFirstName));
        printConditionally(people, p -> true, p -> System.out.println(p));
        System.out.println();

        System.out.println("------ Last Names in list that start with C ------");
        printConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p));
        System.out.println();

        System.out.println("------ First Names in list that start with C ------");
        printConditionally(people, p -> p.getFirstName().startsWith("C"), p -> System.out.println(p));
        System.out.println();
    }

//    Print Conditionally
    private static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p : people) {
            if (predicate.test(p)) {
                consumer.accept(p);
            }
        }
    }
}
