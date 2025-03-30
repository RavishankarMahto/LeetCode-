public class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // Pointer to track the next position for valid elements

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // Place the valid element at index `k`
                k++;               // Increment the pointer for the next position
            }
        }

        return k; // Return the count of valid elements
    }
}
