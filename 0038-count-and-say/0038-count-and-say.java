public class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String result = "1";
        for (int i = 2; i <= n; i++) {
            result = runLengthEncode(result);
        }
        return result;
    }

    private String runLengthEncode(String s) {
        StringBuilder sb = new StringBuilder();

        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count).append(s.charAt(i - 1));
                count = 1;
            }
        }
        // Append last run
        sb.append(count).append(s.charAt(s.length() - 1));

        return sb.toString();
    }

    // For testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countAndSay(4)); // Output: 1211
        System.out.println(sol.countAndSay(1)); // Output: 1
    }
}
