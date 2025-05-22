import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;

        String key = s1 + " " + s2;
        if (memo.containsKey(key)) return memo.get(key);

        // Early pruning: if character counts differ, return false
        if (!hasSameCharCounts(s1, s2)) {
            memo.put(key, false);
            return false;
        }

        int n = s1.length();
        for (int i = 1; i < n; i++) {
            // No swap
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }

            // Swap
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                isScramble(s1.substring(i), s2.substring(0, n - i))) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    private boolean hasSameCharCounts(String s1, String s2) {
        int[] count = new int[26];
        for (char c : s1.toCharArray()) count[c - 'a']++;
        for (char c : s2.toCharArray()) count[c - 'a']--;
        for (int c : count) if (c != 0) return false;
        return true;
    }

    // Optional: test in main
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isScramble("great", "rgeat"));  // true
        System.out.println(sol.isScramble("abcde", "caebd"));  // false
        System.out.println(sol.isScramble("a", "a"));          // true
    }
}
