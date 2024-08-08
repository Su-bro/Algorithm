package week11;

import java.util.*;
import java.io.*;
public class Main_1520_내리막길 {
	static int map[][],N,M,cnt,dy[]= {-1,1,0,0},dx[]= {0,0,-1,1},dp[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/week11/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		dfs(0,0);
		System.out.println(dp[N-1][M-1]);
	}
	private static int dfs(int y, int x) {		
		if(y == N-1 && x == M-1) {
			return 1;
		}
		if(dp[y][x] != -1) {
			return dp[y][x];
		}
		else {
			dp[y][x] = 0;
			for(int d = 0; d<4; d++) {
				int ny = y+dy[d];
				int nx = x+dx[d];
				if(ny<0 || nx<0 || ny>=N || nx>=M) continue;
				if(map[ny][nx] < map[y][x]) {
					dp[y][x] += dfs(ny,nx);
				}
			}
		}
		return dp[y][x];
	}
}
