package List;

import java.util.*;
public class Test1 {
    
    public static void main(String[] args) {
        
        List<Integer> arr = new ArrayList<>();
        Map<String, Integer> marks = new HashMap<>();

        marks.put("Ravi", 100);  //     Ravi is the key and 100 is Value
        marks.put("Suruchi", 150);  //  Suruchi is the key and 150 is the value

        for(Map.Entry<String, Integer> entry : marks.entrySet()){
           // System.out.println(entry.getKey() + " " + entry.getValue());
           System.out.print(entry.getKey());
            System.out.print(entry.getValue());
            System.out.println("____________");
        }

        // arr.add(1);
        // arr.add(2);
        // arr.add(3);
        // arr.add(4);
        // arr.add(5);

        // for(int i = 0; i < arr.size(); i++){
        //     System.out.println(arr.get(i));
        // }

        // // int[] arr1 = {'a', 'b', 'c', 'd', 'e'};  // Renamed and corrected array declaration

        // for (int i = 0; i < arr.size(); i++) {  // Fixed loop syntax
        //     System.out.println(arr.get(i));  // Fixed method call
        // }

    }
}
