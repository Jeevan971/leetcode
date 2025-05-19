public class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int index = 0, n = s.length();
        
        // 1. Skip leading whitespaces
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        
        // If we've reached end after spaces, no number found
        if (index == n) return 0;
        
        // 2. Check sign
        int sign = 1;
        char firstChar = s.charAt(index);
        if (firstChar == '+') {
            sign = 1;
            index++;
        } else if (firstChar == '-') {
            sign = -1;
            index++;
        }
        
        // 3. Convert digits into number
        int result = 0;
        while (index < n) {
            char c = s.charAt(index);
            
            if (c < '0' || c > '9') {
                // Stop reading digits at first non-digit
                break;
            }
            
            int digit = c - '0';
            
            // 4. Check for overflow before multiplying by 10
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                // Overflow: return max or min int depending on sign
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            index++;
        }
        
        return sign * result;
    }
}
