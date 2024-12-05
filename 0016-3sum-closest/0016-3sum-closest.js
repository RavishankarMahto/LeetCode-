/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function(nums, target) {
    nums.sort((a, b) => a - b); // Sort the array
    let closestSum = Infinity; // Initialize the closest sum to Infinity

    for (let i = 0; i < nums.length - 2; i++) { // Fix the first number
        let left = i + 1;
        let right = nums.length - 1;

        while (left < right) {
            let currentSum = nums[i] + nums[left] + nums[right];
            
            // Update the closest sum if the current sum is closer to the target
            if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                closestSum = currentSum;
            }
            
            // Move the pointers based on the comparison with the target
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
};

// Example Usage
const nums1 = [-1, 2, 1, -4];
const target1 = 1;
console.log(threeSumClosest(nums1, target1)); // Output: 2

const nums2 = [0, 0, 0];
const target2 = 1;
console.log(threeSumClosest(nums2, target2)); // Output: 0
