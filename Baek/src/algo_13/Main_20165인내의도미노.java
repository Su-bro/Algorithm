package algo_13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20165인내의도미노 {
	static int map[][], ori[][], N, M, R, dy[] = {0,0,1,-1}, dx[] = {1,-1,0,0},score;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/algo_13/도미노.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ori = new int[N][M]; //원본도미노
		
		score = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = ori[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		print(map);
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int ay = Integer.parseInt(st.nextToken())-1;
			int ax = Integer.parseInt(st.nextToken())-1;
			int dir=0;
			char ad = st.nextToken().toCharArray()[0];
			switch (ad) {
			case 'E':
				dir = 0;
				break;
			case 'W':
				dir = 1;
				break;
			case 'S':
				dir = 2;
				break;
			case 'N':
				dir = 3;
				break;
			
			}			
//			System.out.println(ay+" "+ax+" "+ad+" "+dir);
			attack(ay,ax,map[ay][ax],dir);
			
			
			st = new StringTokenizer(br.readLine());
			int rY = Integer.parseInt(st.nextToken())-1;
			int rX = Integer.parseInt(st.nextToken())-1;
			map[rY][rX] = ori[rY][rX];
			
//			System.out.println(rY+" "+rX);
		}
		System.out.println(score);
		print(map);
		
		
	}	
	private static void attack(int y, int x, int power, int d) {
		if(map[y][x]!='F') {
			map[y][x] = 'F';
			++score;
		}		
		--power;
		if(power == 0) return;
		
//		System.out.println("파워"+power);
		int ny = y+dy[d];
		int nx = x+dx[d];
		if(ny>=0 && nx>=0 && ny<N && nx<M) {
			if(map[ny][nx]>power && map[ny][nx] != 'F') {
				attack(ny,nx,map[ny][nx],d);
			}else attack(ny,nx,power,d);
		}
	}



	private static void print(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j]==70) System.out.print((char)arr[i][j]+" ");
				else System.out.print("S ");
			}
			System.out.println();
		}
		
	}
}

