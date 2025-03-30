class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 1  # Base case: Only one way to climb 1 step
        
        # Initialize variables to store the previous two values
        prev2 = 1  # Ways to climb 1 step
        prev1 = 2  # Ways to climb 2 steps
        
        # Calculate the ways for each step from 3 to n
        for i in range(3, n + 1):
            current = prev1 + prev2  # Current step ways
            prev2 = prev1  # Update prev2
            prev1 = current  # Update prev1
        
        return prev1 if n > 1 else prev2

# Example usage:
solution = Solution()
print(solution.climbStairs(2))  # Output: 2
print(solution.climbStairs(3))  # Output: 3
print(solution.climbStairs(5))  # Output: 8
