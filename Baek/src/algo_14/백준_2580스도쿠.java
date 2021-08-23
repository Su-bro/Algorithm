package algo_14;

import java.util.*;
import java.io.*;

public class 백준_2580스도쿠 {
	
	static ArrayList<int[]> list = new ArrayList<>();
	static int map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		map = new int[9][9];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) list.add(new int[] {i,j});
			}
		}
		
		if(!isDone(map)) dfs(map, 0);
		
	}
	
	public static void dfs(int[][] map, int idx) {
		if(idx==list.size()) {
			if(isDone(map)) {
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[0].length; j++) {
						System.out.print(map[i][j] + " ");
					}
					System.out.println();
				}
				System.exit(0);
			}
			return;
		}
		
		int[] cur = list.get(idx);
		
		int[] check = new int[10];
		for (int i = 0; i < 9; i++) {
			if(map[i][cur[1]]>0) check[(map[i][cur[1]])]+=1;
		}
		for (int j = 0; j < 9; j++) {
			if(map[cur[0]][j]>0) check[(map[cur[0]][j])]+=1;
		}
		for (int i = (cur[0]/3)*3; i < (cur[0]/3)*3+3; i++) {
			for (int j = (cur[1]/3)*3; j < (cur[1]/3)*3+3; j++) {
				if(map[i][j]>0) check[map[i][j]]+=1;
			}
		}
		
		for (int i = 1; i <= 9; i++) {
			if(check[i]==0) {
				map[cur[0]][cur[1]] = i;
				dfs(map, idx+1);
				map[cur[0]][cur[1]] = 0;
			}
		}
		
	}

	public static boolean isDone(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j]==0) return false;
			}
		}
		return true;
	}
}
