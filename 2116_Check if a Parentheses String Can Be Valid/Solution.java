public class Solution {

    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) {
            // Odd length strings cannot be valid parentheses strings
            return false;
        }

        // Check for validity from left to right
        int balance = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                // Use the current character as it is
                balance += s.charAt(i) == '(' ? 1 : -1;
            } else {
                // Assume we can choose '(' for now to maximize balance
                balance++;
            }
            if (balance < 0) {
                // Too many ')' at this point
                return false;
            }
        }

        // Check for validity from right to left
        balance = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                // Use the current character as it is
                balance += s.charAt(i) == ')' ? 1 : -1;
            } else {
                // Assume we can choose ')' for now to maximize balance
                balance++;
            }
            if (balance < 0) {
                // Too many '(' at this point
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String s1 = "))()))";
        String locked1 = "010100";
        System.out.println(solution.canBeValid(s1, locked1)); // Output: true

        // Example 2
        String s2 = "()()";
        String locked2 = "0000";
        System.out.println(solution.canBeValid(s2, locked2)); // Output: true

        // Example 3
        String s3 = ")";
        String locked3 = "0";
        System.out.println(solution.canBeValid(s3, locked3)); // Output: false
    }
}

