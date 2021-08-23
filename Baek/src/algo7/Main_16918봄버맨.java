package algo7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16918봄버맨 {
	static int R,C,N;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = { 0, 0, 1,-1};
	static Queue<int[]> q;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("봄버맨.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());		
		map = new int[R][C];		
		q = new LinkedList<int[]>();
		if(N%2==0) {
			printzero();
			System.exit(0);
		}
		for(int i = 0; i < R; i++) {
			char[] c  = br.readLine().toCharArray();
			for(int j = 0; j < C; j++) {
				map[i][j] = c[j];
			}
		}
		int time=1;
		while(true) {
			if(time==N) {
				print();
				break;
			}
			search();
			plant();
			time++;
			if(time==N) {
				print();
				break;
			}
			bom();
			time++;
			if(time==N) {
				print();
				break;
			}
			
		}


		
		

	}
	
	private static void plant() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {				
				if(map[i][j]=='.')map[i][j]='O';				
			}
		}
		
	}
	
	private static void search() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {				
				if(map[i][j]=='O')q.add(new int[] {i,j});				
			}
		}
	}
	
	
	
	private static void bom() {
		while(!q.isEmpty()) {
			int[] target = q.poll();
			int y = target[0];
			int x = target[1];
			map[y][x] = '.';
			for(int d = 0; d < 4; d++) {
				int ny = y+dy[d];
				int nx = x+dx[d];
				if(ny>=0&&nx>=0&&ny<R&&nx<C&&map[ny][nx]=='O') {
					
					map[ny][nx]='.';
				}
			}
		}
	}
	
	private static void print() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				System.out.print((char)map[i][j]);
			}
			if(i<R-1)System.out.println();
		}
		
	}
	
	private static void printzero() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				System.out.print('O');
			}
			System.out.println();
		}
	}
}
