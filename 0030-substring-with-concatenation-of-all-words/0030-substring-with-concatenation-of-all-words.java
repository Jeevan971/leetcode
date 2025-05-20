import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;

        // Map to store the frequency of each word
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        // Loop through s with wordLength steps to handle overlapping
        for (int i = 0; i < wordLength; i++) {
            int left = i, count = 0;
            Map<String, Integer> window = new HashMap<>();

            for (int right = i; right + wordLength <= s.length(); right += wordLength) {
                String word = s.substring(right, right + wordLength);

                if (wordFreq.containsKey(word)) {
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;

                    // If a word appears more than expected, slide the window
                    while (window.get(word) > wordFreq.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLength;
                        count--;
                    }

                    // If all words matched
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // Reset if word not in target list
                    window.clear();
                    count = 0;
                    left = right + wordLength;
                }
            }
        }

        return result;
    }
}
