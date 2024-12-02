import java.util.Stack;

public class Solution {

    // Method to check if the string contains valid parentheses
    public boolean isValid(String s) {
        // Use a stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // If the character is an opening bracket, push it onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // If the character is a closing bracket
            else {
                // If the stack is empty or the top of the stack does not match the closing bracket, return false
                if (stack.isEmpty() || 
                   (c == ')' && stack.pop() != '(') ||
                   (c == '}' && stack.pop() != '{') ||
                   (c == ']' && stack.pop() != '[')) {
                    return false;
                }
            }
        }
        
        // If the stack is empty, all brackets were properly closed; otherwise, return false
        return stack.isEmpty();
    }

    // Main method for testing the functionality
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        String[] testCases = { "()", "()[]{}", "(]", "([])", "([)]", "{[]}", "" };
        
        // Run each test case
        for (String testCase : testCases) {
            System.out.println("Input: " + testCase);
            System.out.println("Output: " + solution.isValid(testCase));
            System.out.println();
        }
    }
}
