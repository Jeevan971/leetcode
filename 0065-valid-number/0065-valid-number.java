public class Solution {
    public boolean isNumber(String s) {
        String pattern = "^[+-]?((\\d+\\.?\\d*)|(\\.\\d+))([eE][+-]?\\d+)?$";
        return s.matches(pattern);
    }
}
