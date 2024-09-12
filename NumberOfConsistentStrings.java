
public class NumberOfConsistentStrings {

    /**
     * Given a String 'allowed' consisting of distinct chars, and an array of Strings, return the number of Strings
     * that only consist of allowed letters.
     * Example: allowed = "ab", words = ["ad","bd","aaab","baa","badab"] => 2
     * Explanation: "aaab" and "baa" only use letters from the Strign 'allowed'
     * Solution: Create a boolean array for every allowed letter as a quick look-up. For every String in the
     *           array, iterate over the chars and abort if any char isn't marked in the boolean array.
     *           If 'allowed' has length 26, i.e. contains all letters of the English alphabet, all the words
     *           are consistent.
     * **/

    public int countConsistentStrings(String allowed, String[] words) {
        if (allowed.length() == 26) return words.length;

        boolean[] allowedLetters = new boolean[26];
        for (int i = 0; i < allowed.length(); i++) {
            allowedLetters[allowed.charAt(i) - 'a'] = true;
        }
        int res = 0;
        for (String word : words) {
            if (helper(allowedLetters, word)) res++;
        }
        return res;
    }

    private boolean helper(boolean[] allowed, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!allowed[word.charAt(i) - 'a']) return false;
        }
        return true;
    }
}
