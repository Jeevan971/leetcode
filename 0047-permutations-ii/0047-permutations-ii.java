import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to detect duplicates
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip used elements
            if (used[i]) continue;

            // Skip duplicates: if current value equals previous, and the previous wasn't used in this path
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            // Choose
            used[i] = true;
            current.add(nums[i]);

            // Explore
            backtrack(nums, current, used, result);

            // Un-choose
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }

    // Sample test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = sol.permuteUnique(nums);
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }
}
