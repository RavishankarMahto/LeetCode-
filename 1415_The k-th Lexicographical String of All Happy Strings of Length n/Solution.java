import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getHappyString(int n, int k) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), n);
        
        // Check if there are at least k happy strings
        if (result.size() < k) {
            return "";
        } else {
            return result.get(k - 1);
        }
    }
    
    private void backtrack(List<String> result, StringBuilder sb, int n) {
        if (sb.length() == n) {
            result.add(sb.toString());
            return;
        }
        
        for (char c : new char[]{'a', 'b', 'c'}) {
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != c) {
                sb.append(c);
                backtrack(result, sb, n);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getHappyString(1, 3)); // Output: "c"
        System.out.println(solution.getHappyString(1, 4)); // Output: ""
        System.out.println(solution.getHappyString(3, 9)); // Output: "cab"
    }
}
