class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;

        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;

            while (left <= right) {
                // Swap and invert at the same time
                int tempLeft = image[i][left] ^ 1; // Invert
                int tempRight = image[i][right] ^ 1; // Invert

                image[i][left] = tempRight;
                image[i][right] = tempLeft;

                left++;
                right--;
            }
        }

        return image;
    }
}
