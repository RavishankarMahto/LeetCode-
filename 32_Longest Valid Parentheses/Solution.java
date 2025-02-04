public class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        int left = 0, right = 0;

        // Traverse the string from left to right
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }

        // Reset the counters and traverse the string from right to left
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String s1 = "(()";
        String s2 = ")()())";
        String s3 = "";

        System.out.println(solution.longestValidParentheses(s1)); // Output: 2
        System.out.println(solution.longestValidParentheses(s2)); // Output: 4
        System.out.println(solution.longestValidParentheses(s3)); // Output: 0
    }
}
