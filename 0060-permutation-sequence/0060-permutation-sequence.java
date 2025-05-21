import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        
        k--;
        
        StringBuilder result = new StringBuilder();
        
        for (int i = n; i >= 1; i--) {
            int index = k / factorial[i - 1];
            k = k % factorial[i - 1];
            result.append(numbers.get(index));
            numbers.remove(index);
        }
        
        return result.toString();
    }
}
