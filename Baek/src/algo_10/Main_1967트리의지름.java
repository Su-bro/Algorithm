package algo_10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1967트리의지름 {
	static class Node{
		int from;
		int next;
		int w;
		public Node(int from, int next, int w) {
			super();
			this.from = from;
			this.next = next;
			this.w = w;
		}
		
	}
	static Node[] tree;
	static int n;
	static int max=0;
	static int maxNode;
//	static int farNode;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("트리의지름.txt"));
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		tree = new Node[n-1];
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			//tree.add(new Node(from, next, w));
			tree[i]= new Node(from, next, w);
		}
		//1번노드에서 제일 멀리 있는녀석 찾아보자
		dfs(1, new boolean[n+1],0);
		//System.out.println(max+","+maxNode);
		
		//maxNode = 제일멀리있는노드
		
		max = 0;
		
		//제일 멀리있는놈 기준으로 제일 멀리있는놈 찾아보자
		//dfs2(maxNode, new boolean[n+1],0);
		dfs2(maxNode, new boolean[n+1],0);
		//System.out.println(max+","+farNode);
		
		System.out.println(max);
			
	}

	private static void dfs2(int i, boolean[] v, int dist) {
		if(dist>max) {
			max = dist;
			//farNode = i;
		}
		v[i] = true;
		for(Node node : tree) {
			if(node.next == i && !v[node.from]) {
				v[node.from]=true;
				dfs2(node.from,v,dist+node.w);
			}
			if(node.from ==i && !v[node.next]) {
				v[node.next]=true;				
				dfs2(node.next, v, dist+node.w);
				v[node.next]=false;
			}
		}
		
	}

	private static void dfs(int i, boolean[] v,int dist) {
		if(dist>max) {
			max = dist;
			maxNode = i; //제일 멀리있는 노드
		}
		v[i] = true;
		for(Node node : tree) {
			if(node.from ==i && !v[node.next]) {
				v[node.next]=true;				
				dfs(node.next, v, dist+node.w);
				v[node.next]=false;
			}
		}
	}
}
