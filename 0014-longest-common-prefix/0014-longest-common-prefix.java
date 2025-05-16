public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Start with the first string as the prefix
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // While current string doesn't start with the prefix, trim the prefix
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    // Optional main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));  // Output: "fl"
        System.out.println(sol.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));     // Output: ""
        System.out.println(sol.longestCommonPrefix(new String[]{"interview", "interrupt", "internal", "internet"})); // Output: "int"
    }
}
