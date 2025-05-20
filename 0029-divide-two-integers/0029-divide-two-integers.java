public class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert both dividend and divisor to long to avoid overflow,
        // and take absolute values
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        int result = 0;

        while (lDividend >= lDivisor) {
            long temp = lDivisor, multiple = 1;

            // Increase the divisor by powers of two while it fits into the dividend
            while (lDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            lDividend -= temp;
            result += multiple;
        }

        return negative ? -result : result;
    }
}
