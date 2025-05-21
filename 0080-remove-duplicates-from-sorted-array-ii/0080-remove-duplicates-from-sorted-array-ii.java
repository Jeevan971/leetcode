public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;  // no need to remove if size <= 2

        int index = 2; // start from 2 because first two are always allowed

        for (int i = 2; i < n; i++) {
            if (nums[i] != nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
