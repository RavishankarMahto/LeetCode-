package operator;

public class increment {
    public static void main(String[] args) {
        
        int num1 = 7;
        int num2 = 10;

        // int result = num1 + num2;
        // int result = num1 - num2;
        int result1 = num1 * num2;
        int result = num1 / num2;
        int result2 = num1 % num2;
        int result3 = num1++;   // post increment
        int result4 = ++num1;   // pre increment
        int result5 = num1--;   // post decrement
        int result6 = --num1;   // pre decrement
        int result7 = num1 += 5; // post increment
        int result8 = num1 -= 5; // post decrement
        int result9 = num1 *= 5; // post increment
        int result10 = num1 /= 5; // post decrement
        

        System.out.println(result1);
        System.out.println(result);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
        System.out.println(result7);
        System.out.println(result8);
        System.out.println(result9);
        System.out.println(result10);


        System.out.println(result2);

    }
    
}
