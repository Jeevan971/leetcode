public class Solution {
    public String convert(String s, int numRows) {
        // Edge case: if only one row, return the original string
        if (numRows == 1) return s;
        
        // StringBuilder array to hold strings for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        int currentRow = 0;
        boolean goingDown = false; // direction flag
        
        // Iterate over each character in the string
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            
            // Change direction when top or bottom is reached
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            
            currentRow += goingDown ? 1 : -1;
        }
        
        // Concatenate all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        
        return result.toString();
    }
}
