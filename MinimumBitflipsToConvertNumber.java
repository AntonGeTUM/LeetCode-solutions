public class MinimumBitflipsToConvertNumber {

    /**
     * Given two integers, return the number of required bit flips to turn the binary representation of
     * int 'start' into 'goal'.
     * Example: start = 10 -> 1010, goal = 7 -> 0111 => 3 bit flips required
     * Explanation: 1010
     *              0111
     *              -> both binary numbers differ in 3 bits
     * Solution: Determine the Hamming distance between both numbers using XOR and counting the 1's.
     *           e.g. 1010 ^ 0111 = 1101 -> three 1's
     * **/

    public int minBitFlips(int start, int goal) {
        int dif = start ^ goal;
        int res = 0;
        while (dif > 0) {
            res += dif & 0x1;
            dif >>>= 1;
        }
        return res;
    }
}
