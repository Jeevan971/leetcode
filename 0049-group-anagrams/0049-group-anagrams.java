import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map where key = sorted word, value = list of anagrams
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Convert to char array, sort it, then turn it back to a string
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Add the original string to the map
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        // Return the list of grouped anagrams
        return new ArrayList<>(map.values());
    }

    // Sample test
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = sol.groupAnagrams(strs);

        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
