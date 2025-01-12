class Solution:
    def canBeValid(self, s: str, locked: str) -> bool:
        n = len(s)
        if n % 2 != 0:
            # Odd length strings cannot be valid parentheses strings
            return False

        # Check for validity from left to right
        balance = 0
        for i in range(n):
            if locked[i] == '1':
                # Use the current character as it is
                balance += 1 if s[i] == '(' else -1
            else:
                # Assume we can choose '(' to maximize balance
                balance += 1
            if balance < 0:
                # Too many ')' at this point
                return False

        # Check for validity from right to left
        balance = 0
        for i in range(n - 1, -1, -1):
            if locked[i] == '1':
                # Use the current character as it is
                balance += 1 if s[i] == ')' else -1
            else:
                # Assume we can choose ')' to maximize balance
                balance += 1
            if balance < 0:
                # Too many '(' at this point
                return False

        return True


# Example usage for testing
if __name__ == "__main__":
    solution = Solution()

    # Example 1
    s1 = "))()))"
    locked1 = "010100"
    print(solution.canBeValid(s1, locked1))  # Output: True

    # Example 2
    s2 = "()()"
    locked2 = "0000"
    print(solution.canBeValid(s2, locked2))  # Output: True

    # Example 3
    s3 = ")"
    locked3 = "0"
    print(solution.canBeValid(s3, locked3))  # Output: False
