class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0
        if n < 0:
            x = 1 / x
            n = -n
        
        result = 1.0
        while n > 0:
            if n % 2 != 0:
                result *= x
            x *= x
            n //= 2
        
        return result

# Test cases
solution = Solution()
print(f"pow(2.00000, 10) = {solution.myPow(2.00000, 10):.5f}")  # Output: 1024.00000
print(f"pow(2.10000, 3) = {solution.myPow(2.10000, 3):.5f}")    # Output: 9.26100
print(f"pow(2.00000, -2) = {solution.myPow(2.00000, -2):.5f}")  # Output: 0.25000
