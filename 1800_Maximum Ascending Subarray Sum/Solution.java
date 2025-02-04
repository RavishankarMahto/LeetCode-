public class MaxAscendingSubarraySum {
    public static int maxAscendingSum(int[] nums) {
        int maxSum = nums[0]; // Initialize maxSum with the first element
        int currentSum = nums[0]; // Start tracking the sum of the current ascending subarray
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                // Continue the ascending subarray
                currentSum += nums[i];
            } else {
                // Reset for a new ascending subarray
                currentSum = nums[i];
            }
            
            // Update maxSum if the currentSum is greater
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {10, 20, 30, 5, 10, 50};
        System.out.println(maxAscendingSum(nums1)); // Output: 65
        
        int[] nums2 = {10, 20, 30, 40, 50};
        System.out.println(maxAscendingSum(nums2)); // Output: 150
        
        int[] nums3 = {12, 17, 15, 13, 10, 11, 12};
        System.out.println(maxAscendingSum(nums3)); // Output: 33
    }
}

class Solution {
    public int maxAscendingSum(int[] nums) {
        return MaxAscendingSubarraySum.maxAscendingSum(nums);
    }
}
