import java.util.*;

public class ProductOfNumbers {
    private List<Integer> prefixProducts;

    public ProductOfNumbers() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1); // Initial dummy product to help with division
    }

    public void add(int num) {
        if (num == 0) {
            // Reset on 0
            prefixProducts.clear();
            prefixProducts.add(1);
        } else {
            int lastProduct = prefixProducts.get(prefixProducts.size() - 1);
            prefixProducts.add(lastProduct * num);
        }
    }

    public int getProduct(int k) {
        int size = prefixProducts.size();
        if (k >= size) {
            // There was a zero within last k elements
            return 0;
        }
        int totalProduct = prefixProducts.get(size - 1);
        int beforeProduct = prefixProducts.get(size - k - 1);
        return totalProduct / beforeProduct;
    }
}
