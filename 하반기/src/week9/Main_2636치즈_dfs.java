package week9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2636치즈_dfs {
	static boolean[][] v;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("치즈.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];		
		for(int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < map[0].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < map.length; i++) {
			map[i][0]=2;
			map[i][m-1]=2;
		}
		for(int i = 0; i < map[0].length; i++) {
			map[0][i]=2;
			map[n-1][i]=2;
		}
		
		v = new boolean[n][m];
		airize(0,0,map);
		
		//print(map);
		
		
		int min = 0;
		boolean check = true;
		int time = 0;
		while(check) {
			int cnt=0;
			time++;
			check = false;
			for(int i = 1; i < map.length-1; i++) {
				for(int j = 1; j < map[0].length-1; j++) {
					if(map[i][j]==1) {
						check = true;
						cnt++;
						
						aircheck(i,j,map);		
					}
				}
			}
			if(cnt!=0)min=cnt;
			if(!check) {
				System.out.println(time-1);
				System.out.println(min);
				System.exit(0);
			}
			v = new boolean[n][m];
			airize(0,0,map);
			//print(map);
			//System.out.println("===================");
		}
		
		
	}
	private static void airize(int y, int x, int[][] map) {
		v[y][x] = true;
		map[y][x] = 2;
		
		for(int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if (nx < 0 || ny < 0 || nx >= map[0].length || ny >= map.length) continue;
			if (v[ny][nx] || map[ny][nx]==1 ) continue;
				map[ny][nx]=2;
				airize(ny, nx, map);
			
		}
	}
	
	
	private static void melt(int[][] map) {
		for(int i = 1; i < map.length-1; i++) {
			for(int j = 1; j < map[0].length-1; j++) {
				if(map[i][j]==3) map[i][j]=2;				
			}
		}
	}
	private static void aircheck(int y, int x, int[][] map) {	
		
		for(int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(map[ny][nx]==2) {				
				map[y][x]=3;				
			}			
		}		
		
	}
	
	private static void print(int[][] map) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				System.out.printf("%d ",map[i][j]);
			}
			System.out.println();
		}
		
	}

}
