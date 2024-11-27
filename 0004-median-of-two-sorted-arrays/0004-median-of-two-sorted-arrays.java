class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int low = 0, high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            // Handle edge cases
            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxX <= minY && maxY <= minX) {
                // Found the correct partition
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxX, maxY) + Math.min(minX, minY)) / 2;
                } else {
                    return (double)Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                high = partitionX - 1; // Move left in nums1
            } else {
                low = partitionX + 1; // Move right in nums1
            }
        }

        // Should never reach here if inputs are valid
        throw new IllegalArgumentException("Input arrays are not sorted or valid.");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2)); // Output: 2.0

        // Test case 2
        int[] nums1b = {1, 2};
        int[] nums2b = {3, 4};
        System.out.println(solution.findMedianSortedArrays(nums1b, nums2b)); // Output: 2.5

        // Test case 3
        int[] nums1c = {};
        int[] nums2c = {1};
        System.out.println(solution.findMedianSortedArrays(nums1c, nums2c)); // Output: 1.0

        // Test case 4
        int[] nums1d = {0, 0};
        int[] nums2d = {0, 0};
        System.out.println(solution.findMedianSortedArrays(nums1d, nums2d)); // Output: 0.0
    }
}