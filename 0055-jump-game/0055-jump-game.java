public class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0;  // furthest index we can currently reach

        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) {
                return false; // If we ever reach a point we can't jump to
            }
            reachable = Math.max(reachable, i + nums[i]);
        }

        return true;
    }
}
