package Streams;

import java.util.Arrays;

public class FindSmallestLargestNumber {
    public static void main(String[] args){
        System.out.println(maxNumber(new int[] {4, 5, 1, 3})); // 5
        System.out.println(minNumber(new int[] {4, 5, 1, 3})); // 1
        System.out.println(maxNumber(new int[] {1000, 1001, 857, 1})); // 1001
        System.out.println(minNumber(new int[] {1000, 1001, 857, 1})); // 1
    }

    static int maxNumber(int[] a){
        int max = Arrays.stream(a).max().getAsInt();

        return max;
    }

    static int minNumber(int[] a){
        int min = Arrays.stream(a).min().getAsInt();

        return min;
    }
}
