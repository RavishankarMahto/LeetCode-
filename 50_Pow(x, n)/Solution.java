public class Solution {
    
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        
        double result = 1;
        while (n > 0) {
            if (n % 2 != 0) {
                result *= x;
            }
            x *= x;
            n /= 2;
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        System.out.printf("pow(2.00000, 10) = %.5f%n", solution.myPow(2.00000, 10)); // Output: 1024.00000
        System.out.printf("pow(2.10000, 3) = %.5f%n", solution.myPow(2.10000, 3));  // Output: 9.26100
        System.out.printf("pow(2.00000, -2) = %.5f%n", solution.myPow(2.00000, -2)); // Output: 0.25000
    }
}
