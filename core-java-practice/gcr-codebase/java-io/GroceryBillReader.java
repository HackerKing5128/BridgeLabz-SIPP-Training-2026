import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GroceryBillReader {
    public static void readBill(String fileName) {
        BufferedReader br = null;
        int lineCount = 0;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line;
            System.out.println("Bill Contents:");
            System.out.println("----------------------------");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                lineCount++;
            }

            System.out.println("----------------------------");
            System.out.println("Total lines: " + lineCount);
        } catch (IOException e) {
            System.out.println("Error reading bill file");
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                System.out.println("Error closing file");
            }
        }
    }

    public static void main(String[] args) {
        readBill("bill.txt");
    }
}
