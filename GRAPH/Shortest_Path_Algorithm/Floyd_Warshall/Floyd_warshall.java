package Shortest_Path_Algorithm.Floyd_Warshall;

import java.util.*;

public class Floyd_warshall {

    public static void floydWarshall(int[][] dist, int V) {

        for (int k = 0; k < V; k++) {

            for (int i = 0; i < V; i++) {

                for (int j = 0; j < V; j++) {

                    if (dist[i][k] != Integer.MAX_VALUE &&
                        dist[k][j] != Integer.MAX_VALUE &&
                        dist[i][j] > dist[i][k] + dist[k][j]) {

                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Negative Cycle Check
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                System.out.println("Negative Weight Cycle Exists");
                return;
            }
        }

        System.out.println("\nShortest Distance Matrix:");

        for (int i = 0; i < V; i++) {

            for (int j = 0; j < V; j++) {

                if (dist[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        int[][] dist = new int[V][V];

        System.out.println("Enter the adjacency matrix:");
        System.out.println("Use 99999 for INF");

        for (int i = 0; i < V; i++) {

            for (int j = 0; j < V; j++) {

                dist[i][j] = sc.nextInt();

                if (dist[i][j] == 99999) {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        floydWarshall(dist, V);

        sc.close();
    }
}