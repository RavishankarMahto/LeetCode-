package Function;

import java.util.Scanner;

public class Sum {
    public static void calculateSum(int a, int b){
        int sum = a + b;
        System.out.println("Sum is : " + sum);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        calculateSum(x,y);
    }
}
