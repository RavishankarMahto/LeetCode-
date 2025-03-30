class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        
        # Initialize the slow pointer
        unique_index = 0
        
        # Traverse the array with the fast pointer
        for i in range(1, len(nums)):
            if nums[i] != nums[unique_index]:
                # Increment the slow pointer and update the value
                unique_index += 1
                nums[unique_index] = nums[i]
        
        # The number of unique elements is unique_index + 1
        return unique_index + 1
