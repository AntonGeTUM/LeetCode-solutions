import java.util.ArrayList;
import java.util.List;

public class MaximumSwap {

    /**
     * Given an integer, you are allowed to swap two digits to create the largest possible number.
     * Example: num = 1993; => 9913
     * Explanation: You obtain the largest possible number by swapping the first and third digits
     * Solution: As a first intuition, no swap is necessary if all digits are in descending order. Thus, the
     *           objective is to bring the largest digit to the front to its optimal position. If there are multiple
     *           largest digit, we need to take the one furthest in the back.
     *           For example: 1993 => 9913 > 9193
     *           We start by creating buckets for each digit from 0 to 9, then iterate over the number and add
     *           the index of each digit into their corresponding bucket.
     *           For example:           0   1   2   3   4   5   6   7   8     9
     *                        1993 ->  [ ] [0] [ ] [3] [ ] [ ] [ ] [ ] [ ] [1, 2]
     *           We go backward over the buckets and skip empty ones. For each non-empty bucket, compare the stored
     *           indices with their optimal position. Perform a swap for the first index that doesn't match: Set the
     *           digit at the index to the bucket value and take the last index in the bucket as the new position
     *           for the smaller digit.
     * **/

    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        List<List<Integer>> digitIndices = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            digitIndices.add(new ArrayList<>());
        }
        for (int i = 0; i < chars.length; i++) {
            digitIndices.get(chars[i] - '0').add(i);
        }
        for (int i = 0, lstIdx = 9; i < chars.length;) {
            while(digitIndices.get(lstIdx).size() == 0) lstIdx--;
            List<Integer> curr = digitIndices.get(lstIdx);
            for (int j = 0; j < curr.size(); j++) {
                if (curr.get(j) != i) {
                    char tmp = chars[i];
                    chars[i] = (char) (lstIdx + 48);
                    chars[curr.get(curr.size() - 1)] = tmp;
                    return Integer.parseInt(String.valueOf(chars));
                }
                i++;
            }
            lstIdx--;
        }

        return Integer.parseInt(String.valueOf(chars));
    }
}
