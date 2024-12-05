#include <stdlib.h>
#include <math.h>

// Function to compare two integers for qsort
int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

// Function to find the sum closest to the target
int threeSumClosest(int* nums, int numsSize, int target) {
    qsort(nums, numsSize, sizeof(int), compare); // Sort the array
    int closestSum = nums[0] + nums[1] + nums[2]; // Initialize the closest sum
    
    for (int i = 0; i < numsSize - 2; i++) {
        int left = i + 1;
        int right = numsSize - 1;
        
        while (left < right) {
            int currentSum = nums[i] + nums[left] + nums[right];
            
            // Update closest sum if the current sum is closer to the target
            if (abs(currentSum - target) < abs(closestSum - target)) {
                closestSum = currentSum;
            }
            
            // Move pointers based on the comparison with the target
            if (currentSum < target) {
                left++;
            } else if (currentSum > target) {
                right--;
            } else {
                // Exact match found
                return currentSum;
            }
        }
    }
    
    return closestSum;
}
