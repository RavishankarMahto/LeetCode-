/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function(nums, val) {
    
    let k = 0; // Pointer to track the next position for valid elements

    for (let i = 0; i < nums.length; i++) {
        if (nums[i] !== val) {
            nums[k] = nums[i]; // Place the valid element at index `k`
            k++;               // Increment the pointer for the next position
        }
    }

    return k; // Return the count of valid elements
};

// Example usage:
let nums = [0, 1, 2, 2, 3, 0, 4, 2];
let val = 2;

let k = removeElement(nums, val);
console.log("k =", k); // Output: 5
console.log("Modified array:", nums.slice(0, k)); // Output: [0, 1, 3, 0, 4]