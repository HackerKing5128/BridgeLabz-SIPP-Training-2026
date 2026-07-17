import java.util.*;

public class GroupAnagramsTickets {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<String, List<String>>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<String>());
            }
            groups.get(key).add(s);
        }

        return new ArrayList<List<String>>(groups.values());
    }

    public static void main(String[] args) {
        String[] tickets = {"listen", "silent", "enlist", "rat", "tar", "art"};
        System.out.println(groupAnagrams(tickets));
    }
}
