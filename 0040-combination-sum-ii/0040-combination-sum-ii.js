/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function(candidates, target) {
    const result = [];
    candidates.sort((a, b) => a - b); 
    
    const backtrack = (start, target, current) => {
        if (target === 0) {
            result.push([...current]); 
            return;
        }
        if (target < 0) {
            return;
        }
        
        for (let i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] === candidates[i - 1]) {
                continue; 
            }
            current.push(candidates[i]); // Choose the current candidate
            backtrack(i + 1, target - candidates[i], current); // Move to the next index
            current.pop(); // Undo the choice (backtrack)
        }
    };
    
    backtrack(0, target, []);
    return result;
};

// Example usage:
const candidates1 = [10, 1, 2, 7, 6, 1, 5];
const target1 = 8;
console.log(combinationSum2(candidates1, target1));

const candidates2 = [2, 5, 2, 1, 2];
const target2 = 5;
console.log(combinationSum2(candidates2, target2));
