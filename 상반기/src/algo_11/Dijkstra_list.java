package algo_11;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra_list {
	static class Edge{
		int e,w;
		Edge(int e,int w){
			this.e=e;
			this.w=w;
		}
	}
	static int V,E,Ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner("7 11\n" 
				+ "0 1 31\r\n" + "0 2 31\r\n" + "0 6 31\r\n" 
				+ "0 5 60\r\n" + "1 2 21\r\n" + "2 4 46\r\n" 
				+ "2 6 25\r\n" + "3 4 34\r\n" + "4 6 51\r\n" 
				+ "5 3 18\r\n" + "5 4 40\r\n");
		V=sc.nextInt();
		E=sc.nextInt();
		
		ArrayList<Edge>[]adj=new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i]=new ArrayList<Edge>();
		}
		
		for (int i = 0; i < E; i++) {
			int s=sc.nextInt();
			int e=sc.nextInt();
			int w=sc.nextInt();
			// dijkstra 는 단방향이면되 
			adj[s].add(new Edge(e,w));
		}
		
		//print(adj);
		int[]vertex=new int[V];
		boolean[]v=new boolean[V];
		Arrays.fill(vertex, Integer.MAX_VALUE);
		vertex[0]=0;
		for (int cnt = 0; cnt < V-1; cnt++) {
			int minV=-1;
			int minD=Integer.MAX_VALUE;
			for (int i = 0; i < vertex.length; i++) {
				if(!v[i]&&minD>vertex[i]) {
					minV=i;
					minD=vertex[i];
				}
			}
			//System.out.println(minV);
			//System.out.println(Arrays.toString(vertex)+" "+minV);
			v[minV]=true;
			//System.out.println(adj[minV].size());
			for (int i = 0; i < adj[minV].size(); i++) {
				Edge edge = adj[minV].get(i);
				if(vertex[edge.e]>adj[minV].get(i).w+vertex[minV]&&!v[edge.e]) {
					vertex[edge.e]=adj[minV].get(i).w+vertex[minV];
				}
			}
			//System.out.println(Arrays.toString(vertex));
			
		}
		for (int i = 0; i < vertex.length; i++) {
			Ans += vertex[i];
		}
		System.out.println(Ans);
		
	}
	
	private static void print(int[][] adj) {
		for (int r = 0; r < adj.length; r++) {
			for (int c = 0; c < adj[r].length; c++) {
				System.out.print(adj[r][c]+ "\t");
			}
			System.out.println();
		}
	}

}
