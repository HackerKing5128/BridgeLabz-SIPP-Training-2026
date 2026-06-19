import java.io.*;

public class CustomerFeedbackAnalyzer {
    public static void analyzeFeedback() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("feedback.txt"));
            int goodCount = 0;
            int feedbackCount = 0;
            String line;

            while ((line = br.readLine()) != null && feedbackCount < 5) {
                if (line.toLowerCase().contains("good")) {
                    goodCount++;
                }
                System.out.println(line);
                feedbackCount++;
            }

            System.out.println("\nGood Feedback Count = " + goodCount);
        } catch (IOException e) {
            System.out.println("Error reading feedback file");
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                System.out.println("Error closing file");
            }
        }
    }

    public static void main(String[] args) {
        analyzeFeedback();
    }
}
