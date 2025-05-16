public class Solution {
    public static int diagonalSum(int[][] mat) {  // ← static added here
        int n = mat.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += mat[i][i];              // Primary diagonal
            sum += mat[i][n - 1 - i];      // Secondary diagonal
        }

        if (n % 2 == 1) {
            sum -= mat[n / 2][n / 2];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] mat1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Diagonal sum = " + diagonalSum(mat1)); // Output: 25

        int[][] mat2 = {
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1}
        };
        System.out.println("Diagonal sum = " + diagonalSum(mat2)); // Output: 8

        int[][] mat3 = {
            {5}
        };
        System.out.println("Diagonal sum = " + diagonalSum(mat3)); // Output: 5
    }
}
