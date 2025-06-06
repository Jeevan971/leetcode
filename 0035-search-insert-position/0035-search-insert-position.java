public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;  // Prevent overflow

            if (nums[mid] == target) {
                return mid;  // Found the target!
            } else if (nums[mid] < target) {
                left = mid + 1;  // Search right half
            } else {
                right = mid - 1;  // Search left half
            }
        }
        // If not found, left is the insertion position
        return left;
    }
}
