class Solution:
    def maxArea(self, height):
        max_area = 0  # Initialize the maximum area to 0
        left = 0  # Pointer at the start of the array
        right = len(height) - 1  # Pointer at the end of the array

        # Loop until the two pointers meet
        while left < right:
            # Calculate the width and the minimum height between the two lines
            width = right - left
            min_height = min(height[left], height[right])

            # Calculate the area and update max_area if the current area is larger
            current_area = width * min_height
            max_area = max(max_area, current_area)

            # Move the pointer corresponding to the smaller height
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1

        return max_area  # Return the maximum area
