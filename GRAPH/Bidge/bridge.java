import java.util.*;
class bridge {

    private int timer = 1;

    private void dfs(int node, int parent,
                     int[] vis,
                     ArrayList<ArrayList<Integer>> adj,
                     int[] tin,
                     int[] low,
                     List<List<Integer>> bridges) {

        vis[node] = 1;

        // Discovery time and lowest reachable time
        tin[node] = low[node] = timer;
        timer++;

        for (int it : adj.get(node)) {

            // Ignore the edge back to parent
            if (it == parent)
                continue;

            // Tree Edge
            if (vis[it] == 0) {

                dfs(it, node, vis, adj, tin, low, bridges);

                // Update low value after returning
                low[node] = Math.min(low[node], low[it]);

                // Check if edge is a bridge
                if (low[it] > tin[node]) {
                    bridges.add(Arrays.asList(node, it));
                }
            }

            // Back Edge
            else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n,
                                                   List<List<Integer>> connections) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];

        List<List<Integer>> bridges = new ArrayList<>();

        // Handles disconnected graphs too
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, -1, vis, adj, tin, low, bridges);
            }
        }

        return bridges;
    }
}