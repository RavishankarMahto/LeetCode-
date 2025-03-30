class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x == 0 or x == 1:
            return x  # The square root of 0 is 0, and the square root of 1 is 1.

        # Initialize binary search bounds
        left, right = 1, x
        result = 0

        while left <= right:
            mid = left + (right - left) // 2

            # Check if mid * mid is less than or equal to x
            if mid <= x // mid:
                result = mid  # Update result as mid might be the answer
                left = mid + 1  # Search in the right half
            else:
                right = mid - 1  # Search in the left half

        return result


# Test cases
solution = Solution()
print(solution.mySqrt(4))  # Output: 2
print(solution.mySqrt(8))  # Output: 2
