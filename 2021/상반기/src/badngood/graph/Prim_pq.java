package badngood.graph;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim_pq {
	/*
	 * Prim 와 cruskal 은 mst를 만드는 알고리즘 
	 * prim은 PQ를 cruskal은 union-find를 이용한다
	 * prim은 vertex수 만큼  ArrayList[]를 만들고
	 * 해당vertex 의 edge 정보를저장하여 PQ에 넣는다
	 */
	static int T,V,E;
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
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("최소신장트리.txt"));
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			V=sc.nextInt();
			E=sc.nextInt();
			ArrayList<Edge>[] adj = new ArrayList[V];
			for (int i = 0; i < adj.length; i++) {
				adj[i]=new ArrayList();
			}
			for (int i = 0; i < E; i++) {
				int is=sc.nextInt();
				int id=sc.nextInt();
				int ic=sc.nextInt();
				adj[is].add(new Edge(id,ic));
				adj[id].add(new Edge(is,ic));
			}
			boolean[]visited=new boolean[V];
			PriorityQueue<Edge>pq=new PriorityQueue<>();
			visited[0]=true;
			pq.addAll(adj[0]);
			int cnt=1;
			int ans=0;
			ArrayList<Edge>log=new ArrayList();
			while(cnt<V) {
				Edge pe = pq.poll();
				
				if(!visited[pe.dest]) {
					visited[pe.dest]=true;
					log.add(pe);
					ans+=pe.cost;
					pq.addAll(adj[pe.dest]);
					cnt++;
				}
			}
			System.out.println(ans);
			for (int i = 0; i < log.size(); i++) {
				System.out.println(log.get(i));
			}
			
		}
		//System.out.println("111");
		
	}

}








