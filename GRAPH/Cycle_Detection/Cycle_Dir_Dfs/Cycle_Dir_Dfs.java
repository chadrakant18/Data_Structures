import java.util.*;

public class Cycle_Dir_Dfs {

    public static boolean dfs(int node,
                              ArrayList<ArrayList<Integer>> adj,
                              boolean[] vis,
                              boolean[] pathVis) {

        vis[node] = true;
        pathVis[node] = true;

        for (int nbr : adj.get(node)) {

            if (!vis[nbr]) {
                if (dfs(nbr, adj, vis, pathVis))
                    return true;
            }
            else if (pathVis[nbr]) {
                return true;
            }
        }

        pathVis[node] = false;
        return false;
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!vis[i]) {
                if (dfs(i, adj, vis, pathVis))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}