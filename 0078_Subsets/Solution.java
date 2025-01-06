import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Add the current subset to the result
        result.add(new ArrayList<>(current));

        // Generate all subsets that include nums[index] and beyond
        for (int i = index; i < nums.length; i++) {
            // Include nums[i] in the current subset
            current.add(nums[i]);
            // Recur with the next index
            generateSubsets(i + 1, nums, current, result);
            // Backtrack to explore other subsets
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {1, 2, 3};
        System.out.println("Input: nums = [1, 2, 3]");
        System.out.println("Output: " + solution.subsets(nums1));

        // Example 2
        int[] nums2 = {0};
        System.out.println("\nInput: nums = [0]");
        System.out.println("Output: " + solution.subsets(nums2));
    }
}
