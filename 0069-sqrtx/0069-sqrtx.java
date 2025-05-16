public class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;  // sqrt(0) = 0, sqrt(1) = 1
        }
        
        int left = 1, right = x / 2;
        int ans = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Use long to prevent integer overflow when squaring mid
            long square = (long) mid * mid;
            
            if (square == x) {
                return mid;  // perfect square found
            } else if (square < x) {
                ans = mid;  // mid might be the floor of sqrt(x)
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }
}
