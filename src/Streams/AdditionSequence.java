package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdditionSequence {
    public static void main(String[] args) {
        System.out.println(sumSequence(5,9,6));
    }

 /*
*
 * Sum of sequence
 * i++ until j; j-- until k; Return sum of sequence
 * for example: i = 5, j = 9, k = 6; (5 + 6 + 7 + 8 + 9 + 8 + 7 + 6) = 56
*
 */
    public static long sumSequence(int i, int j, int k) {
        List<Integer> count = new ArrayList<>();

        if (i > j || j < k) return 0;
        IntStream.rangeClosed(i, j).forEach(a -> count.add(a));
        IntStream.range(k, j).filter(b -> b < j).forEach(b -> count.add(b));
        long end = count.stream().collect(Collectors.summingInt(Integer::intValue));

        return end;
    }
}
