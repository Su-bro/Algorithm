package algo_11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_6497전력난 {
	static class Edge implements Comparable<Edge>{
		int dest,cost;
		public Edge(int dest,int cost) {
			this.dest=dest;
			this.cost=cost;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return cost-o.cost;
		}
		@Override
		public String toString() {
			return "Edge [dest=" + dest + ", cost=" + cost + "]";
		}
		
	}
	
	static int T,V,E;
	static boolean[] v;
	static ArrayList<Edge>[] adj;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/algo_11/전력난.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			if(V==0 && E==0) break;
			
			adj = new ArrayList[V];
	        v = new boolean[V];
	        int sum = 0;
	        for (int i = 0; i < V; i++) {
	        	adj[i]=new ArrayList();
	        }
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				//System.out.println(from+","+to+","+w);
				adj[from].add(new Edge(to,w));
				adj[to].add(new Edge(from,w));
				sum += w;
			}
	//		for(ArrayList<Node> li : list) {
	//			System.out.println(li.toString());
	//		}
			
			int min = prim_pq();
			System.out.println(sum-min);
		}
	}
		

	private static int prim_pq() {
		int ans=0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		v[0]=true;
		pq.addAll(adj[0]);
		ArrayList<Edge>log=new ArrayList();
		int cnt = 1;
		while(cnt<V) {
			Edge pe = pq.poll();			
			if(!v[pe.dest]) {
				v[pe.dest]=true;
				log.add(pe);
				ans+=pe.cost;
				pq.addAll(adj[pe.dest]);
				cnt++;
			}
		}		
		return ans;
	}

}
