class Solution:
    def threeSum(self, nums):
        # Sort the input array
        nums.sort()
        result = []
        
        # Iterate through the array
        for i in range(len(nums) - 2):
            # Skip duplicates for the first number
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            
            # Use two pointers to find the other two numbers
            left, right = i + 1, len(nums) - 1
            while left < right:
                total = nums[i] + nums[left] + nums[right]
                
                if total == 0:
                    result.append([nums[i], nums[left], nums[right]])
                    
                    # Move pointers to skip duplicates
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    
                    # Move pointers to next positions
                    left += 1
                    right -= 1
                elif total < 0:
                    left += 1
                else:
                    right -= 1
        
        return result

# Example usage
if __name__ == "__main__":
    solution = Solution()
    print(solution.threeSum([-1, 0, 1, 2, -1, -4]))  # Output: [[-1, -1, 2], [-1, 0, 1]]
    print(solution.threeSum([0, 1, 1]))             # Output: []
    print(solution.threeSum([0, 0, 0]))             # Output: [[0, 0, 0]]
