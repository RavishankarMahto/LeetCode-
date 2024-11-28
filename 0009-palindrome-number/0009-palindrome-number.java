class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers and numbers ending in 0 (but not 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        int original = x;

        // Reverse the number
        while (x > 0) {
            int digit = x % 10;       // Get the last digit
            reversed = reversed * 10 + digit; // Add it to the reversed number
            x = x / 10;              // Remove the last digit
        }

        // Check if the original number equals the reversed number
        return original == reversed;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.isPalindrome(121));  // Output: true
        System.out.println(solution.isPalindrome(-121)); // Output: false
        System.out.println(solution.isPalindrome(10));   // Output: false
        System.out.println(solution.isPalindrome(0));    // Output: true
    }
}
