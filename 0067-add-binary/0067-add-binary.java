public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Iterate while there are bits left or carry is not zero
        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;

            if (i >= 0) sum += a.charAt(i--) - '0';  // Convert char to int
            if (j >= 0) sum += b.charAt(j--) - '0';

            carry = sum >> 1; // carry is 1 if sum >= 2
            sum = sum & 1;    // current bit (0 or 1)

            result.append(sum);
        }

        // The result is built backward, reverse it
        return result.reverse().toString();
    }
}
