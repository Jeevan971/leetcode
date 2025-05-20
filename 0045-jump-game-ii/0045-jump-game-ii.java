public class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;   // End of the range we can reach with current number of jumps
        int farthest = 0;     // Farthest we can reach in the next jump

        for (int i = 0; i < nums.length - 1; i++) {
            // Continuously find how far we can reach in this jump
            farthest = Math.max(farthest, i + nums[i]);

            // If we have come to the end of the current jump range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // Optional sanity check (not needed per constraints):
                if (currentEnd >= nums.length - 1) break;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.jump(new int[]{2,3,1,1,4})); // Output: 2
        System.out.println(sol.jump(new int[]{2,3,0,1,4})); // Output: 2
    }
}
