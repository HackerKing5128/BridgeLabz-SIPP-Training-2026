import java.util.*;

public class MergeKSortedLogs {
    static class LogEntry {
        int timestamp;
        String message;

        LogEntry(int timestamp, String message) {
            this.timestamp = timestamp;
            this.message = message;
        }

        public String toString() {
            return timestamp + ":" + message;
        }
    }

    public static List<LogEntry> mergeKSortedLogs(List<List<LogEntry>> sources) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) ->
            sources.get(a[0]).get(a[1]).timestamp - sources.get(b[0]).get(b[1]).timestamp);

        for (int i = 0; i < sources.size(); i++) {
            if (!sources.get(i).isEmpty()) {
                minHeap.offer(new int[] {i, 0});
            }
        }

        List<LogEntry> merged = new ArrayList<LogEntry>();

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int sourceIdx = top[0];
            int elemIdx = top[1];

            merged.add(sources.get(sourceIdx).get(elemIdx));

            if (elemIdx + 1 < sources.get(sourceIdx).size()) {
                minHeap.offer(new int[] {sourceIdx, elemIdx + 1});
            }
        }

        return merged;
    }

    public static void main(String[] args) {
        List<List<LogEntry>> sources = new ArrayList<List<LogEntry>>();

        List<LogEntry> a = new ArrayList<LogEntry>();
        a.add(new LogEntry(1, "A1"));
        a.add(new LogEntry(4, "A4"));
        a.add(new LogEntry(7, "A7"));

        List<LogEntry> b = new ArrayList<LogEntry>();
        b.add(new LogEntry(2, "B2"));
        b.add(new LogEntry(5, "B5"));

        List<LogEntry> c = new ArrayList<LogEntry>();
        c.add(new LogEntry(3, "C3"));
        c.add(new LogEntry(6, "C6"));

        sources.add(a);
        sources.add(b);
        sources.add(c);

        System.out.println(mergeKSortedLogs(sources));
    }
}
