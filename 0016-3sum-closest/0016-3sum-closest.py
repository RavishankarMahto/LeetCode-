class Solution:
    def threeSumClosest(self, nums, target):
        nums.sort()  # Sort the array
        n = len(nums)
        closest_sum = float('inf')  # Initialize the closest sum to infinity

        for i in range(n - 2):  # Fix the first number
            left, right = i + 1, n - 1  # Two-pointer setup
            while left < right:
                current_sum = nums[i] + nums[left] + nums[right]

                # Update the closest sum if the current sum is closer to the target
                if abs(current_sum - target) < abs(closest_sum - target):
                    closest_sum = current_sum

                # Move the pointers based on comparison with target
                if current_sum < target:
                    left += 1
                elif current_sum > target:
                    right -= 1
                else:
                    # Exact match found
                    return current_sum

        return closest_sum
