import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LongestHappyString {

    /**
     * A 'happy' String is defined as a String consisting of 'a', 'b' and 'c', with at most 2 consecutive
     * occurrences of the same letter, and the total number for each letter is limited by a corresponding integer.
     * Given the integers a, b, and c, return the longest possible happy String.
     * Example: a = 1, b = 1, c = 7 => ccaccbcc
     * Explanation: ccaccbcc and ccbccacc are the longest possible happy Strings.
     * Solution: When writing down some examples by hand we notice that we only need to distinguish between the most
     *           frequent letter and the other two. We use a greedy approach in which we distribute as many of
     *           the most frequent letter as possible and interleave those with either of the two less frequent
     *           ones. To get the longest possible String, we need to save on the less frequent letters. Therefore,
     *           we place one letter at a time while the count of the most frequent letter is higher than the
     *           second most frequent letter.
     * **/

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        queue.offer(new int[] {a, 97});
        queue.offer(new int[] {b, 98});
        queue.offer(new int[] {c, 99});

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int[] mostFrequent = queue.poll();
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == mostFrequent[1]) break;
            int toAdd = Math.min(mostFrequent[0], 2);
            for (int i = 0; i < toAdd; i++) {
                sb.append((char) mostFrequent[1]);
                mostFrequent[0]--;
            }
            if (queue.isEmpty()) break;
            int[] second = queue.poll();
            if (mostFrequent[0] > second[0]) {
                toAdd = Math.min(1, second[0]);
            } else {
                toAdd = Math.min(2, second[0]);
            }
            for (int i = 0; i < toAdd; i++) {
                sb.append((char) second[1]);
                second[0]--;
            }
            if (mostFrequent[0] > 0) queue.offer(mostFrequent);
            if (second[0] > 0) queue.offer(second);
        }

        return sb.toString();
    }

}
