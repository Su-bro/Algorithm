package algo_13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7699수지의수지맞는여행 {
	static int map[][], dy[] = {-1,1,0,0},dx[]= {0,0,1,-1},ans,N,M;
	static boolean v[];
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/algo_13/수지.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				char c[] = br.readLine().toCharArray();	
				for (int j = 0; j < M; j++) {
					map[i][j] = c[j];
				}
			}
			
			v = new boolean[26];
			v[map[0][0]-65] = true;
			dfs(0,0,1);			
			System.out.println("#"+tc+" "+ans);
		}		
	}
	private static void dfs(int y, int x,int k) {
		ans = Math.max(ans, k);
		for (int d = 0; d < 4; d++) {
			int ny = y+dy[d];
			int nx = x+dx[d];
			if(ny<0 || nx<0 || ny>=N || nx>=M || v[map[ny][nx]-65]) continue;			
			v[map[ny][nx]-65] = true;
			dfs(ny, nx, k+1);			
			v[map[ny][nx]-65] = false;
		}
	}

}
