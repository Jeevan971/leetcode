import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, 
                           List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            // Found a valid combination
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            // Exceeded the sum, no need to continue
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Choose the candidate
            current.add(candidates[i]);

            // Since candidates can be reused, pass 'i' again, not i+1
            backtrack(candidates, target - candidates[i], i, current, result);

            // Undo the choice (backtrack)
            current.remove(current.size() - 1);
        }
    }

    // Example testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.combinationSum(new int[]{2,3,6,7}, 7)); 
        // Output: [[2, 2, 3], [7]]

        System.out.println(sol.combinationSum(new int[]{2,3,5}, 8)); 
        // Output: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]

        System.out.println(sol.combinationSum(new int[]{2}, 1)); 
        // Output: []
    }
}
