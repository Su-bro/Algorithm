package algo_13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main_7576토마토 {
	static class Tomato{
		int y;
		int x;
		int depth;
		public Tomato(int y, int x, int depth) {
			this.y = y;
			this.x = x;
			this.depth = depth;
		}	
	}
	static int N,M,map[][],dy[] = {-1,1,0,0},dx[]= {0,0,1,-1},ans;	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/algo_13/토마토.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		Queue<Tomato> q = new LinkedList<Tomato>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					q.add(new Tomato(i,j,0));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Tomato now = q.poll();
			int y = now.y;
			int x = now.x;
			int depth = now.depth;
			if(depth>ans) {
				ans = depth;
			}
			for (int d = 0; d < 4; d++) {
				int ny = y+dy[d];
				int nx = x+dx[d];
				if(ny<0 || nx<0 || ny>=N || nx>=M) continue;
				if(map[ny][nx]==0) {
					map[ny][nx] = 1;
					q.add(new Tomato(ny, nx, (depth+1)));
				}
			}			
		}		
		check();		
		System.out.println(ans);		
	}
	private static void check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) ans = -1;
			}
		}
		
	}

}
