public class MinimumBitflipsToConvertNumber {

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
