import java.util.HashSet;

public class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> types = new HashSet<>();

        for (int candy : candyType) {
            types.add(candy);
        }

        int maxCandies = candyType.length / 2;
        return Math.min(types.size(), maxCandies);
    }
}
