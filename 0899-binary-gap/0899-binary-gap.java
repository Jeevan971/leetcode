class Solution {
    public int binaryGap(int n) {
        int lastPosition = -1;
        int maxDistance = 0;
        int currentPosition = 0;

        while (n > 0) {
            if ((n & 1) == 1) { // Check if the last bit is 1
                if (lastPosition != -1) {
                    maxDistance = Math.max(maxDistance, currentPosition - lastPosition);
                }
                lastPosition = currentPosition;
            }
            n >>= 1; // Right shift to check next bit
            currentPosition++;
        }

        return maxDistance;
    }
}
