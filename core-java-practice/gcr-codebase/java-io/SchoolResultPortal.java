import java.io.*;

public class SchoolResultPortal {
    public static void generateReportCard(String inputFile, String outputFile) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(inputFile));
            bw = new BufferedWriter(new FileWriter(outputFile, true));

            String line;
            bw.write("=== REPORT CARD ===\n");
            bw.write("Name | Marks | Average\n");
            bw.write("----------------------------\n");

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" - ");
                if (parts.length == 2) {
                    String name = parts[0];
                    String[] marks = parts[1].split(",");
                    double sum = 0;
                    for (String mark : marks) {
                        sum = sum + Double.parseDouble(mark.trim());
                    }
                    double average = sum / marks.length;
                    bw.write(name + " | " + parts[1] + " | " + average + "\n");
                }
            }
            bw.write("----------------------------\n");
            System.out.println("Report card generated successfully in " + outputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found - " + inputFile);
        } catch (IOException e) {
            System.out.println("Error: IO operation failed");
        } finally {
            try {
                if (br != null) br.close();
                if (bw != null) bw.close();
            } catch (IOException e) {
                System.out.println("Error closing files");
            }
        }
    }

    public static void main(String[] args) {
        generateReportCard("results.txt", "reportCard.txt");
    }
}
