import java.io.*;
import java.util.Scanner;

public class ExpenseLogger {
    public static void logExpense(String category, double amount) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("expenses.txt", true));
            bw.write(category + " - " + amount + "\n");
            System.out.println("Expense logged successfully");
        } catch (IOException e) {
            System.out.println("Error writing to expense file");
        } finally {
            try {
                if (bw != null) bw.close();
            } catch (IOException e) {
                System.out.println("Error closing file");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter expense category: ");
        String category = sc.nextLine();
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        logExpense(category, amount);
    }
}
