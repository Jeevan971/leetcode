public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Initialize first row and first column
        for (int i = 0; i <= m; i++) dp[i][0] = i; // deleting all characters of word1
        for (int j = 0; j <= n; j++) dp[0][j] = j; // inserting all characters of word2

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // same char, no new operation
                } else {
                    int insertOp = dp[i][j - 1] + 1;
                    int deleteOp = dp[i - 1][j] + 1;
                    int replaceOp = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(insertOp, Math.min(deleteOp, replaceOp));
                }
            }
        }

        return dp[m][n];
    }
}
