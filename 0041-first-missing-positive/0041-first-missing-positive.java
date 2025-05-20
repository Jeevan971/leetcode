public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Clean up the array, replace invalid numbers with n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // Step 2: Place each number x in the position x-1 if possible
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n) continue;

            // Mark presence by making the number at index num-1 negative
            if (nums[num - 1] > 0) {
                nums[num - 1] = -nums[num - 1];
            }
        }

        // Step 3: Find the first positive number index
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                // i+1 is missing
                return i + 1;
            }
        }

        // All numbers 1..n are present
        return n + 1;
    }

    // Testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.firstMissingPositive(new int[]{1,2,0}));         // Output: 3
        System.out.println(sol.firstMissingPositive(new int[]{3,4,-1,1}));      // Output: 2
        System.out.println(sol.firstMissingPositive(new int[]{7,8,9,11,12}));   // Output: 1
    }
}
