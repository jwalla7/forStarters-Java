package Loops;

import java.util.HashMap;
import java.util.Map;

/*
*
 * Roman Numeral Conversion
 *
 *
*
 */
public class RomanNumeral {
    public static void main(String[] args) {
        Map<String, Integer> romanMap = new HashMap();
        romanMap.put("I", 1);
        romanMap.put("V", 5);
        romanMap.put("X", 10);
        romanMap.put("L", 50);
        romanMap.put("C", 100);
        romanMap.put("D", 500);
        romanMap.put("M", 1000);

//        romanMap.forEach(rm -> System.out.println(rm));

        RomanNumeral test_0 = new RomanNumeral();
        System.out.println(test_0.RomanNumeralConversion("IVXLC"));
    }

//    Instance variables
    String romanNumeral = "";

//    Constructor
     public RomanNumeral() {}
//     Methods
     public String RomanNumeralConversion (String rm_s) {
         String final_rm = "";
         for (int r = rm_s.length() - 1; r > rm_s.length(); r--) {
             System.out.println(rm_s.charAt(r));
         }
         return final_rm;
     }
}
