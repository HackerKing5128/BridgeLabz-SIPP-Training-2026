import java.util.*;

public class DuplicateSessionTokenDetection {
    public static boolean hasDuplicateToken(String[] tokens) {
        Set<String> seen = new HashSet<String>();

        for (String token : tokens) {
            if (!seen.add(token)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String[] tokens = {"T1A", "T2B", "T3C", "T2B"};
        System.out.println(hasDuplicateToken(tokens));
    }
}
