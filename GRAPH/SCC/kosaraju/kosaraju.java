package kosaraju;

import java.util.*;

public class kosaraju {

    static void dfs1(int node, boolean[] vis,
                     ArrayList<ArrayList<Integer>> adj,
                     Stack<Integer> st) {

        vis[node] = true;

        for (int next : adj.get(node)) {
            if (!vis[next]) {
                dfs1(next, vis, adj, st);
            }
        }

        // Push after visiting all neighbours
        st.push(node);
    }

    static void dfs2(int node, boolean[] vis,
                     ArrayList<ArrayList<Integer>> adjT) {

        vis[node] = true;
        System.out.print(node + " ");

        for (int next : adjT.get(node)) {
            if (!vis[next]) {
                dfs2(next, vis, adjT);
            }
        }
    }

    static void kosarajuAlgo(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        // Step 1: Store vertices according to finishing time
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs1(i, vis, adj, st);
            }
        }

        // Step 2: Reverse the graph
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {

            vis[i] = false;

            for (int next : adj.get(i)) {
                adjT.get(next).add(i);
            }
        }

        // Step 3: Process vertices in stack order
        int scc = 0;

        while (!st.isEmpty()) {

            int node = st.pop();

            if (!vis[node]) {

                scc++;

                System.out.print("SCC " + scc + " : ");

                dfs2(node, vis, adjT);

                System.out.println();
            }
        }

        System.out.println("Total SCC = " + scc);
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Graph
        // 0 -> 2
        // 2 -> 1
        // 1 -> 0
        // 0 -> 3
        // 3 -> 4

        adj.get(0).add(2);
        adj.get(2).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(4);

        kosarajuAlgo(V, adj);
    }
}