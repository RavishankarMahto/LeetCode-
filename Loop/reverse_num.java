package Loop;

public class reverse_num {
    public static void main(String[] args) {
      int num = 10899;

      while(num > 0){
        int lastDigit = num % 10;  // modulus operator
        System.out.println(lastDigit +" ");
        num = num / 10; // num/=10; // divide by 10
      }
    }
    
}
