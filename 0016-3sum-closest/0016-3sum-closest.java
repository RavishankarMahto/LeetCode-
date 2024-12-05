class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array
        int n = nums.length;
        int closestSum = Integer.MAX_VALUE / 2; // Initialize to a very large number
        
        for (int i = 0; i < n - 2; i++) { // Fix the first number
            int left = i + 1, right = n - 1; // Two-pointer setup
            
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // Update closest sum if the current sum is closer to the target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                
                // Move the pointers based on comparison with target
                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    // Exact match found
                    return currentSum;
                }
            }
        }
        
        return closestSum;
    }
}