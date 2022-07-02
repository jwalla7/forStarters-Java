package Loops;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/*
*   Roman Numeral Conversion
 *   1.0 Create a LinkedHashMap to store Roman Numeral key:value pairs
 *   1.1 Utilize the ForIn Loop to iterate through LinkedHashMap
*    1.2 Accept a String of Roman Numerals*
*/

public class RomanNumeral {
    public static void main(String[] args) {
        System.out.println(roman_numeralMap);
        RomanNumeral test_0 = new RomanNumeral();
        test_0.RomanNumeralConversion("LVII");
    }

    static Map<Character, Integer> roman_numeralMap = new LinkedHashMap<>() {{
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
     public void RomanNumeralConversion (String rm_string) {
         char[] rm_chars = new StringBuilder(rm_string) //  Reverse String and convert to a char[] array
                 .reverse()
                 .toString()
                 .toCharArray();

         for (char rm_char : rm_chars) {
//             System.out.println(rm_char);
             if (roman_numeralMap.containsKey(rm_char)) {
                 System.out.println(roman_numeralMap.get(rm_char));
             }
         }
     }

}
