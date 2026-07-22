
import java.util.*;

public class UndirectedCycleDetection {

    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addEdge(int u, int v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    private boolean dfs(int node, int parent, Set<Integer> visited) {

        visited.add(node);

        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {

            if (!visited.contains(neighbor)) {

                if (dfs(neighbor, node, visited)) {
                    return true;
                }

            } else if (neighbor != parent) {

                return true;
            }
        }

        return false;
    }

    public boolean hasCycle(int vertices) {

        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < vertices; i++) {

            if (!visited.contains(i)) {

                if (dfs(i, -1, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        UndirectedCycleDetection graph = new UndirectedCycleDetection();

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        if (graph.hasCycle(3)) {
            System.out.println("Cycle Found"); 
        }else {
            System.out.println("No Cycle");
        }
    }
}
