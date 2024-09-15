import java.util.Arrays;

public class LongestSubstringEvenVowelCounts {

    /**
     * Given the string s, return the size of the longest substring containing each vowel an even number of times.
     * Example: s = "eleetminicoworoep" => 13
     * Explanation: "leetminicowor" is the longest substring that contains an even number of 'a', 'e', 'i', 'o' and 'u'.
     * Solution: Similar to the theme of previous days, we can make use of some properties of XOR. Instead of
     *           counting the actual occurrences of each vowel, we can use XOR to keep track whether a vowel appears
     *           an even or odd number of times. Every second appearance of a vowel essentially cancels out its
     *           previous appearance.
     *           We can use a prefix array to store the results:
     *            - we XOR the char value of a vowel or zero if it's a consonant
     *            - pre[i] = 0 means all vowels appear an even number of times until index i
     *            - if a non-zero value has appeared before, the distance between the first and last index represents
     *              a valid substring length.
     *           One could use a HashMap to store all unique XOR values and find each first and last indices but that
     *           would result in a rather poor runtime performance.
     *           Below is an optimized solution:
     *            - each vowel is represented as a bit in a 5-bit value [00000]: [00001] -> 'a', [00010] -> 'e',...
     *            - there are 2^5 = 32 possible values => use an array instead of a HashMap
     *            - iterate over the string and use the char look-up table for XOR'ing => store each first
     *              appearance of a XOR result in 'possibleValues'
     *            - if it isn't the first appearance, calculate the distance
     * **/

    public int findTheLongestSubstring(String s) {
        char[] charLUT = {1, 0, 0, 0, 2, 0, 0, 0, 4, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0};

        int[] possibleValues = new int[32];
        Arrays.fill(possibleValues, -1);
        int mask = 0;
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            mask ^= charLUT[s.charAt(i) - 'a'];
            if (mask != 0 && possibleValues[mask] == -1) possibleValues[mask] = i;
            else res = Math.max(res, i - possibleValues[mask]);
        }
        return res;
    }

}
