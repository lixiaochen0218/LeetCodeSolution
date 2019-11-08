public class LeetCode029 {
    public int divide(int dividend, int divisor) {
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        long res = 0;
        while (longDividend >= longDivisor) {
            long mutiple = 1;
            long temp = divisor;
            while (longDividend >= (temp << 1)) {
                temp <<= 1; // temp *= 2;
                mutiple <<= 1; // mutiple *= 2;
            }
            res += mutiple;
            longDividend -= temp;
        }

        res *= sign;
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) res;
        }
    }
}
