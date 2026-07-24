package MST.KruskalAlgo;

import java.util.*;

public class Kruskal {

    static class Edge {
        int u;
        int v;
        int wt;

        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    static int[] parent;
    static int[] size;

    static void makeSet(int V) {

        parent = new int[V];
        size = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    static int findParent(int node) {

        if (parent[node] == node) {
            return node;
        }

        return parent[node] = findParent(parent[node]);
    }

    static void union(int u, int v) {

        u = findParent(u);
        v = findParent(v);

        if (u == v) {
            return;
        }

        if (size[u] < size[v]) {

            parent[u] = v;
            size[v] += size[u];

        } else {

            parent[v] = u;
            size[u] += size[v];
        }
    }

    public static int kruskal(int V, ArrayList<Edge> edges) {

        Collections.sort(edges, (a, b) -> a.wt - b.wt);

        makeSet(V);

        int mstWeight = 0;

        for (Edge e : edges) {

            int u = e.u;
            int v = e.v;
            int wt = e.wt;

            if (findParent(u) != findParent(v)) {

                mstWeight += wt;
                union(u, v);
            }
        }

        return mstWeight;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        ArrayList<Edge> edges = new ArrayList<>();

        System.out.println("Enter edges (u v weight):");

        for (int i = 0; i < E; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();

            edges.add(new Edge(u, v, wt));
        }

        int ans = kruskal(V, edges);

        System.out.println("Weight of MST = " + ans);

        sc.close();
    }
}