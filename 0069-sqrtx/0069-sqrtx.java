public class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x; // The square root of 0 is 0, and the square root of 1 is 1.
        }

        // Initialize the binary search bounds
        int left = 1, right = x, result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid * mid is less than or equal to x
            if (mid <= x / mid) {
                result = mid; // Update result as mid might be the answer
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return result;
    }
}
