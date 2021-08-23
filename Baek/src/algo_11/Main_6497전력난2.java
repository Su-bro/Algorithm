package algo_11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6497전력난2 {
	static class Node implements Comparable<Node>{
		int from;
		int to;
		int w;		

		public Node(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}
		
		@Override
		public String toString() {
			return "Node [from=" + from + ", to=" + to + ", w=" + w + "]";
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return w - o.w;
		}		
	}
	
	static int m,n;
	static boolean[] v;
	static ArrayList<Node>[] list;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/algo_11/전력난.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			if(m==0 && n==0) break;
			
			list = new ArrayList[m];
	        v = new boolean[m];
	        int sum = 0;
	        for (int i = 0; i < m; i++) {
				list[i] = new ArrayList<>();
	        }
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				//System.out.println(from+","+to+","+w);
				list[from].add(new Node(from, to, w));
				list[to].add(new Node(to, from, w));
				sum += w;
			}
			for(ArrayList<Node> li : list) {
				System.out.println(li.toString());
			}
			
			int min = prim();
			System.out.println(sum-min);
		}
	}
		

	private static int prim() {
		int weight=0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Node> templist;
		Node temp;
		//0번노드부터 시작한다.
		q.add(0);
		while(!q.isEmpty()) {
			int c = q.poll();
			v[c] = true; //방문체크
			templist = list[c]; //해당인덱스의 줄기 저장
			
			for (int i = 0; i < templist.size(); i++) {
				if(!v[templist.get(i).to]) { //방문하지 않은 자식에 대해서
					pq.add(templist.get(i)); //가중치기준 우선순위큐 add
				}
			}
			
			while (!pq.isEmpty()) {
				temp = pq.poll(); //가중치가 가장 낮은녀석
				if(!v[temp.to]) { //그녀석의 자식을 방문하지않았다면
					v[temp.to]=true; //즉 방문하지않은 자식중,가중치가제일낮은녀석 방문
					weight+=temp.w; //그게 최소거리지
					q.add(temp.to); //큐에 넣어준다
					break;//성공하면 바로끝내기
				}
			}
			
		}
		return weight;
	}

}
