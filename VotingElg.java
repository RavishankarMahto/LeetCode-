import java.util.Scanner;

public class VotingElg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the age
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Check eligibility
        if (age >= 18) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }

        scanner.close();
    }
}
