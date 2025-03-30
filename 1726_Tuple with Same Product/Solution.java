import java.util.HashMap;
import java.util.Map;

public class ProductTuples {

    // Method that calculates the number of valid tuples
    public static int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productCount = new HashMap<>();
        int n = nums.length;
        
        // Loop over all distinct pairs (i, j) where i < j.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }
        
        int result = 0;
        // For each product with k pairs, we can form C(k, 2) combinations.
        // Each combination contributes 8 valid tuples.
        for (int count : productCount.values()) {
            if (count > 1) {
                result += 8 * (count * (count - 1) / 2);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Example 1:
        int[] nums1 = {2, 3, 4, 6};
        System.out.println("Output for [2, 3, 4, 6]: " + tupleSameProduct(nums1)); // Expected: 8
        
        // Example 2:
        int[] nums2 = {1, 2, 4, 5, 10};
        System.out.println("Output for [1, 2, 4, 5, 10]: " + tupleSameProduct(nums2)); // Expected: 16
    }
}

// The Solution class as expected by your driver code.
class Solution {
    public int tupleSameProduct(int[] nums) {
        return ProductTuples.tupleSameProduct(nums);
    }
}
