public class Solution {
    private Boolean[][] memo;
    
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dp(s, p, 0, 0);
    }
    
    private boolean dp(String s, String p, int i, int j) {
        // If we've reached the end of the pattern
        if (j == p.length()) {
            // Match only if also at end of string
            return i == s.length();
        }
        
        // If already computed, return cached result
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        // Check if first character matches (account for string end)
        boolean firstMatch = (i < s.length() && 
                             (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));
        
        boolean result;
        
        // Check if next char in pattern is '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // Two options:
            // 1. Skip this part "x*" pattern (0 occurrences)
            // 2. If firstMatch, consume one char from s and continue with same pattern
            result = dp(s, p, i, j + 2) || (firstMatch && dp(s, p, i + 1, j));
        } else {
            // No '*', just move forward if first char matches
            result = firstMatch && dp(s, p, i + 1, j + 1);
        }
        
        // Cache result
        memo[i][j] = result;
        return result;
    }
}
