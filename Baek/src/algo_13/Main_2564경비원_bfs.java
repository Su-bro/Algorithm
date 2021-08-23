package algo_13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs버전
public class Main_2564경비원_bfs {	
	static int M,N,K,map[][],start[],dy[]= {-1,1,0,0},dx[]= {0,0,-1,1},ans,min;
	static Queue<int[]> q;
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/algo_13/경비원.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
//		System.out.println(N+" "+M+" "+K);
		start = new int[2];
		map = new int[N+1][M+1];
		for (int i = 0; i < N+1; i++) {
			map[i][0] = 1;
			map[i][M] = 1;
		}
		
		for (int i = 0; i < M+1; i++) {
			map[0][i] = 1;
			map[N][i] = 1;
		}
		
		for (int i = 0; i < K+1; i++) {
			st = new StringTokenizer(br.readLine());
			int cdn = Integer.parseInt(st.nextToken());
			int loc = Integer.parseInt(st.nextToken());
			switch (cdn) {
			case 1:
				map[0][loc] = i+2;
				if(i==K) {
					start[0] = 0;
					start[1] = loc;							
				}
				break;
			case 2:
				map[N][loc] = i+2;
				if(i==K) {
					start[0] = N;
					start[1] = loc;							
				}
				break;
			case 3:
				map[loc][0] = i+2;
				if(i==K) {
					start[0] = loc;
					start[1] = 0;							
				}
				break;
			case 4:
				map[loc][M] = i+2;
				if(i==K) {
					start[0] = loc;
					start[1] = M;							
				}
				break;

			}
			
		}
		
//		print(map);
		
		for (int i = 0; i < K; i++) {
			min = Integer.MAX_VALUE;
			v = new boolean[N+1][M+1];
			q = new LinkedList<int[]>();
			q.add(new int[] {start[0],start[1],0});
			
			while(!q.isEmpty()) {
				int[] now = q.poll();
				int y = now[0];
				int x = now[1];
				v[y][x] = true;
				int dist = now[2];
				
				if(map[y][x] == i+2) {
					min = Math.min(min, dist);
					break;
				}				
				for (int d = 0; d < 4; d++) {
					int ny = y+dy[d];
					int nx = x+dx[d];
					if(ny<0 || nx<0 || ny>N || nx>M || v[ny][nx] || map[ny][nx]==0) continue;
					q.add(new int[] {ny,nx,dist+1});
					
				}
			}			
			ans+=min;
//			System.out.println(i+2+"번 가게에 가는 최소거리는:"+min);
		}
		System.out.println(ans);
		
	}

	private static void print(int[][] map2) {
		for (int i = 0; i < map2.length; i++) {
			System.out.println(Arrays.toString(map2[i]));
		}
		
	}

}
