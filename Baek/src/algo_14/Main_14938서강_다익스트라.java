package algo_14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14938서강_다익스트라 {
	
	static int n,m,r,graph[][];
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/algo_14/서강.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		graph = new int[n+1][n+1];
		st = new StringTokenizer(br.readLine());
		int node[] = new int[n+1];		
		for (int i = 1; i < node.length; i++) {
			node[i] = Integer.parseInt(st.nextToken()); 
		}
		
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());			
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[a1][a2] = w;
			graph[a2][a1] = w;			
		}
//		print(graph);
		int max = 0;
		for (int start = 1; start < n+1; start++) { //모든 시작점에대해서 다익스트라
			
			int[] dist = new int[n+1]; 
			boolean[] v = new boolean[n+1];			
			for (int i = 1; i <n+1 ; i++) {
				dist[i] = Integer.MAX_VALUE;
			}
			dist[start] = 0;
			v[start] = true;
			
			for (int i = 1; i < n+1; i++) {
				if(!v[i] && graph[start][i]!=0) {
					dist[i] = graph[start][i];
				}
			}
			
			for (int i = 0; i < n-1; i++) {
				int min = Integer.MAX_VALUE;
				int index = 0;
				
				for (int j = 1; j < n+1; j++) {
					if(!v[j] && dist[j]!=Integer.MAX_VALUE) {
						if(dist[j] < min) {
							min = dist[j];
							index = j;
						}
					}
				}
				
				v[index] = true;
				
				for (int j = 1; j < n+1; j++) {
					if(!v[j] && graph[index][j]!=0) {
						//최소거리 갱신
						if(dist[j]>dist[index] + graph[index][j]) {
							dist[j] = dist[index] + graph[index][j];
						}
					}
				}
			}
			
			for (int i = 1; i < n+1; i++) {
				int sum = 0;
				for (int j = 1; j < n+1; j++) {
					if(dist[j]<=m) sum+=node[j];
				}
//				System.out.println(sum);
				if(sum>=max) {
					max = sum;
				}
			}			
		}
		System.out.println(max);
	}

	private static void print(int[][] graph2) {
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				System.out.print(graph2[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
