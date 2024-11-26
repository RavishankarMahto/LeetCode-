import java.util.*;
public class ReduceN2Zero {

    public int numberOfSteps(int num) {
            int steps = 0;

            while(num > 0) {
                if(num % 2 == 0) {
                    num /= 2;
                } else {
                    num--;

                }
                steps++;
            }

            return steps; 
        
    }
    // Time complexity : Olog(n)
    // Space complexity : O(1)  
    
}