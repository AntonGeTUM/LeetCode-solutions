import java.util.Arrays;
import java.util.List;

public class MinTimeDifference {

    /**
     * For a given array of times in the 24-hour format, return the minimum difference between any two
     * time points in minutes.
     * Example: timePoints = ("00:00","12:34","23:59","03:21","16:45","07:30","20:15","22:22") => 1
     * Explanation: The minimum difference of 1 minute lies between "00:00" and "23:59".
     * Solution: Convert all times into minutes and mark their occurrences in an array. If any time point appears
     *           more than once, we can immediately return 0. We determine the differences between all adjacent
     *           time points and between the first and last time points (circular, from last to first).
     *           e.g. from 23:59 to 00:20 take 21 minutes
     * **/

    public int findMinDifference(List<String> timePoints) {
        int[] array = new int[1440];
        int earliest = Integer.MAX_VALUE, latest = -1;
        for (String time : timePoints) {
            int index = Integer.parseInt(time.substring(3, 5)) + Integer.parseInt(time.substring(0, 2)) * 60;
            array[index]++;
            if (array[index] > 1) return 0;
            earliest = Math.min(earliest, index);
            latest = Math.max(latest, index);
        }
        int res = 1440 - latest + earliest;
        int i = earliest, j = i + 1;
        while (j <= latest) {
            while (array[j] == 0) j++;
            res = Math.min(j - i, res);
            i = j++;
        }
        return res;
    }

}
