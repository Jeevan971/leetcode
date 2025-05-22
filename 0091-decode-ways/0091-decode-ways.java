public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;

        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1; // Base case: empty string has one way to decode
        dp[1] = s.charAt(0) != '0' ? 1 : 0; // First char can't be '0'

        for (int i = 2; i <= n; i++) {
            // Single digit decode (must not be '0')
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // Two digit decode (must be 10 to 26)
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    // Optional test
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.numDecodings("12"));     // 2 -> "AB", "L"
        System.out.println(sol.numDecodings("226"));    // 3 -> "BZ", "VF", "BBF"
        System.out.println(sol.numDecodings("06"));     // 0 -> Invalid
        System.out.println(sol.numDecodings("11106"));  // 2 -> "AAJF", "KJF"
    }
}
