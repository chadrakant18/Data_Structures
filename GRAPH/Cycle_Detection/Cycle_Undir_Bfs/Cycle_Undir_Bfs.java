import java.util.*;

public class Cycle_Undir_Bfs {

    static class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public static boolean bfs(int src,
                              boolean[] vis,
                              ArrayList<ArrayList<Integer>> adj) {

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(src, -1));
        vis[src] = true;

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            int node = curr.node;
            int parent = curr.parent;

            for (int nbr : adj.get(node)) {

                if (!vis[nbr]) {
                    vis[nbr] = true;
                    q.offer(new Pair(nbr, node));
                }
                else if (nbr != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!vis[i]) {
                if (bfs(i, vis, adj))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}