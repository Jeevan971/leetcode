public class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] rowIncrements = new int[m];
        int[] colIncrements = new int[n];

        for (int[] index : indices) {
            int r = index[0];
            int c = index[1];
            rowIncrements[r]++;
            colIncrements[c]++;
        }

        int oddRowCount = 0;
        for (int rInc : rowIncrements) {
            if (rInc % 2 == 1) oddRowCount++;
        }
        int evenRowCount = m - oddRowCount;

        int oddColCount = 0;
        for (int cInc : colIncrements) {
            if (cInc % 2 == 1) oddColCount++;
        }
        int evenColCount = n - oddColCount;
        return oddRowCount * evenColCount + evenRowCount * oddColCount;
    }
}
