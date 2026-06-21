import java.util.*;

public class Cycle_Undir_Dfs {

    public static boolean dfs(int node,
                              int parent,
                              boolean[] vis,
                              ArrayList<ArrayList<Integer>> adj) {

        vis[node] = true;

        for (int nbr : adj.get(node)) {

            if (!vis[nbr]) {

                if (dfs(nbr, node, vis, adj))
                    return true;
            }
            else if (nbr != parent) {
                return true;
            }
        }

        return false;
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!vis[i]) {

                if (dfs(i, -1, vis, adj))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}