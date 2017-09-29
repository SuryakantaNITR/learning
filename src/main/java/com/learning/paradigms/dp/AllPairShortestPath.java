package com.learning.paradigms.dp;

public class AllPairShortestPath {
	public static final int INF = Integer.MAX_VALUE;
	
	public void floydWarshall(int[][] graph) {
		int n = graph.length;
		int m = graph[0].length;
		
		int[][] dist = new int[n][m];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				dist[i][j] = graph[i][j];
		
		for(int k=0;k<Math.min(n, m);k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(dist[i][k] != INF && dist[k][j] != INF && dist[i][j] > dist[i][k] + dist[k][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}
		printSolution(dist, n, m);
	}
	public void printSolution(int[][] graph, int n, int m) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(graph[i][j] != INF)
					System.out.print(graph[i][j] + " ");
				else
					System.out.print("INF" + " ");
			}
				
			System.out.println(" ");
		}
	}
	public static void main(String[] args) {
		/* Let us create the following weighted graph
        10
     (0)------->(3)
     |         /|\
     5 |          |
     |          | 1
     \|/         |
     (1)------->(2)
        3           */
     int graph[][] = { {0,   5,  INF, 10},
                       {INF, 0,   3, INF},
                       {INF, INF, 0,   1},
                       {INF, INF, INF, 0}
                     };
     AllPairShortestPath a = new AllPairShortestPath();

     // Print the solution
     a.floydWarshall(graph);
	}
}
