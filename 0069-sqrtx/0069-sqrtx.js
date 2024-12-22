function mySqrt(x) {
    if (x === 0 || x === 1) {
        return x; // The square root of 0 is 0, and the square root of 1 is 1.
    }

    // Initialize binary search bounds
    let left = 1, right = x, result = 0;

    while (left <= right) {
        let mid = Math.floor(left + (right - left) / 2);

        // Check if mid * mid is less than or equal to x
        if (mid <= Math.floor(x / mid)) {
            result = mid; // Update result as mid might be the answer
            left = mid + 1; // Search in the right half
        } else {
            right = mid - 1; // Search in the left half
        }
    }

    return result;
}

// Test cases
console.log(mySqrt(4)); // Output: 2
console.log(mySqrt(8)); // Output: 2
