import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: sort to handle duplicates
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            // Step 2: skip duplicates on the same level
            if (i > start && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }

    // Optional main for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 2, 2};
        System.out.println(sol.subsetsWithDup(nums1));
        // Output: [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]

        int[] nums2 = {0};
        System.out.println(sol.subsetsWithDup(nums2));
        // Output: [[], [0]]
    }
}
