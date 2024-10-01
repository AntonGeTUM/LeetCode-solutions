public class ArrayDivisibleByK {

    /**
     * Given an array of even length n and an integer k, return true if the array can be divided into exactly
     * n / 2 pairs where the sum of each pair is divisible by k.
     * The values in the array are in the range of [-10e9, 10e9] and for k it is [1, 10e5]
     * Example: arr = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, k = 5 => true
     * Explanation: You can form the following pairs: (1, 9), (2, 8), (3, 7), (4, 6) and (5, 10).
     * Solution: Today's task is more of a mathematical nature. The first intuitions might be that the sum of all
     *           values or the sum of (arr[i] % k) needs to be divisible by k. However, this does not work due to
     *           negative numbers and/or groups of size != 2 that fulfill the conditions above.
     *           Instead, we need to make use of a property of modulus tables or algebraic groups. For instance,
     *           for k = 5 the elements are [0, 1, 2, 3, 4], or for k = 8 [0, 1, 2, 3, 4, 5, 6, 7].
     *           You will notice, that you can form pairs divisible by k if for i in the range [1, k - 1] one number
     *           is i and the other (k - i). Thus, we can count how often each (arr[i] % k) occurs
     *           (or ((arr[i] % k) + k) if arr[i] is negative) and check whether the frequencies of i and (k - i) match.
     *           The only edge case is (arr[i] % k == 0). Here we need to make sure that the count is even.
     * **/

    public boolean canArrange(int[] arr, int k) {
        int[] count = new int[k];
        for (int i : arr) {
            int idx = i % k;
            if (idx < 0) idx += k;
            count[idx]++;
        }
        if ((count[0] & 0x1) == 1) return false;
        for (int i = 1; i <= k / 2; i++) {
            if (count[i] != count[k - i]) return false;
        }
        return true;
    }
}
