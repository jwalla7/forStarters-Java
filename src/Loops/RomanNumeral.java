package Loops;

import java.util.*;

/*
*   Roman Numeral Conversion
 *   1.0 Store Roman Numeral key:value pairs
 *   1.1 Iterate through Roman Numeral key:value pairs
*    1.2 Accept a String of Roman Numerals
*    1.3 Convert String to a number
*/

public class RomanNumeral {
    public static void main(String[] args) {
        System.out.println(roman_numeralMap);
        RomanNumeral test_0 = new RomanNumeral();
        System.out.println(test_0.RomanNumeralConversion("III")); // 3
        System.out.println(test_0.RomanNumeralConversion("IIIV")); // 6
        System.out.println(test_0.RomanNumeralConversion("LVII")); // 58
        System.out.println(test_0.RomanNumeralConversion("LXXXIX")); // 89
        System.out.println(test_0.RomanNumeralConversion("CMLII")); // 952
        System.out.println(test_0.RomanNumeralConversion("MCMXCIV")); // 1994
        System.out.println(test_0.RomanNumeralConversion("MMD")); // 2500
    }

    static final Map<Character, Integer> roman_numeralMap = new LinkedHashMap<>() {{
    /*
    *    Anonymous Inner Class (Static Initializer/Block) - Static Initializers are run before main method, constructors and methods.
     *     The first brace creates a new Anonymous Inner Class.
     *     The second declares an "Instance Initializer" block that will run when
    *      the Anonymous Inner Class is instantiated.
     */
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

//    Constructor
     public RomanNumeral() {}

//     Methods
     public int RomanNumeralConversion (String roman_num_string) {
         int roman_num_result = 0;
         int prev_idx_value = 0;

         for (char roman_n : roman_num_string.toCharArray()) {
             int curr_idx_value = roman_numeralMap.get(roman_n);
             roman_num_result = ((curr_idx_value > prev_idx_value) ?
                                  roman_num_result - prev_idx_value + (curr_idx_value - prev_idx_value)
                                : roman_num_result + curr_idx_value);

             prev_idx_value = curr_idx_value;
         }
         return roman_num_result;
     }
}
