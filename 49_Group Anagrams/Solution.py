from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs):
        # Create a dictionary to store groups of anagrams
        anagram_map = defaultdict(list)
        
        # Iterate through each string in the input list
        for s in strs:
            # Sort the string and use it as a key
            sorted_str = ''.join(sorted(s))
            # Add the original string to the corresponding list
            anagram_map[sorted_str].append(s)
        
        # Return the grouped anagrams as a list of lists
        return list(anagram_map.values())

# Example usage
if __name__ == "__main__":
    solution = Solution()
    
    # Example 1
    strs1 = ["eat", "tea", "tan", "ate", "nat", "bat"]
    print(solution.groupAnagrams(strs1))
    # Output: [['eat', 'tea', 'ate'], ['tan', 'nat'], ['bat']]
    
    # Example 2
    strs2 = [""]
    print(solution.groupAnagrams(strs2))
    # Output: [['']]
    
    # Example 3
    strs3 = ["a"]
    print(solution.groupAnagrams(strs3))
    # Output: [['a']]