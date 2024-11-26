class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Base case
        if (s == null || s.length() == 0) return 0;

        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is already in the set, move the left pointer
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the set
            set.add(currentChar);

            // Update the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "abcabcbb";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + solution.lengthOfLongestSubstring(s1)); // Output: 3

        // Test case 2
        String s2 = "bbbbb";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + solution.lengthOfLongestSubstring(s2)); // Output: 1

        // Test case 3
        String s3 = "pwwkew";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + solution.lengthOfLongestSubstring(s3)); // Output: 3

        // Additional test case
        String s4 = "";
        System.out.println("Input: \"" + s4 + "\"");
        System.out.println("Output: " + solution.lengthOfLongestSubstring(s4)); // Output: 0
    }
}
