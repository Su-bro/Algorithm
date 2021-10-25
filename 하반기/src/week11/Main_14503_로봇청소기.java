package week11;

//북 동 남 서
/*
0 -> 3
1 -> 0
2 -> 1
3 -> 2
*/
import java.io.*;
import java.util.*;

public class Main_14503_로봇청소기 {
	static int map[][],N,M,cnt,dy[]= {-1,0,1,0},dx[]= {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/week10/로봇청소기.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int y = sc.nextInt();
		int x = sc.nextInt();
		int d = sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		while(true) {	
			//0이면 청소
			if(map[y][x] == 0) {
				map[y][x] = 2;
				cnt++;
			}
			//scan
			int ny0 = y+dy[0];
			int nx0 = x+dx[0];
			int ny1 = y+dy[1];
			int nx1 = x+dx[1];
			int ny2 = y+dy[2];
			int nx2 = x+dx[2];
			int ny3 = y+dy[3];
			int nx3 = x+dx[3];
			if(map[ny0][nx0] !=0 && map[ny1][nx1] !=0 && map[ny2][nx2] !=0 && map[ny3][nx3] !=0) {
//				System.out.println("더 할곳이 없어");
				int ny = y+dy[(d+2)%4];
				int nx = x+dx[(d+2)%4];
				if(map[ny][nx] == 1) {
//					System.out.println("작동을멈춘다");
					System.out.println(cnt);
					return;
				}
				else {
					y = ny;
					x = nx;
				}
			}
			else {
				//rotate
				d = (d+3)%4;
				int ny = y+dy[d];
				int nx = x+dx[d];
				if(map[ny][nx]==0) {
					y=ny;
					x=nx;				
				}
			}
		}
	}
}
