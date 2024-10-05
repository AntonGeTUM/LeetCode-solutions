import java.util.Arrays;

public class PermutationInString {

    /**
     * Given two Strings s1 and s2, return true if s2 contains a permutation of s1.
     * Example: s1 = "ab", s2 = "eidbaooo" => true
     * Explanation: s2 contains the sequence 'ba' which is a permutation of s1.
     * Solution: We apply a form of sliding window and bucket sort to check whether s2 contains a contiguous sequence
     *           of all the characters in s1. For every char in s1 we increment the count, and for every char in s2
     *           we decrement it. s2 contains a permutation of s1 if the array contains only zeroes.
     *           We create an initial window in the first loop. If a permutation has not been found we slide the
     *           window to the right by incrementing the count for every char that left the window.
     * **/

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) return false;

        int[] count = new int[26];
        final int[] ZERO = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (Arrays.equals(count, ZERO)) return true;

        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (Arrays.equals(count, ZERO)) return true;
        }
        return false;
    }
}
