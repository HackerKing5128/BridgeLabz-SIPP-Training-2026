import java.util.Scanner;

public class InterestCalculator {
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (rate < 0) {
            throw new IllegalArgumentException("Rate must be positive");
        }
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter principal amount: ");
        double amount = sc.nextDouble();
        System.out.print("Enter interest rate: ");
        double rate = sc.nextDouble();
        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        try {
            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated interest: Rs." + interest);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        }

    }
}
