public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;      // Pointer for last element in nums1's initial part
        int j = n - 1;      // Pointer for last element in nums2
        int k = m + n - 1;  // Pointer for last element in nums1 (full length)
        
        // Merge from the back
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        
        // If nums2 still has elements, copy them
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
        
        // No need to copy remaining nums1 elements since they are already in place
    }
}
