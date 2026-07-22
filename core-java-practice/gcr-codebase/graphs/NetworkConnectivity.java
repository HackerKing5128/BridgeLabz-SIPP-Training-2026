
import java.util.*;

public class NetworkConnectivity {

    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addEdge(int u, int v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    private void dfs(int node, Set<Integer> visited) {

        visited.add(node);

        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {

            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }

    public int countConnectedComponents(int n) {

        Set<Integer> visited = new HashSet<>();
        int components = 0;

        for (int i = 0; i < n; i++) {

            if (!visited.contains(i)) {
                components++;
                dfs(i, visited);
            }
        }

        return components;
    }

    public static void main(String[] args) {

        NetworkConnectivity network = new NetworkConnectivity();

        network.addEdge(0, 1);
        network.addEdge(1, 2);

        network.addEdge(3, 4);

        int vertices = 5;

        int components = network.countConnectedComponents(vertices);

        System.out.println("Connected Components = " + components);

        if (components == 1) {
            System.out.println("Network is Fully Connected"); 
        }else {
            System.out.println("Network is NOT Fully Connected");
        }
    }
}
