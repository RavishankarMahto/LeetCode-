import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a map to store groups of anagrams
        Map<String, List<String>> map = new HashMap<>();

        // Iterate through each string in the input array
        for (String s : strs) {
            // Convert the string to a character array and sort it
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);

            // If the sorted string is not in the map, add it with a new list
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            // Add the original string to the corresponding list
            map.get(sorted).add(s);
        }

        // Return the grouped anagrams as a list of lists
        return new ArrayList<>(map.values());
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strs1)); 
        // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        // Example 2
        String[] strs2 = {""};
        System.out.println(solution.groupAnagrams(strs2)); 
        // Output: [[""]]

        // Example 3
        String[] strs3 = {"a"};
        System.out.println(solution.groupAnagrams(strs3)); 
        // Output: [["a"]]
    }
}