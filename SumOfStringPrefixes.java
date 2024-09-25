public class SumOfStringPrefixes {

    /**
     * Given an array 'words' of strings, return an int array containing the prefix scores of each string.
     * A prefix score for a string s is the number of strings in the given array such that a prefix of s is also a
     * prefix for words[i].
     * Example: words = ["abc", "ab", "bc", "b"] => [5, 4, 3, 2]
     * Explanation: "abc" has prefixes 'a', 'ab', and 'abc'; two words share prefix 'a', two words share prefix
     *              'ab' and one word has a prefix 'abc' (the word itself).
     *              etc.
     * Solution: In similar fashion to yesterday's task, a Trie structure can help with the runtime complexity. Here,
     *           a TrieNode has the attributes 'count' and 'children' where each child is a lowercase English letter.
     *           Again, start by constructing the Trie by iterating over the array and creating nodes for new
     *           sequences of chars or incrementing the 'count' attributes if the same path already exists. Next,
     *           go over the array a second time and use the 'count' values to calculate the score of each word.
     * **/

    static class TrieNode {
        int count;
        TrieNode[] children;

        public TrieNode() {
            this.count = 1;
            this.children = new TrieNode[26];
        }
    }

    public int[] sumPrefixScores(String[] words) {
        int[] res = new int[words.length];
        TrieNode root = new TrieNode();
        for (String s : words) builtTrie(root, s);
        for (int i = 0; i < res.length; i++) {
            res[i] = countPrefixes(root, words[i]);
        }
        return res;
    }

    public void builtTrie(TrieNode node, String s) {
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            } else {
                node.children[index].count++;
            }
            node = node.children[index];
        }
    }

    public int countPrefixes(TrieNode node, String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            res += node.children[index].count;
            node = node.children[index];
        }
        return res;
    }
}
