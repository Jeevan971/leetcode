public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: Find the first decreasing element from the right
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If such an element was found
        if (i >= 0) {
            int j = n - 1;

            // Step 3: Find the smallest element greater than nums[i] from the right
            while (nums[j] <= nums[i]) {
                j--;
            }

            // Step 4: Swap nums[i] and nums[j]
            swap(nums, i, j);
        }

        // Step 5: Reverse the subarray from i + 1 to the end
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
