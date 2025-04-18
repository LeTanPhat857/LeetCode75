public class MediumReverseWordsInAString {
    /* Description
        Given an input string s, reverse the order of the words.
        A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
        Return a string of the words in reverse order concatenated by a single space.
        Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

        Example 1:
        Input: s = "the sky is blue"
        Output: "blue is sky the"

        Example 2:
        Input: s = "  hello world  "
        Output: "world hello"
        Explanation: Your reversed string should not contain leading or trailing spaces.

        Example 3:
        Input: s = "a good   example"
        Output: "example good a"
        Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

        Constraints:
            1 <= s.length <= 104
            s contains English letters (upper-case and lower-case), digits, and spaces ' '.
            There is at least one word in s.

        Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
     */

    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                int j = i;
                while (j >= 0 && s.charAt(j) != ' ') {
                    word.insert(0, s.charAt(j));
                    j--;
                }
                if (!result.isEmpty()) {
                    result.append(' ').append(word);
                }
                else {
                    result.append(word);
                }
                word.setLength(0);
                i = j;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        MediumReverseWordsInAString mediumReverseWordsInAString = new MediumReverseWordsInAString();
        System.out.println(mediumReverseWordsInAString.reverseWords("the sky is blue")); // expected "blue is sky the"
        System.out.println(mediumReverseWordsInAString.reverseWords("  hello world  ")); // expected "world hello"
        System.out.println(mediumReverseWordsInAString.reverseWords("a good   example")); // expected "example good a"
        System.out.println(mediumReverseWordsInAString.reverseWords("   ")); // expected ""
        System.out.println(mediumReverseWordsInAString.reverseWords("good")); // expected "example good a"
    }
}
