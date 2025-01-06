class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        def generate_subsets(index, current, result):
            # Add the current subset to the result
            result.append(list(current))

            # Generate all subsets that include nums[index] and beyond
            for i in range(index, len(nums)):
                # Include nums[i] in the current subset
                current.append(nums[i])
                # Recur with the next index
                generate_subsets(i + 1, current, result)
                # Backtrack to explore other subsets
                current.pop()

        result = []
        generate_subsets(0, [], result)
        return result


# Example usage
solution = Solution()
nums1 = [1, 2, 3]
print("Input: nums =", nums1)
print("Output:", solution.subsets(nums1))

nums2 = [0]
print("\nInput: nums =", nums2)
print("Output:", solution.subsets(nums2))
