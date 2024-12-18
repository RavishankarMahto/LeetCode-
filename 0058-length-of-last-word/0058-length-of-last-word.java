class Solution {
    public int lengthOfLastWord(String s) {
        // Trim trailing spaces from the string
        s = s.trim();
        
        // Find the last space in the string
        int lastSpaceIndex = s.lastIndexOf(' ');

        // Calculate the length of the last word
        return s.length() - lastSpaceIndex - 1;
    }
}

public class Main {
    public static void main(String[] args) {
        // Test cases
        Solution solution = new Solution();

        String s1 = "Hello World";
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: " + solution.lengthOfLastWord(s1)); // Output: 5

        String s2 = "   fly me   to   the moon  ";
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Output: " + solution.lengthOfLastWord(s2)); // Output: 4

        String s3 = "luffy is still joyboy";
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Output: " + solution.lengthOfLastWord(s3)); // Output: 6
    }
}
