public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0]; // Initialize with the first element
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Update currentSum to be either the current element itself
            // or the sum of currentSum and the current element
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update maxSum if currentSum is greater
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(); // Create an instance of Solution

        // Example 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Example 1 Output: " + solution.maxSubArray(nums1)); // Output: 6

        // Example 2
        int[] nums2 = {1};
        System.out.println("Example 2 Output: " + solution.maxSubArray(nums2)); // Output: 1

        // Example 3
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Example 3 Output: " + solution.maxSubArray(nums3)); // Output: 23
    }
}
