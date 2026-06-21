import java.util.*;

public class Cycle_Dir_bfs {

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

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

        int count = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            for (int nbr : adj.get(node)) {
                indegree[nbr]--;

                if (indegree[nbr] == 0) {
                    q.offer(nbr);
                }
            }
        }

        return count != V;
    }

    public static void main(String[] args) {

    }
}