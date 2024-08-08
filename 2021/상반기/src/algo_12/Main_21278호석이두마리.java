package algo_12;

import java.io.*;
import java.util.*;

public class Main_21278호석이두마리 {
	
	static int c1,c2;	
	static ArrayList<Integer>[] list; //인접리스트
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/algo_12/호석이.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);					
		}
//		for (ArrayList<Integer> i : list) {
//			System.out.println(i);
//		}
		
		for (int i = 1; i < n+1; i++) {
			for (int j = i+1; j < n+1; j++) {
//				System.out.println(i+" "+j); //치킨집 하나씩 차려가면서
				int cnt = bfs(i,j);
				if(min>cnt) {
					min = cnt;
					c1 = i;
					c2 = j;
				}
			}
		}
		System.out.println(c1+" "+c2+" "+min*2);
		
	}
	private static int bfs(int c1, int c2) {
		int cnt = 0;		
		int adj = 0;
		int depth  = 1;
		boolean v[] = new boolean[list.length];
		Queue<ArrayList<Integer>> q = new LinkedList<ArrayList<Integer>>();
		q.add(list[c1]);
		q.add(list[c2]);
		int ckcnt=2;
		v[c1] = v[c2] = true;
		
		
		while(!q.isEmpty()) {
			ArrayList<Integer> next = q.poll();
			ckcnt++;
			
			for(int i : next) {
				if(!v[i]) { //방문하지않았다면
					q.add(list[i]);
					v[i] = true;
					cnt +=depth;
					adj++;
					
				}
			}
			if(ckcnt == 0) {
				ckcnt = adj;
				adj = 0;
				depth++;
			}
			
		}
		
		return cnt;
	}
}
