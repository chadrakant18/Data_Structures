import java.util.*;
public class BFS{
    public static void bfs(ArrayList<ArrayList<Integer>> adj,int V){
        boolean vis[]=new boolean[V];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        vis[0]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            System.out.print(curr+" ");
            for(int it:adj.get(curr)){
                if(!vis[it]){
                    vis[it]=true;
                    q.add(it);
                }
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

        bfs(adj, V);
    }
}
