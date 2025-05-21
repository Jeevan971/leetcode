public class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // swap nums[low] and nums[mid], move both pointers forward
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++; // just move forward
            } else { // nums[mid] == 2
                // swap nums[mid] and nums[high], move high backward
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
                // do NOT move mid forward here because the swapped element from high needs to be checked
            }
        }
    }
}
