package Lambdas;

import java.util.Arrays;
import java.util.List;

public class CollectionIterations {
    public static void main(String[] args) {
        List<Person> members = Arrays.asList(
                new Person("Charles", "Boyd", 64),
                new Person("Lewis", "Carter", 34),
                new Person("Thomas", "McKnight", 64),
                new Person("Charlotte", "Hairston", 64),
                new Person("Matthew", "Perry", 64)
        );
        System.out.println("------ For Loop ------");
        for (int i = 0; i < members.size(); i++) {
            System.out.println(members.get(i));
        }

        System.out.println();  
        System.out.println("------ For-In Loop ------");
        for (Person i : members) {
            System.out.println(i);
        }

        System.out.println();
        System.out.println("------ For-Each Lambda Loop ------");
        members.forEach(System.out::println); // p -> System.out.println(p)
    }
}
