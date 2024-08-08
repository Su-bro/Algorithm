package week13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2564경비원_dfs {	
	static int M,N,K,map[][],start[],dy[]= {-1,1,0,0},dx[]= {0,0,-1,1},ans,min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
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
		
		print(map);
		
		for (int i = 0; i < K; i++) {
			min = Integer.MAX_VALUE;
			dfs(start[0],start[1],0,new boolean[N+1][M+1],i+2);
			ans+=min;
		}
		System.out.println(ans);
		
	}
	
	private static void dfs(int y, int x, int dist, boolean[][] v, int end) {
		if(map[y][x] == end) {
			min = Math.min(min, dist);
			return;
		}		
		v[y][x] = true;
		
		for (int d = 0; d < 4; d++) {
			int ny = y+dy[d];
			int nx = x+dx[d];
			if(ny<0 || nx<0 || ny>N || nx>M || v[ny][nx] || map[ny][nx]==0) continue;
			
			dfs(ny, nx, dist+1, v, end);
			
		}
		
		
		
	}

	private static void print(int[][] map2) {
		for (int i = 0; i < map2.length; i++) {
			System.out.println(Arrays.toString(map2[i]));
		}
		
	}

}
