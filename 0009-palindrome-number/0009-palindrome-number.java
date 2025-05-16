public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;  // Negative numbers are never palindromes
        String s = Integer.toString(x);
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
