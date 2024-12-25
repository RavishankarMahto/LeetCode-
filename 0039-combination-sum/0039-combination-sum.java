import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // Add the current combination to the result
            return;
        }
        if (target < 0) {
            return; // Stop exploring this path as the target is negative
        }
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]); // Choose the current candidate
            backtrack(candidates, target - candidates[i], i, current, result); // Explore with the same candidate
            current.remove(current.size() - 1); // Undo the choice (backtrack)
        }
    }
}
