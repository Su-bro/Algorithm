package algo_14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2580스도쿠 {
	static int map[][] = new int[9][9];
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/algo_14/스도쿠.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		for (int i = 0; i < 9; i++) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean[] v = new boolean[10];
			int cnt = 0;
			int idx = 0;
			for (int j = 0; j < 9; j++) {//일단 입력할때 가로체크				
				int s = Integer.parseInt(st.nextToken());
				
				if(s == 0) {
					cnt++;
					idx = j;
				}
				map[i][j] = s;
				v[s] = true;
			}
			if(cnt==1) {
				for (int j = 1; j < 10; j++) {
					if(!v[j]) map[i][idx] = j;
				}
			}
		}
//		print(map);
//		System.out.println("================================");
//		vertical();
		
//		print(map);
//		System.out.println("================================");		
//		block();
		
//		horizon();
		
		while(!check()) {
			vertical();
			block();
			horizon();
		}
		
		print(map);
//		System.out.println("================================");
	}
	
	private static boolean check() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(map[i][j] == 0) return false;
			}
		}
		
		return true;
	}
	private static void block() {
		for (int i = 0; i < 3; i++) { // 
			for (int j = 0; j < 3; j++) {
				boolean[] v = new boolean[10];
				int cnt = 0;
				int[] idx = new int[2];
				for (int y = i*3; y < (i+1)*3; y++) {
					for (int x = j*3; x < (j+1)*3; x++) {
//						System.out.print(map[y][x]+" ");
						if(map[y][x]==0) {
							cnt++;
							idx[0] = y;
							idx[1] = x;
						}else v[map[y][x]] = true;
						if(cnt==1) {
							for (int c = 1; c < 10; c++) {
								if(!v[c]) map[idx[0]][idx[1]] = c;
							}
						}
						
					}
//					System.out.println();
				}
//				System.out.println();
			}			
		}
	}
	private static void vertical() {
		for (int j = 0; j < 9; j++) {
			boolean[] v = new boolean[10];
			int cnt = 0;
			int idx = 0;
			for (int i = 0; i < 9; i++) {
				if(map[i][j] == 0) {
					cnt++;
					idx = i;
				}else {
					v[map[i][j]] = true;
				}
			}
			if(cnt==1) {
				for (int i = 1; i < 10; i++) {
					if(!v[i]) map[idx][j] = i;
				}
			}			
		}
	}
	
	private static void horizon() {
		for (int i = 0; i < 9; i++) {			
			boolean[] v = new boolean[10];
			int cnt = 0;
			int idx = 0;
			for (int j = 0; j < 9; j++) {						
				if(map[i][j] == 0) {
					cnt++;
					idx = j;
				}else  v[map[i][j]] = true;
			}
			if(cnt==1) {
				for (int j = 1; j < 10; j++) {
					if(!v[j]) map[i][idx] = j;
				}
			}
		}
		
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
