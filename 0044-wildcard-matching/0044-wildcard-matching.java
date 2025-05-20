public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp[i][j] means: first i chars of s matches first j chars of p
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty string matches empty pattern
        dp[0][0] = true;

        // Handle patterns like '*', '**', '***' at the beginning
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 1];
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '?' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // '*' matches empty (dp[i][j-1]) or any character (dp[i-1][j])
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }

    // Sample main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.isMatch("aa", "a"));   // false
        System.out.println(sol.isMatch("aa", "*"));   // true
        System.out.println(sol.isMatch("cb", "?a"));  // false
        System.out.println(sol.isMatch("adceb", "*a*b")); // true
        System.out.println(sol.isMatch("acdcb", "a*c?b")); // false
    }
}
