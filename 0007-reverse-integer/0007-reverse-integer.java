public class Solution {
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int digit = x % 10; // Get the last digit
            x /= 10; // Remove the last digit

            // Check for overflow or underflow before updating the result
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0; // Overflow
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0; // Underflow
            }

            result = result * 10 + digit;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(123));   // Output: 321
        System.out.println(solution.reverse(-123));  // Output: -321
        System.out.println(solution.reverse(120));   // Output: 21
        System.out.println(solution.reverse(0));     // Output: 0
    }
}
