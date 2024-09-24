public class FindLongestCommonPrefix {

    /**
     * Given two arrays arr1 and arr2, find the longest prefix of numbers between the two arrays, i.e. not
     * between numbers of the same array. A common prefix needs to be a prefix of at least one pair of numbers
     * from arr1 and arr2.
     * Example: arr1 = [1,10,100], arr2 = [1000] => 100
     * Explanation: The longest common prefix between numbers from arr1 and arr2 is between 100 and 1000.
     * Solution: We use a Trie structure to avoid checking every pair of numbers individually. First, construct a Trie
     *           from numbers of the first array. A TrieNode stores its current level and an array of its children.
     *           Each child, that is present, represents a digit between 0 and 9. E.g. for the number 100, we receive
     *           children[1] -> children[0] -> children[0].
     *           After constructing the Trie, we iterate over the second array. For every matching digit, we follow
     *           the nodes to find the longest prefix.
     *           The helper function 'digits(int n)' returns the number of digits for an integer n. It's a slight
     *           runtime optimization over converting an int to a String and going over each char.
     * **/

    int maxLevel;

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        maxLevel = 0;
        TrieNode root = new TrieNode(0);
        for (int i : arr1) builtTrie(root, i);
        for (int i : arr2) traverse(root, i);
        return maxLevel;
    }

    public void builtTrie(TrieNode node, int number) {
        int len = digits(number);
        while (len > 0) {
            int curDigit = (number / len) % 10;
            if (node.children[curDigit] == null) {
                node.children[curDigit] = new TrieNode(node.level + 1);
            }
            node = node.children[curDigit];
            len /= 10;
        }
    }

    public void traverse(TrieNode node, int number) {
        int len = digits(number);
        while (len > 0) {
            int curDigit = (number / len) % 10;
            if (node.children[curDigit] == null) break;
            else node = node.children[curDigit];
            len /= 10;
        }
        maxLevel = Math.max(maxLevel, node.level);
    }

    private int digits(int n) {
        int i = 1;
        while (i * 10 <= n) i *= 10;
        return i;
    }
}

class TrieNode {
    int level;
    TrieNode[] children;

    public TrieNode(int level) {
        this.level = level;
        this.children = new TrieNode[10];
    }
}