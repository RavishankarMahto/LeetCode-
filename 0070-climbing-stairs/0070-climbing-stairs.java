public class Solution {

    public int climbStairs(int n) {
        if (n == 1) return 1; // Base case: Only one way to climb 1 step.

        // Initialize an array to store ways to climb each step.
        int[] dp = new int[n + 1];
        dp[1] = 1; // One way to climb 1 step.
        dp[2] = 2; // Two ways to climb 2 steps (1+1 or 2).

        // Fill the dp array for the remaining steps.
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // Sum of ways to climb (i-1) and (i-2) steps.
        }

        return dp[n]; // The number of ways to climb 'n' steps.
    }
}
