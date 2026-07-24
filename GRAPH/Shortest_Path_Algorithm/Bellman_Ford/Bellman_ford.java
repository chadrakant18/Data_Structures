package Shortest_Path_Algorithm.Bellman_Ford;
import java.util.*;

public class Bellman_ford {
    static class Pair{
        int u;
        int wt;
        Pair(int u,int wt){
            this.u=u;
            this.wt=wt;
        }
    }
    public static int[] bellmanFord(int V,int edges[][]){
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int e[]:edges){
            int u=e[0];
            int v=e[1];
            int wt=e[2];
            adj.get(u).add(new Pair(v,wt));
        }
        int dist[]=new int[V];
        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[0]=0;
        for(int i=0;i<V-1;i++){
            for(int e[]:edges){
                int u=e[0];
                int v=e[1];
                int wt=e[2];
                    if(dist[u]!=Integer.MAX_VALUE&&dist[v]>dist[u]+wt){
                        dist[v]=dist[u]+wt;
                    }
                }
        }
         for(int e[]:edges){
                int u=e[0];
                int v=e[1];
                int wt=e[2];
                    if(dist[u]!=Integer.MAX_VALUE&&dist[v]>dist[u]+wt){
                        System.out.println("Negative Cycle");
                        return new int[]{-1};
                    }
                }
        return dist;
    }
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of vertices: ");
    int V = sc.nextInt();

    System.out.print("Enter number of edges: ");
    int E = sc.nextInt();

    int[][] edges = new int[E][3];

    System.out.println("Enter edges (u v weight):");

    for (int i = 0; i < E; i++) {
        edges[i][0] = sc.nextInt(); // source
        edges[i][1] = sc.nextInt(); // destination
        edges[i][2] = sc.nextInt(); // weight
    }

    int[] ans = bellmanFord(V, edges);

    if (ans.length == 1 && ans[0] == -1) {
        System.out.println("Negative Weight Cycle Detected");
    } else {
        System.out.println("Shortest distances from source 0:");
        for (int i = 0; i < V; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                System.out.println(i + " -> INF");
            } else {
                System.out.println(i + " -> " + ans[i]);
            }
        }
    }

    sc.close();
}
}