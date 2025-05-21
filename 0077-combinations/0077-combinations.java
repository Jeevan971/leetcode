import java.util.*;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), results);
        return results;
    }

    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> results) {
        if (current.size() == k) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(i + 1, n, k, current, results);
            current.remove(current.size() - 1); // backtrack
        }
    }
}
