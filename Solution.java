public class Solution {
    class Solution {
        public static int[] twoSum(int[] nums, int target) {
            // Create a HashMap to store numbers and their indices
            Map<Integer, Integer> numToIndex = new HashMap<>();
            
            // Iterate through the array
            for (int i = 0; i < nums.length; i++) {
                // Calculate the complement
                int complement = target - nums[i];
                
                // Check if the complement exists in the HashMap
                if (numToIndex.containsKey(complement)) {
                    // If found, return the indices
                    return new int[] {numToIndex.get(complement), i};
                }
                
                // Otherwise, add the current number and its index to the HashMap
                numToIndex.put(nums[i], i);
            }
            
            // If no solution is found, throw an exception
            throw new IllegalArgumentException("No two sum solution");
        }
    
        public static void main(String[] args) {
            // Test cases
            int[] nums1 = {2, 7, 11, 15};
            int target1 = 9;
            int[] result1 = twoSum(nums1, target1);
            System.out.println("Result: [" + result1[0] + ", " + result1[1] + "]");
    
            int[] nums2 = {3, 2, 4};
            int target2 = 6;
            int[] result2 = twoSum(nums2, target2);
            System.out.println("Result: [" + result2[0] + ", " + result2[1] + "]");
    
            int[] nums3 = {3, 3};
            int target3 = 6;
            int[] result3 = twoSum(nums3, target3);
            System.out.println("Result: [" + result3[0] + ", " + result3[1] + "]");
        }
    }
    
}
