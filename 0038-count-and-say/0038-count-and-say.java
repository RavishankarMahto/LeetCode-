class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1"; // Base case
        
        // Get the previous term recursively
        String prev = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        int count = 1;

        // Generate the nth term using Run-Length Encoding (RLE)
        for (int i = 1; i < prev.length(); i++) {
            if (prev.charAt(i) == prev.charAt(i - 1)) {
                count++; // Increment the count for the same character
            } else {
                // Append the count and the character to the result
                result.append(count).append(prev.charAt(i - 1));
                count = 1; // Reset the count
            }
        }

        // Append the last character and its count
        result.append(count).append(prev.charAt(prev.length() - 1));
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        System.out.println("Count-and-Say Sequence at n = " + n + ": " + solution.countAndSay(n));
        scanner.close();
    }
}