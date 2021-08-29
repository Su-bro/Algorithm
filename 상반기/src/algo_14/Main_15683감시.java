package algo_14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15683감시 {
	static class Info{
		int y,x,type;
		private Info(int y, int x, int type) {
			super();
			this.y = y;
			this.x = x;
			this.type = type;
		}		
	}
	static int N,M,dy[]= {-1,0,1,0},dx[]= {0,1,0,-1};
	static int ans = Integer.MAX_VALUE;
	static ArrayList<Info> list = new ArrayList<Info>();
	static ArrayList<Info> five = new ArrayList<Info>();
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/algo_14/감시.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>=1 && map[i][j]<5) {
					list.add(new Info(i, j, map[i][j]));
				}
				else if(map[i][j] == 5) {
					five.add(new Info(i, j, 5));
				}
			}
		}
		CCTV5(map);
//		print(map);
		dfs(map,0);
		System.out.println(ans);
	}
	private static void dfs(int[][] map, int idx) {
		if(idx == list.size()) {
			print(map);
			int cnt = countZero(map);
			ans = Math.min(ans, cnt);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			if(list.get(idx).type == 2 && d >1) {
				break;
			}
			int[][] copy = deepCopy(map);
			mark(list.get(idx),d,map);
			dfs(map,idx+1);
			map = copy;
		}
	}
	
	private static int countZero(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j]==0) cnt++;
			}
		}

		return cnt;
	}
	private static void mark(Info info, int d, int[][] map) {
		switch (info.type) {
		case 1:
			go(info.y,info.x,d,map);
			break;
		case 2:
			go(info.y,info.x,d,map);
			go(info.y,info.x,(d+2)%4,map);
			break;
		case 3:
			go(info.y,info.x,d,map);
			go(info.y,info.x,(d+1)%4,map);
			break;
		case 4:
			go(info.y,info.x,d,map);
			go(info.y,info.x,(d+1)%4,map);
			go(info.y,info.x,(d+3)%4,map);
			break;
		}
	}
	private static void CCTV5(int[][] map) {
		for(Info flist : five) {
			for (int i = 0; i < 4; i++) {
				go(flist.y,flist.x,i,map);
			}
		}
	}
	private static void go(int y, int x, int d, int[][] map) {
		int ny = y+dy[d];
		int nx = x+dx[d];
		while(isable(ny,nx,map)) {
			map[ny][nx] = '#';
			ny+=dy[d];
			nx+=dx[d];
		}
	}
	private static boolean isable(int ny, int nx, int[][] map) {
		if(ny<0 || nx <0 || ny >= N || nx >= M || map[ny][nx]==6) {
			return false;
		}		
		return true;
	}
	
	private static int[][] deepCopy(int[][] original) {
        if(original == null) return null;
        int[][] result = new int[original.length][original[0].length];
         
        for(int i=0; i<original.length; i++){
            System.arraycopy(original[i], 0, result[i], 0, original[0].length);
        }
         
        return result;
    }
	
	
	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j] == 35) 
					System.out.print("#"+" ");				
				else
					System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

}
