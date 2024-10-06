public class SentenceSimilarIII {

    /**
     * You are given two Strings sentence1 and sentence2 which consist of words and white spaces. Both Strings are
     * similar if you can insert a single sentence into the shorter String and the Strings become identical.
     * You can only add whole words, i.e. no single characters to complete a word.
     * Example 1: sentence1 = "My name is Haley", sentence2 = "My Haley" => true
     * Explanation 1: sentence2 becomes identical to sentence1 when inserting "name is ".
     * Example 2: sentence1 = "of", sentence2 = "A lot of words" => false
     * Explanation 2: You would need two sentences for sentence1 to receive the same string as sentence2.
     * Solution: There are only three scenarios in which the method should return true:
     *              1. The entire shorter String is a prefix of the longer String.
     *              2. The entire shorter String is a suffix of the longer String.
     *              3. The shorter String needs to be split into two parts and the sentence is inserted in between.
     *           Therefore, we determine the matching prefix and suffix of both sentences, i.e. the matching words
     *           starting from either end of the sentences. If prefix + suffix == shorter sentence return true.
     *           
     *           Alternatively, you can use two Deques and remove all matching words from both ends. If one Deque
     *           ends up empty both sentences are similar.
     * **/

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2)) return true;
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        String[] longer, shorter;
        if (s1.length > s2.length) {
            longer = s1;
            shorter = s2;
        } else {
            longer = s2;
            shorter = s1;
        }
        int len = shorter.length;
        int indexPre = 0;
        while (indexPre < len && s1[indexPre].equals(s2[indexPre])) {
            indexPre++;
        }
        if (indexPre == len) return true;
        int dif = longer.length - shorter.length;
        int indexSuf = len - 1;
        while (indexSuf >= indexPre && longer[indexSuf + dif].equals(shorter[indexSuf])) {
            indexSuf--;
        }
        return indexSuf == -1 || indexPre + (len - 1 - indexSuf) == len;
    }
}
