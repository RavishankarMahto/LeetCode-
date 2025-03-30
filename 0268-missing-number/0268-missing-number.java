public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
      
        int totalSum = n * (n + 1) / 2;
        int arraySum = 0;

        for (int num : nums) {
            arraySum += num;
        }

        return totalSum - arraySum;
    }

    public static void main(String[] args) {
        
        int[] nums1 = {3, 0, 1};
        Solution solution = new Solution();
        System.out.println("Missing number: " + solution.missingNumber(nums1));

        int[] nums2 = {0, 1};
        System.out.println("Missing number: " + solution.missingNumber(nums2));

        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("Missing number: " + solution.missingNumber(nums3));
    }
}
