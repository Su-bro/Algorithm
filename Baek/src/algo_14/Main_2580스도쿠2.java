package algo_14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2580스도쿠2 {
	static class Zero{
		int y,x;
		public Zero(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
	}
	static ArrayList<Zero> list;
	 
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/algo_14/스도쿠.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int map[][] = new int[9][9];
		list = new ArrayList<Zero>();
		for (int i = 0; i < 9; i++) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {//일단 입력할때 가로체크				
				map[i][j]  = Integer.parseInt(st.nextToken());
				if(map[i][j] ==0) {
					list.add(new Zero(i, j));
				}
			}
		}
		
		dfs(map,0);

	}
	
	private static void dfs(int[][] map, int idx) {
		if(idx==list.size()) {
			if(check(map)) {
				print(map);
				System.exit(0);
			}
			return;
		}
		int y = list.get(idx).y;
		int x = list.get(idx).x;
		
		boolean v[] = new boolean[10];
		
		//가로		
		for (int i = 0; i < 9; i++) {
			if(map[y][i]!=0) v[map[y][i]]=true;
		}
		//세로
		for (int i = 0; i < 9; i++) {
			if(map[i][x]!=0) v[map[i][x]] = true;
		}
		//블럭
		for (int i = (y/3)*3; i < (y/3)*3+3; i++) {
			for (int j = (x/3)*3; j < (x/3)*3+3; j++) {
				if(map[i][j]!=0) v[map[i][j]]=true;
			}
		}
		
		for (int i = 1; i < 10; i++) {
			if(!v[i]) {
				map[y][x] = i;
				dfs(map, idx+1);
				map[y][x] = 0;
			}
		}
		
		
	}

	private static boolean check(int[][] map) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(map[i][j] == 0) return false;
			}
		}
		
		return true;
	}

	
	private static void print(int[][] arr) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.printf("%1d ",arr[i][j]);
//				if((j+1)%3==0) System.out.print("|");
			}
//			if((i+1)%3==0) System.out.println();
			System.out.println();
		}
		
	}
	

}
