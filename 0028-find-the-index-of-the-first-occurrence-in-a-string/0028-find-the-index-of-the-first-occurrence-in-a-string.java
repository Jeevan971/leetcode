public class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();

        if (nLen == 0) return 0;  // empty needle always found at 0

        for (int i = 0; i <= hLen - nLen; i++) {
            int j;
            for (j = 0; j < nLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;  // mismatch found, break inner loop
                }
            }
            if (j == nLen) {  // full match found
                return i;
            }
        }

        return -1;  // no match found
    }
}
