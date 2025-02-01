public class EasyGreatestCommonDivisorOfStrings {
    /*  Description
        For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
        Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

        Example 1:
        Input: str1 = "ABCABC", str2 = "ABC"
        Output: "ABC"

        Example 2:
        Input: str1 = "ABABAB", str2 = "ABAB"
        Output: "AB"

        Example 3:
        Input: str1 = "LEET", str2 = "CODE"
        Output: ""

        Constraints:
        1 <= str1.length, str2.length <= 1000
        str1 and str2 consist of English uppercase letters.
     */

    public String gcdOfStrings(String str1, String str2) {
        if (str1.equals(str2)) {
            return str1;
        }

        if (str1.length() < str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        if (str1.startsWith(str2)) {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }

        return "";
    }

    public static void main(String[] args) {
        EasyGreatestCommonDivisorOfStrings easyGreatestCommonDivisorOfStrings = new EasyGreatestCommonDivisorOfStrings();
        System.out.println(easyGreatestCommonDivisorOfStrings.gcdOfStrings("ABCABC", "ABC")); // expected "ABC"
        System.out.println(easyGreatestCommonDivisorOfStrings.gcdOfStrings("ABABAB", "ABAB")); // expected "AB"
        System.out.println(easyGreatestCommonDivisorOfStrings.gcdOfStrings("LEET", "CODE")); // expected ""
        System.out.println(easyGreatestCommonDivisorOfStrings.gcdOfStrings("ABCDEF", "ABC")); // expected ""
        System.out.println(easyGreatestCommonDivisorOfStrings.gcdOfStrings("ABC", "A")); // expected ""
    }
}
