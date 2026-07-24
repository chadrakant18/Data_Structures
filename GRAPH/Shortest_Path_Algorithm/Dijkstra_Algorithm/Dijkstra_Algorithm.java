import java.util.*;

public class Dijkstra_Algorithm {

    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static int[] dijkstra(int V,
                                 ArrayList<ArrayList<Pair>> adj,
                                 int src) {

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.dist - b.dist);

        int[] dist = new int[V];

        Arrays.fill(dist, (int)1e9);

        dist[src] = 0;

        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            int dis = curr.dist;

            for (Pair nbr : adj.get(node)) {

                int adjNode = nbr.node;
                int edgeWeight = nbr.dist;

                if (dis + edgeWeight < dist[adjNode]) {

                    dist[adjNode] = dis + edgeWeight;

                    pq.offer(new Pair(adjNode,
                                      dist[adjNode]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {

    }
}