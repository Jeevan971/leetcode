public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;  // 1 step = 1 way, 2 steps = 2 ways
        }
        
        int oneStepBefore = 2;  // ways to get to step 2
        int twoStepsBefore = 1; // ways to get to step 1
        int allWays = 0;
        
        for (int i = 3; i <= n; i++) {
            allWays = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = allWays;
        }
        
        return allWays;
    }
}
