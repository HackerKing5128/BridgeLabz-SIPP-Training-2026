
import java.util.*;

public class BFSShortestPath {

    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addEdge(int u, int v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    public List<Integer> shortestPath(int start, int destination) {

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> parent = new HashMap<>();

        queue.offer(start);
        visited.add(start);
        parent.put(start, null);

        while (!queue.isEmpty()) {

            int city = queue.poll();

            if (city == destination) {
                break;
            }

            for (int next : graph.getOrDefault(city, Collections.emptyList())) {

                if (!visited.contains(next)) {
                    visited.add(next);
                    parent.put(next, city);
                    queue.offer(next);
                }
            }
        }

        if (!visited.contains(destination)) {
            return Collections.emptyList();
        }

        LinkedList<Integer> path = new LinkedList<>();

        Integer node = destination;

        while (node != null) {
            path.addFirst(node);
            node = parent.get(node);
        }

        return path;
    }

    public static void main(String[] args) {

        BFSShortestPath flightMap = new BFSShortestPath();

        flightMap.addEdge(1, 2);
        flightMap.addEdge(1, 3);
        flightMap.addEdge(2, 4);
        flightMap.addEdge(3, 5);
        flightMap.addEdge(5, 6);
        flightMap.addEdge(4, 6);

        System.out.println("Shortest Path:");
        System.out.println(flightMap.shortestPath(1, 6));
    }
}
