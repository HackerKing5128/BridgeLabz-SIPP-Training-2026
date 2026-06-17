import java.util.Scanner;

public class HospitalBillingSystem {
    public static double calculateBillPerItem(double totalBill, int itemCount) throws InsufficientFundsException {
        if (itemCount == 0) {
            throw new InsufficientFundsException("Error: Bill divided by zero items");
        }
        return totalBill / itemCount;
    }

    public static String getPatientName(String[] patientNames, int index) {
        try {
            return patientNames[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid patient index. Index " + index + " is out of bounds");
            return null;
        }
    }

    public static double parseBillAmount(String amount) {
        try {
            return Double.parseDouble(amount);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid bill amount. Please enter a valid number");
            return -1;
        }
    }

    public static void processPayment(double billAmount, double paidAmount) throws InsufficientFundsException {
        if (paidAmount < billAmount) {
            throw new InsufficientFundsException(
                    "Payment failed: Insufficient funds. Bill: Rs." + billAmount + ", Paid: Rs." + paidAmount);
        }
        System.out.println("Payment successful. Change: Rs." + (paidAmount - billAmount));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] patients = { "Ram", "Sita", "Arjun", "Priya" };

        System.out.print("Enter patient index: ");
        int patientIndex = sc.nextInt();
        String patientName = getPatientName(patients, patientIndex);

        if (patientName == null) {
            sc.close();
            return;
        }

        System.out.print("Enter total bill amount: ");
        double billAmount = parseBillAmount(sc.next());

        if (billAmount == -1) {
            sc.close();
            return;
        }

        System.out.print("Enter number of items in bill: ");
        int itemCount = sc.nextInt();

        try {
            double pricePerItem = calculateBillPerItem(billAmount, itemCount);
            System.out.println("Price per item: Rs." + pricePerItem);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
            sc.close();
            return;
        }

        System.out.print("Enter paid amount: ");
        double paidAmount = parseBillAmount(sc.next());

        if (paidAmount == -1) {
            sc.close();
            return;
        }

        try {
            processPayment(billAmount, paidAmount);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
