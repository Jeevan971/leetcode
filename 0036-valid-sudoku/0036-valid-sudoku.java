import java.util.HashSet;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> box = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                // Check row
                if (board[i][j] != '.') {
                    if (!row.add(board[i][j])) return false;
                }

                // Check column
                if (board[j][i] != '.') {
                    if (!col.add(board[j][i])) return false;
                }

                // Check 3x3 box
                int rowIndex = 3 * (i / 3) + j / 3;
                int colIndex = 3 * (i % 3) + j % 3;
                if (board[rowIndex][colIndex] != '.') {
                    if (!box.add(board[rowIndex][colIndex])) return false;
                }
            }
        }
        return true;
    }
}
