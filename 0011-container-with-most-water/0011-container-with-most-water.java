public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            int currentArea = h * width;
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointer from the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}
