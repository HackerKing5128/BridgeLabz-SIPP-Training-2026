import java.util.Scanner;

public class ATMWithdrawal {
    private double balance;

    public ATMWithdrawal(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(balance, amount);
        }
        balance = balance - amount;
        System.out.println("Withdrawal successful. Amount: Rs." + amount);
        System.out.println("Remaining balance: Rs." + balance);
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATMWithdrawal atm = new ATMWithdrawal(5000);

        System.out.println("Current balance: Rs." + atm.getBalance());
        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();

        try {
            atm.withdraw(amount);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
            System.out.println("Deficit: Rs." + e.getDeficit());
        }
    }
}
