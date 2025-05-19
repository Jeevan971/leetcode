public class Solution {
    public int reverse(int x) {
        int reversed = 0;
        
        while (x != 0) {
            int pop = x % 10; // get last digit
            x /= 10;          // drop last digit
            
            // Check for overflow:
            // If reversed is > Integer.MAX_VALUE/10, then multiplying by 10 will overflow.
            // If reversed == Integer.MAX_VALUE/10, check if pop > 7 (max last digit for int)
            if (reversed > Integer.MAX_VALUE / 10 || 
               (reversed == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            // Similarly for negative overflow
            if (reversed < Integer.MIN_VALUE / 10 || 
               (reversed == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            
            reversed = reversed * 10 + pop;
        }
        
        return reversed;
    }
}
