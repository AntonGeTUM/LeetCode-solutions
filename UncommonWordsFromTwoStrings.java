import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsFromTwoStrings {

    /**
     * Given two strings consisting of lower case letters and separated by a single-space, return an array of words
     * that only appear once in total.
     * Example: s1 = "this apple is sweet", s2 = "this apple is sour" => {"sweet", "sour"}
     * Explanation: "sweet" and "sour" appear once in total
     * Solution: Count the number of occurrences of each word using a Map and return an array containing
     *           all the words that have a count of 1.
     * **/

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        String[] string1 = s1.split(" ");
        for (String s : string1) {
            int count = map.getOrDefault(s, 0) + 1;
            map.put(s, count);
        }
        String[] string2 = s2.split(" ");
        for (String s : string2) {
            int count = map.getOrDefault(s, 0) + 1;
            map.put(s, count);
        }
        int size = 0;
        for (int i : map.values()) {
            if (i == 1) size++;
        }
        String[] res = new String[size];
        int index = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) res[index++] = entry.getKey();
        }
        return res;
    }
}
