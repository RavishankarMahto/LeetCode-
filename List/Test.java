package List;

import java.util.*;

public class Test {
    public static void main(String args[]) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        int[] arr1 = {'a', 'b', 'c', 'd', 'e'};  // Renamed and corrected array declaration

        for (int i = 0; i < arr.size(); i++) {  // Fixed loop syntax
            System.out.println(arr.get(i));  // Fixed method call
        }
    }
}
