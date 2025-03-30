import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Map digits to corresponding letters
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result; // Return empty list for no input
        }

        // Start backtracking
        backtrack(result, digits, 0, new StringBuilder());
        return result;
    }

    private void backtrack(List<String> result, String digits, int index, StringBuilder current) {
        // Base case: If the current combination length matches the input length
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        String letters = KEYPAD[digits.charAt(index) - '0'];

        // Explore each letter option for the current digit
        for (char letter : letters.toCharArray()) {
            current.append(letter); // Choose
            backtrack(result, digits, index + 1, current); // Explore
            current.deleteCharAt(current.length() - 1); // Unchoose
        }
    }

    public static void main(String[] args) {
        // Test cases
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23")); // ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
        System.out.println(solution.letterCombinations(""));   // []
        System.out.println(solution.letterCombinations("2"));  // ["a", "b", "c"]
    }
}
