import java.util.Arrays;

public class XORSubarrayQueries {

    /**
     * For an array of positive integers and a list of queries, where each query defines the start and end indices,
     * return an array with the results of XOR operations performed from the starting element until the end element.
     * Example: arr = {1, 3, 4, 8}; queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}}; => {2, 7, 14, 8};
     * Explanation: query_1: 1 ^ 3 = 2
     *              query_2: 3 ^ 4 = 7
     *              query_3: 1 ^ 3 ^ 4 = 14
     *              query_4: 8 ^ 8 = 8 (per definition of this task)
     * Solution: XOR is i.a. associative, commutative and self-inverse (A ^ A = 0). One can imagine XOR'ing the
     *           same value B to A as toggling since (A ^ B) ^ B = A ^ (B ^ B) = A. Thus, we can create an
     *           array 'pre' with prefix XOR results. If a query doesn't start from the first element
     *           we can remove the preceding part by pre[start - 1] ^ pre[end].
     * **/

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] pre = new int[arr.length];
        pre[0] = arr[0];
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i - 1] ^ arr[i];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            int left = queries[i][0], right = queries[i][1];
            res[i] = left == 0 ? pre[right] : pre[right] ^ pre[left - 1];
        }
        return res;
    }

}
