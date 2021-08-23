package algo_14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14938서강2 {
	/*
	max length
	Arraylist<Edge>[] list = new Arraylist[6];
	index|Edge[now,next,weight]
	0	 |null
	1	 |[1,4,5][1,2,3]
	2	 |[2,4,2],[2,3,3][2,1,3]
	3	 |[3,2,3]
	4	 |[4,1,5]
	5	 |[5,2,4]	
	[Edge [now=1, next=4, weight=5], Edge [now=1, next=2, weight=3]]
	[Edge [now=2, next=5, weight=4], Edge [now=2, next=3, weight=3], Edge [now=2, next=1, weight=3]]
	[Edge [now=3, next=2, weight=3]]
	[Edge [now=4, next=1, weight=5]]
	[Edge [now=5, next=2, weight=4]]
	
	int[6] node [0,5,7,8,2,3]
	boolean v[6]
	for i in 1~n+1:
		bfs(i)
	
	*/
	static class Edge{
		int now,next,weight;

		private Edge(int now, int next, int weight) {
			super();
			this.now = now;
			this.next = next;
			this.weight = weight;
		}		
	}
	static class Info implements Comparable<Info>{
		int now, weight;
		private Info(int now, int weight) {
			this.now = now;
			this.weight = weight;
		}
		@Override
		public int compareTo(Info o) {
			// TODO Auto-generated method stub
			return weight-o.weight;
		}		
	}
	static int n,m,r;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/algo_14/서강.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
	
		st = new StringTokenizer(br.readLine());
		int node[] = new int[n+1];		
		for (int i = 1; i < node.length; i++) {
			node[i] = Integer.parseInt(st.nextToken()); 
		}
		
		ArrayList<Edge>[] list = new ArrayList[n+1];
		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<Edge>();			
		}
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());			
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a1].add(new Edge(a1, a2, w));
			list[a2].add(new Edge(a2,a1,w));
		}
		
		
		int ans = 0;
		for (int i = 1; i < list.length; i++) { //모든 시작점에 대해서 bfs
			boolean[] v = new boolean[n+1];
			int item = 0;
			PriorityQueue<Info> q = new PriorityQueue<Info>();
			q.add(new Info(i, 0));
			v[i] = true;
			item+=node[i];
			while(!q.isEmpty()) {
				Info temp = q.poll();
				int now = temp.now;
				int weight = temp.weight;
				
				
				for(Edge e : list[now]) {
					//다음 가려는곳의거리 + 지금까지온거리가 r보다 크다면 안가
					//다음 가려는곳이 이미 들린곳이면 안가.
					if(e.weight+weight > r || v[e.next]) continue;
					q.add(new Info(e.next, weight+e.weight));
					item+=node[e.next];
					v[e.next] = true;
//					System.out.println("넣었다 :"+new Info(e.next, weight+e.weight, item+node[e.next]));
				}
			}
			System.out.println(item);
			ans = Math.max(ans, item);
			
		}
		System.out.println(ans);
		
	}

}
