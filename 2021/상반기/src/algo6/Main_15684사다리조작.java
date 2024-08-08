package algo6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15684사다리조작 {
	static int N,M,H,cnt;
	static int[][] map;
	static boolean check = false;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("사다리.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H+1][N+1];		

		for(int i = 0; i < M; i++) {
			st= new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());         
			int c = Integer.parseInt(st.nextToken());
			map[r][c]=1;
			map[r][c+1]=2;
		}
		//print();
		
		for(int i = 0; i<=3; i++) {
			cnt = i;
			dfs(1,0);
			if(check==true) break;
		}
		if(check==true) {
			System.out.println(cnt);
		}else System.out.println(-1);
		
		
		
	}
	private static void dfs(int idx, int k) {
		if(check==true) return;
		if(cnt == k) {
			if(v()==true) check=true;
			return;
		}
		
		for(int i = idx; i < H+1; i++) {
			for(int j = 1; j < N; j++) {
				if(map[i][j] == 0 && map[i][j+1] == 0) {
					map[i][j] = 1;
					map[i][j+1]=2;
					dfs(i,k+1);
					map[i][j] = 0;
					map[i][j+1] = 0;
					
				}
				
			}
		}
		
	}
	private static boolean v() {
		for(int i = 1; i <= N; i++) {
			int x = 1, y = i;
			for(int j = 0; j < H; j++) {
				if(map[x][y] == 1) y++;
				else if(map[x][y] == 2) y--;
				x++;
			}
			if(y!=i) return false;					
		}
		return true;
	}
	
	private static void print() {
		for(int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
	}
	
}
