class Solution:
    def isMatch(self, s, p):
        # Create a DP table where dp[i][j] means s[:i] matches p[:j]
        dp = [[False] * (len(p) + 1) for _ in range(len(s) + 1)]
        dp[0][0] = True  # Empty string matches empty pattern

        # Handle patterns with '*' that can match zero occurrences
        for j in range(2, len(p) + 1):
            if p[j - 1] == '*':
                dp[0][j] = dp[0][j - 2]

        # Fill the DP table
        for i in range(1, len(s) + 1):
            for j in range(1, len(p) + 1):
                if p[j - 1] == s[i - 1] or p[j - 1] == '.':
                    # If characters match or pattern has '.', it's a match
                    dp[i][j] = dp[i - 1][j - 1]
                elif p[j - 1] == '*':
                    # Check zero or more of the preceding element
                    dp[i][j] = dp[i][j - 2] or (dp[i - 1][j] and (s[i - 1] == p[j - 2] or p[j - 2] == '.'))

        return dp[len(s)][len(p)]

# Example usage
solution = Solution()
print(solution.isMatch("aa", "a"))      # Output: False
print(solution.isMatch("aa", "a*"))     # Output: True
print(solution.isMatch("ab", ".*"))     # Output: True
