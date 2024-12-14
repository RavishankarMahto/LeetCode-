#include <string>
using namespace std;

class Solution {
public:
    string countAndSay(int n) {
        if (n == 1) return "1"; // Base case
        
        // Get the previous term recursively
        string prev = countAndSay(n - 1);
        string result = "";
        int count = 1;

        // Generate the nth term using Run-Length Encoding (RLE)
        for (int i = 1; i < prev.size(); i++) {
            if (prev[i] == prev[i - 1]) {
                count++; // Increment the count for the same character
            } else {
                // Append the count and the character to the result
                result += to_string(count) + prev[i - 1];
                count = 1; // Reset the count
            }
        }

        // Append the last character and its count
        result += to_string(count) + prev.back();
        return result;
    }
};
