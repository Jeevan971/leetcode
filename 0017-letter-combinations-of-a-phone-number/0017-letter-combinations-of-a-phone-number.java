import java.util.*;

public class Solution {
    private static final Map<Character, String> PHONE_MAP = Map.of(
        '2', "abc", '3', "def",
        '4', "ghi", '5', "jkl", '6', "mno",
        '7', "pqrs", '8', "tuv", '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        backtrack(result, digits, 0, new StringBuilder());
        return result;
    }

    private void backtrack(List<String> result, String digits, int index, StringBuilder current) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = PHONE_MAP.get(digits.charAt(index));
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(result, digits, index + 1, current);
            current.deleteCharAt(current.length() - 1);  // backtrack
        }
    }
}
