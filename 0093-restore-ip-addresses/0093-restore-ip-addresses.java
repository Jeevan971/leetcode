import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, "", result);
        return result;
    }

    private void backtrack(String s, int index, int dots, String currentIP, List<String> result) {
        if (dots == 4 && index == s.length()) {
            result.add(currentIP.substring(0, currentIP.length() - 1)); // remove last '.'
            return;
        }

        if (dots > 4) return;

        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) break;
            String segment = s.substring(index, index + len);
            if (isValid(segment)) {
                backtrack(s, index + len, dots + 1, currentIP + segment + ".", result);
            }
        }
    }

    private boolean isValid(String segment) {
        if (segment.length() > 1 && segment.startsWith("0")) return false;
        int val = Integer.parseInt(segment);
        return val >= 0 && val <= 255;
    }

    // Optional main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.restoreIpAddresses("25525511135"));
        // Output: [255.255.11.135, 255.255.111.35]

        System.out.println(sol.restoreIpAddresses("0000"));
        // Output: [0.0.0.0]

        System.out.println(sol.restoreIpAddresses("101023"));
        // Output: [1.0.10.23, 1.0.102.3, 10.1.0.23, 10.10.2.3, 101.0.2.3]
    }
}
