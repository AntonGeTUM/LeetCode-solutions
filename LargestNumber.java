import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    /**
     * Given an array of integers, return the largest number you can form by concatenating the elements of the array.
     * Example: nums = {3,30,34,5,9} => "9534330"
     * Explanation: 9534330 is the largest possible number.
     * Solution: This one is more of mathematical riddle and requires knowing the following:
     *           if AB > BA and BC > CB => A before B
     *           Using this observation, we can sort a String array using a built-in function and concatenate
     *           the result.
     * **/

    public static String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (String a, String b) -> (b + a).compareTo(a + b));
        if (arr[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }

}
