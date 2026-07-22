
import java.util.*;

public class DFSAllPaths {

    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addEdge(int u, int v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    public void findAllPaths(int source, int destination) {

        List<List<Integer>> allPaths = new ArrayList<>();

        dfs(source,
                destination,
                new ArrayList<>(),
                new HashSet<>(),
                allPaths);

        System.out.println("All Paths:");

        for (List<Integer> path : allPaths) {
            System.out.println(path);
        }
    }

    private void dfs(int current,
            int destination,
            List<Integer> path,
            Set<Integer> visited,
            List<List<Integer>> allPaths) {

        path.add(current);
        visited.add(current);

        if (current == destination) {
            allPaths.add(new ArrayList<>(path));
        } else {

            for (int next : graph.getOrDefault(current, Collections.emptyList())) {

                if (!visited.contains(next)) {
                    dfs(next, destination, path, visited, allPaths);
                }
            }
        }

        path.remove(path.size() - 1);
        visited.remove(current);
    }

    public static void main(String[] args) {

        DFSAllPaths roads = new DFSAllPaths();

        roads.addEdge(1, 2);
        roads.addEdge(1, 3);
        roads.addEdge(2, 4);
        roads.addEdge(3, 4);
        roads.addEdge(4, 5);

        roads.findAllPaths(1, 5);
    }
}
