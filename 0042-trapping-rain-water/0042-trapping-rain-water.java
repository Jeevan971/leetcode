public class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int trapped = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    trapped += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    trapped += maxRight - height[right];
                }
                right--;
            }
        }

        return trapped;
    }

    // Testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})); // Output: 6
        System.out.println(sol.trap(new int[]{4,2,0,3,2,5}));             // Output: 9
    }
}
