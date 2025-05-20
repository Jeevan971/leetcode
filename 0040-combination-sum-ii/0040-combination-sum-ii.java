import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);  // Sort to handle duplicates
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            // Found valid combination
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            // Exceeded sum, prune branch
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates: if current candidate equals previous candidate, skip it
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            current.add(candidates[i]);
            // Move to next index since each number can only be used once
            backtrack(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1);  // Backtrack
        }
    }

    // Test examples
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        // Output: [[1,1,6], [1,2,5], [1,7], [2,6]]

        System.out.println(sol.combinationSum2(new int[]{2,5,2,1,2}, 5));
        // Output: [[1,2,2], [5]]
    }
}
