public class Solution {
    public int lengthOfLastWord(String s) {
        // Trim the string to remove trailing spaces
        s = s.trim();
        
        // Split the string by spaces
        String[] words = s.split(" ");
        
        // The last word is at the last index
        String lastWord = words[words.length - 1];
        
        // Return the length of the last word
        return lastWord.length();
    }
}
