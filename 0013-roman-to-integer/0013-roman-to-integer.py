class Solution:
    def romanToInt(self, s):
        # Define a map for Roman numeral values
        roman_map = {
            'I': 1, 'V': 5, 'X': 10, 'L': 50,
            'C': 100, 'D': 500, 'M': 1000
        }
        
        total = 0  # To store the result
        prev_value = 0  # To keep track of the previous numeral's value
        
        # Process each Roman numeral in reverse order
        for char in reversed(s):
            current_value = roman_map[char]
            
            # If the current value is less than the previous, subtract it (subtractive notation)
            if current_value < prev_value:
                total -= current_value
            else:
                total += current_value
            
            # Update the previous value
            prev_value = current_value

        return total

# Example usage
if __name__ == "__main__":
    solution = Solution()
    print(solution.romanToInt("MMMDCCXLIX"))  # Output: 3749
    print(solution.romanToInt("LVIII"))       # Output: 58
    print(solution.romanToInt("MCMXCIV"))     # Output: 1994
