package Streams;

import Lambdas.Person;

import java.util.Arrays;
import java.util.List;

public class StreamBasics {
    public static void main(String[] args) {
        List<Person> members = Arrays.asList(
                new Person("Charles", "Boyd", 61),
                new Person("Lewis", "Carter", 32),
                new Person("Thomas", "McKnight", 7),
                new Person("Charlotte", "Hairston", 35),
                new Person("Matthew", "Perry", 24)
        );


//       Filter members with first names that start with C
        members.stream()
                .filter(m -> m.getFirstName().startsWith("C"))
                .forEach(m -> System.out.println(m.getFirstName() + " " + m.getLastName() + " is " + m.getAge() + "years old"));

    }
}
