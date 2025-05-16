public class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;  // position for the next non-val element
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];  // move non-val element forward
                k++;
            }
        }
        
        return k;  // number of elements not equal to val
    }
}
