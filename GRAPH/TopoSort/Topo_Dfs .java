import java.util.*;

public class Topo_Dfs {

    public static void dfs(int node,
                           boolean[] vis,
                           Stack<Integer> st,
                           ArrayList<ArrayList<Integer>> adj) {

        vis[node] = true;

        for (int nbr : adj.get(node)) {
            if (!vis[nbr]) {
                dfs(nbr, vis, st, adj);
            }
        }

        st.push(node);
    }

    public static ArrayList<Integer> topoSort(int V,
                                              ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, st, adj);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (!st.isEmpty()) {
            ans.add(st.pop());
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}