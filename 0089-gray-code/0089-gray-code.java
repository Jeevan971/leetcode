import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int total = 1 << n; // 2^n numbers in the sequence

        for (int i = 0; i < total; i++) {
            result.add(i ^ (i >> 1));
        }

        return result;
    }

    // Optional test case
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 2;
        List<Integer> gray = sol.grayCode(n);
        System.out.println(gray); // Example output: [0, 1, 3, 2]
    }
}
