    class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        // Create a DP table
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // Empty string matches empty pattern

        // Handle patterns with '*' that can match zero occurrences
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    // Characters match or pattern has '.'
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // Check zero or more occurrences of the preceding character
                    dp[i][j] = dp[i][j - 2] || 
                               (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                }
            }
        }

        return dp[m][n];
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aa", "a"));      // Output: false
        System.out.println(solution.isMatch("aa", "a*"));     // Output: true
        System.out.println(solution.isMatch("ab", ".*"));     // Output: true
    }
}