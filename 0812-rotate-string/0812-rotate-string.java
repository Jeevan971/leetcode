public class Solution {
    public boolean rotateString(String s, String goal) {
        // Check length first to quickly eliminate mismatches
        if (s.length() != goal.length()) return false;

        // Concatenate s with itself
        String doubled = s + s;

        // If goal is a substring of doubled, it's a rotation
        return doubled.contains(goal);
    }
}
