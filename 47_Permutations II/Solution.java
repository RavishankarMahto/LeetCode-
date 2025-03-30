import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution { // Changed class name to Solution

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array to handle duplicates
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;  // Skip duplicates
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution(); // Changed instance creation to Solution
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {1, 2, 3};

        System.out.println(sol.permuteUnique(nums1));
        System.out.println(sol.permuteUnique(nums2));
    }
}
