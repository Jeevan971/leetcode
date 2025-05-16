public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse from the end to the front
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;  // No carry needed, done here
            }
            // If digit is 9, it becomes 0 and carry continues
            digits[i] = 0;
        }

        // If we're here, all digits were 9 and we have an overflow:
        // e.g., 999 + 1 = 1000
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;  // First digit is 1, rest are 0 by default
        return newNumber;
    }
}
