import java.util.*;
public class DFS{
    public static void dfs(int node,ArrayList<ArrayList<Integer>> adj,int V, boolean vis[]){
        vis[node]=true;
        System.out.print(node+" ");
            for(int it:adj.get(node)){
                if(!vis[it]){
                    dfs(it,adj,V,vis);
                }
            }
        }
    public static void main(String[] args) {

        int V = 4;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(2).add(3);
        boolean vis[]=new boolean[V];
        dfs(0,adj, V,vis);
    }
}
