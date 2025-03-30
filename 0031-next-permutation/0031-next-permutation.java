class Solution {
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Swap the two elements
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 2, 3};
        nextPermutation(nums1);
        System.out.println("Next permutation: " + Arrays.toString(nums1));

        // Example 2
        int[] nums2 = {3, 2, 1};
        nextPermutation(nums2);
        System.out.println("Next permutation: " + Arrays.toString(nums2));

        // Example 3
        int[] nums3 = {1, 1, 5};
        nextPermutation(nums3);
        System.out.println("Next permutation: " + Arrays.toString(nums3));
    }
}