package algo_11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16929TwoDots {
	static int[][] map;
	static int N,M;	
	static boolean flag;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int startY, startX;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/algo_11/투다츠.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();		
			for (int j = 0; j < M; j++) {
				map[i][j] = c[j];
			}
		}
		flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				startY = i;
				startX = j;
				if(dfs(i,j,new boolean[N][M],map[i][j],1)) {
					System.out.println("Yes");
					return;
				}
			}
		}
		
		if(!flag) System.out.println("No");
		
	}
	private static boolean dfs(int y, int x, boolean[][] v, int num,int k) {
		if(flag==true) return true;
		
		v[y][x] = true;
		
		for (int d = 0; d < 4; d++) {
			int ny = y+dy[d];
			int nx = x+dx[d];
			if(ny<0 || nx<0 || ny>=N || nx>=M) continue;
			if(ny==startY && nx==startX && k>=4) {
				//System.out.println("Yes");
				flag=true;
				//System.exit(0);
			}
			if(map[ny][nx]==num && !v[ny][nx]) {				
				dfs(ny, nx, v, num,k+1);
				v[ny][nx]= false;
				
			}
		}
		
		return false;
	}
	
	
	private static void print(boolean[][] arr) {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println("-----------------------------------------");
	}

}
