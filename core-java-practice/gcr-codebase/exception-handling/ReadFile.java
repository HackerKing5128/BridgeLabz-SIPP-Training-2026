import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void readFile(String fileName) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line;
            System.out.println("File contents:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error closing file");
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            readFile("sample.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file");
        }
    }
}
