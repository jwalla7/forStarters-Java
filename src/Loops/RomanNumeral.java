package Loops;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/*
*
 * Roman Numeral Conversion
 *  Create a LinkedHashMap to store Roman Numeral key:value pairs
 *  Utilize the ForIn Loop to iterate through LinkedHashMap
 *  Accept a String of Roman Numerals
*
 */
public class RomanNumeral {
    public static void main(String[] args) {
    Map<Character, Integer> roman_numeralsMap = new LinkedHashMap<>();
        roman_numeralsMap.put('I', 1);
        roman_numeralsMap.put('V', 5);
        roman_numeralsMap.put('X', 10);
        roman_numeralsMap.put('L', 50);
        roman_numeralsMap.put('C', 100);
        roman_numeralsMap.put('D', 500);
        roman_numeralsMap.put('M', 1000);

        System.out.println(roman_numeralsMap);
    }
//    Instance variables


//    Constructor
     public RomanNumeral() {}
//     Methods
     public void RomanNumeralConversion (String rm_s) {
     }
}
