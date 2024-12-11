class Solution:
    def removeElement(self, nums, val):
        k = 0  # Pointer to track the position for valid elements
        
        for i in range(len(nums)):
            if nums[i] != val:
                nums[k] = nums[i]  # Place valid element at index `k`
                k += 1             # Increment pointer for next position
        
        return k  # Return the count of valid elements
