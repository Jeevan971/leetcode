public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();  // Remove trailing and leading spaces
        int lastSpaceIndex = s.lastIndexOf(' ');
        return s.length() - lastSpaceIndex - 1;
    }
}
