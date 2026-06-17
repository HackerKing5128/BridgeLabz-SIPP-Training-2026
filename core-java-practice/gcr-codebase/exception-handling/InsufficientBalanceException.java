public class InsufficientBalanceException extends Exception {
    private double balance;
    private double withdrawalAmount;

    public InsufficientBalanceException(double balance, double withdrawalAmount) {
        super("Withdrawal failed: Insufficient balance. Available: Rs." + balance + ", Requested: Rs." + withdrawalAmount);
        this.balance = balance;
        this.withdrawalAmount = withdrawalAmount;
    }

    public double getBalance() {
        return balance;
    }

    public double getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public double getDeficit() {
        return withdrawalAmount - balance;
    }
}
