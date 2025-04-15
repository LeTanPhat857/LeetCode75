public class EasyReverseVowelsOfAString {
    /* Description
        Given a string s, reverse only all the vowels in the string and return it.
        The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

        Example 1:
        Input: s = "IceCreAm"
        Output: "AceCreIm"
        Explanation:
        The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

        Example 2:
        Input: s = "leetcode"
        Output: "leotcede"

        Constraints:
        1 <= s.length <= 3 * 105
        s consist of printable ASCII characters.
     */
    char[] vowelArr = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isVowel(sb.charAt(left))) {
                left++;
            }
            while (left < right && !isVowel(sb.charAt(right))) {
                right--;
            }
            if (left < right) {
                char temp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, temp);
                left++;
                right--;
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        for (char vowel : vowelArr) {
            if (c == vowel) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EasyReverseVowelsOfAString easyReverseVowelsOfAString = new EasyReverseVowelsOfAString();
        System.out.println(easyReverseVowelsOfAString.reverseVowels("IceCreAm")); // expected "AceCreIm"
        System.out.println(easyReverseVowelsOfAString.reverseVowels("leetcode")); // expected "leotcede"
    }
}
