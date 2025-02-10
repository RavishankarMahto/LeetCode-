from typing import List

class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        def backtrack(path, used):
            if len(path) == len(nums):
                result.append(path[:])
                return
            for i in range(len(nums)):
                if used[i] or (i > 0 and nums[i] == nums[i - 1] and not used[i - 1]):
                    continue
                used[i] = True
                path.append(nums[i])
                backtrack(path, used)
                path.pop()
                used[i] = False

        nums.sort()
        result = []
        backtrack([], [False] * len(nums))
        return result

# Test the code
sol = Solution()
nums1 = [1, 1, 2]
nums2 = [1, 2, 3]
print(sol.permuteUnique(nums1))
print(sol.permuteUnique(nums2))
