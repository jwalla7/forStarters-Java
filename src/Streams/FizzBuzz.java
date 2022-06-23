package Streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(fizzBuzzDataList(99));
    }

    static List<String> fizzBuzzDataList (int cap) {
        return IntStream.rangeClosed(1, cap)
                 .mapToObj(i -> {
                     if (i % 15 == 0) return "FizzBuzz";
                     if (i % 5 == 0) return "Buzz";
                     if (i % 3 == 0) return "Fizz";
                     return String.valueOf(i);
                 })
                .collect(Collectors.toList());
    }
}
