import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int index = 0;

        while (index < n) {
            int totalChars = words[index].length();
            int last = index + 1;

            // Find the range of words to fit on the current line
            while (last < n) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }

            int gaps = last - index - 1;
            StringBuilder line = new StringBuilder();

            // If last line or line with single word - left justify
            if (last == n || gaps == 0) {
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i != last - 1) line.append(" ");
                }
                // pad remaining spaces at the end
                int remaining = maxWidth - line.length();
                for (int i = 0; i < remaining; i++) line.append(" ");
            } else {
                // middle justified line
                int totalSpaces = maxWidth - totalChars + gaps; // total spaces to distribute
                int spaceBetween = totalSpaces / gaps; // spaces per gap
                int extraSpaces = totalSpaces % gaps;  // leftover spaces to add to left gaps

                for (int i = index; i < last - 1; i++) {
                    line.append(words[i]);
                    for (int s = 0; s < spaceBetween; s++) line.append(" ");
                    if (extraSpaces > 0) {
                        line.append(" ");
                        extraSpaces--;
                    }
                }
                line.append(words[last - 1]); // last word in line
            }
            result.add(line.toString());
            index = last;
        }

        return result;
    }
}
