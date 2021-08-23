package algo_10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499주사위굴리기 {
	static int[][] dice = new int[4][3];
	static int[][] map;
	static int N,M,K,y,x;
	static int[] dy = {0,0,0,-1,1}; //동서북남
	static int[] dx = {0,1,-1,0,0};
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("주사위.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];		
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
//		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡ초기상태ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//		print(dice);
//		print(map);
//		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ시작ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int com = Integer.parseInt(st.nextToken());
			if(y+dy[com] >=N || y+dy[com] < 0 || x+dx[com] >= M || x+dx[com] < 0) {
//				System.out.println("경계선 밖으로 나가는 동작이다. 동작취소");
				continue;
			}
			rollin(com);			
//			print(map);
//			print(dice);
			System.out.println(dice[1][1]);
//			System.out.println("주사위 현위치 ={"+y+","+x+"}");			
		}
		
		
	}
	private static void rollin(int com) {
		int temp1;
		int temp2;
		y = y+dy[com];
		x = x+dx[com];
		switch (com) {
		case 1:
//			System.out.println("동쪽으로 굴린다.");
			temp1 = dice[1][2];
			temp2 = dice[3][1];
			dice[1][2] = dice[1][1];
			dice[1][1] = dice[1][0];
			dice[3][1] = temp1;
			dice[1][0] = temp2;
			
			if(map[y][x]==0) {
				map[y][x]=dice[3][1];
			}else {
				dice[3][1] = map[y][x];
				map[y][x]=0;
			}
			
			break;
		case 2:
//			System.out.println("서쪽으로 굴린다.");			
			temp1 = dice[1][0];
			temp2 = dice[3][1];
			dice[1][0] = dice[1][1];
			dice[1][1] = dice[1][2];
			dice[3][1] = temp1;
			dice[1][2] = temp2;
			
			if(map[y][x]==0) {
				map[y][x]=dice[3][1];
			}else {
				dice[3][1] = map[y][x];
				map[y][x]=0;
			}
			
			break;
		case 3:
//			System.out.println("북쪽으로 굴린다.");
			temp1 = dice[0][1];
			dice[0][1] = dice[1][1];
			dice[1][1] = dice[2][1];
			dice[2][1] = dice[3][1];
			dice[3][1] = temp1;
			if(map[y][x]==0) {
				map[y][x]=dice[3][1];
			}else {
				dice[3][1] = map[y][x];
				map[y][x]=0;
			}
			
			break;
			
		case 4:
//			System.out.println("남쪽으로 굴린다.");
			temp1 = dice[3][1];
			dice[3][1] = dice[2][1];
			dice[2][1] = dice[1][1];
			dice[1][1] = dice[0][1];
			dice[0][1] = temp1;
			if(map[y][x]==0) {
				map[y][x]=dice[3][1];
			}else {
				dice[3][1] = map[y][x];
				map[y][x]=0;
			}
			
			break;
			

		}
		
	}
	private static void print(int[][] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.print(" |");
			System.out.println();
		}
		System.out.println("========================");
	}

}
