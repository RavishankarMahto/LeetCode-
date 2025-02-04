import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), results);
        return results;
    }

    private void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> results) {
        if (tempList.size() == nums.length) {
            results.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; // Skip the already-used numbers
                tempList.add(nums[i]);
                backtrack(nums, tempList, results);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
