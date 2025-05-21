import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Step 1: Sort by starting times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (current[1] >= next[0]) {
                // Overlapping intervals, merge them
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap, add the previous interval and move on
                merged.add(current);
                current = next;
            }
        }

        // Don't forget the last interval
        merged.add(current);

        return merged.toArray(new int[merged.size()][]);
    }
}
