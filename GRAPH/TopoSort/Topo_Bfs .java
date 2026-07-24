import java.util.*;

public class Topo_Bfs {

    public static ArrayList<Integer> topoSort(int V,
                                              ArrayList<ArrayList<Integer>> adj) {

        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int nbr : adj.get(i)) {
                indegree[nbr]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {

            int node = q.poll();

            ans.add(node);

            for (int nbr : adj.get(node)) {

                indegree[nbr]--;

                if (indegree[nbr] == 0) {
                    q.offer(nbr);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}