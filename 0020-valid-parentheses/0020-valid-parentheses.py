class Solution:
    def isValid(self, s):
        # Use a stack to keep track of opening brackets
        stack = []
        # Map to match opening and closing brackets
        bracket_map = {')': '(', '}': '{', ']': '['}
        
        # Iterate through each character in the string
        for char in s:
            # If the character is a closing bracket
            if char in bracket_map:
                # Pop the top of the stack if it's not empty, otherwise use a dummy value
                top_element = stack.pop() if stack else '#'
                # If the top of the stack doesn't match the corresponding opening bracket, return False
                if bracket_map[char] != top_element:
                    return False
            else:
                # Push opening brackets onto the stack
                stack.append(char)
        
        # If the stack is empty, all brackets were properly closed; otherwise, return False
        return not stack


# Testing the Solution
if __name__ == "__main__":
    solution = Solution()
    
    # Test cases
    test_cases = ["()", "()[]{}", "(]", "([])", "([)]", "{[]}", ""]
    
    # Run each test case
    for test in test_cases:
        print("Input: {}".format(test))
        print("Output: {}".format(solution.isValid(test)))
        print()
