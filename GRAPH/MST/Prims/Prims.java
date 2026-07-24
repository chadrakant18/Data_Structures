package MST.Prims;

import java.util.*;

public class Prims {

    static class Pair {
        int node;
        int wt;

        Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    public static int prims(int V, ArrayList<ArrayList<Pair>> adj) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);

        boolean[] vis = new boolean[V];

        pq.offer(new Pair(0, 0));

        int sum = 0;

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            int wt = curr.wt;

            if (vis[node]) {
                continue;
            }

            vis[node] = true;
            sum += wt;

            for (Pair it : adj.get(node)) {

                if (!vis[it.node]) {
                    pq.offer(new Pair(it.node, it.wt));
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter edges (u v weight):");

        for (int i = 0; i < E; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        int ans = prims(V, adj);

        System.out.println("Minimum Spanning Tree Weight = " + ans);

        sc.close();
    }
}