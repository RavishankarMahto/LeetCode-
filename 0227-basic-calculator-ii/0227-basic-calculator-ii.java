class Solution {
    public int calculate(String s) {
        int num = 0;
        char lastOperator = '+'; // Default operator for the first number
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If it's a digit, build the current number
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // If it's an operator or we've reached the end of the string
            if (!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) {
                if (lastOperator == '+') {
                    stack.push(num);
                } else if (lastOperator == '-') {
                    stack.push(-num);
                } else if (lastOperator == '*') {
                    stack.push(stack.pop() * num);
                } else if (lastOperator == '/') {
                    stack.push(stack.pop() / num); // Integer division truncates toward zero
                }

                // Update operator and reset number
                lastOperator = ch;
                num = 0;
            }
        }

        // Sum up all the elements in the stack
        int result = 0;
        for (int value : stack) {
            result += value;
        }
        return result;
    }
}
