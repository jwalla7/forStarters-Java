package Streams;

import java.util.function.IntPredicate;

public class CountVowels {
    public static void main(String[] args){
        System.out.println(testString("apple")); // 2
        System.out.println(testString("cheesecake")); // 5
        System.out.println(testString("bbb")); // 0
        System.out.println(testString("")); // 0
    }

    static IntPredicate vowel = new IntPredicate() {
        @Override
        public boolean test(int arg0) {
            return arg0 == 'a' || arg0 == 'e' || arg0 == 'o' || arg0 == 'u';
        }
    };

    static long testString(String s){
        String test = s;
        long count = test.chars().filter(vowel).count();

        return count;
    }
}
