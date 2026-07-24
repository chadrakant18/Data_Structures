import java.util.*;

public class unit_weight_undirected {

    public static int[] shortestPath(int[][] edges, int n, int m, int src) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] dist = new int[n];

        Arrays.fill(dist, (int)1e9);

        Queue<Integer> q = new LinkedList<>();

        dist[src] = 0;
        q.offer(src);

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int nbr : adj.get(node)) {

                if (dist[node] + 1 < dist[nbr]) {

                    dist[nbr] = dist[node] + 1;

                    q.offer(nbr);
                }
            }
        }

        for (int i = 0; i < n; i++) {

            if (dist[i] == (int)1e9) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        int n = 4;
        int m = 4;

        int[][] edges = {
                {0,1},
                {0,2},
                {1,3},
                {2,3}
        };

        int src = 0;

        int[] ans = shortestPath(edges,n,m,src);

        System.out.println(Arrays.toString(ans));
    }
}