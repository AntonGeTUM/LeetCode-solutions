public class LongestSubarrayWithMaxBitwiseAND {

    /**
     * For a given int array, return the length of the subarray with the maximum bitwise-AND result of all its elements.
     * In other words: Since AND can only maintain or reduce a value, the task is to find the longest subarray
     * of the maximum value in the array.
     * Example: array = {10, 10, 10, 8, 8, 8, 8, 12, 12, 12, 5, 5, 5, 12} => 3
     * Explanation: The biggest number in the array is 12, and as such, bitwise AND with other elements in the array
     *              will at most yield 12. The longest subarray containing only 12 is of length 3.
     * Solution: Iterate over the array to find the max. value. Afterward, count the length(s) of the subarray(s)
     *           to determine the longest subarray.
     **/

    public int longestSubarray(int[] nums) {
        int max = 0;
        int curLen = 0, maxLen = 1;
        ;
        for (int i : nums) {
            max = Math.max(i, max);
        }
        for (int i : nums) {
            if (i == max) {
                curLen++;
                maxLen = Math.max(curLen, maxLen);
            } else {
                curLen = 0;
            }
        }
        return maxLen;
    }

   // Alternative with one iteration over the array.
   /*
   public int longestSubarray(int[] nums) {
        int max = 0;
        int curLen = 1, maxLen = 1;;
        for (int i : nums) {
            if (i > max) {
                max = i;
                maxLen = 1;
                curLen = 1;
            } else if (i == max) {
                curLen++;
                maxLen = Math.max(maxLen, curLen);
            } else {
                curLen = 0;
            }
        }
        return maxLen;
    }
   */

}
