package algo8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17070파이프옮기기 {
	static int tp;
	static int N,cnt;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("파이프.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		N = Integer.parseInt(br.readLine());
		tp=N+1; //맵사이즈+1
		map = new int[tp][tp]; //생성
		cnt=0;
		//먼저 1로 가득체운다
		for(int i = 0; i < tp; i++) {
			for(int j = 0; j < tp; j++) {
				map[i][j] = 1;
			}
		}
		//입력받아온다
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//back 좌표
		int by = 0;
		int bx= 0;
		//front 좌표
		int fy= 0;
		int fx= 1;
		
		move(fy, fx, by, bx); //무브 실행
		
		System.out.println(cnt);		
	}	
	private static void move(int fy, int fx, int by, int bx) {		
		printsim(fy,fx,by,bx);
		if(fy==N-1 && fx==N-1) {//앞좌표가 끝에 도착하면			
			cnt++; //경우의수 하나 추가
			System.out.println("=========야스============"+cnt+"번째 도착");
			return; //되돌아간다 
		}
		else {
			//가로상태일때
			if(bx+1 == fx && by==fy) {
				//대각선으로 이동할수있는지
				if(map[fy+1][fx+1]!=1 && map[fy][fx+1]!=1 && map[fy+1][fx]!=1) {
					move(fy+1, fx+1, fy, fx);
				}
				//우측으로 이동할수있는지
				if(map[fy][fx+1]!=1) {
					move(fy,fx+1,fy,fx);
				}
				
			}
			//대각상태일때
			else if(bx+1==fx && by+1==fy) {
				//대각선으로 이동할수있는지
				if(map[fy+1][fx+1]!=1 && map[fy][fx+1]!=1 && map[fy+1][fx]!=1) {
					move(fy+1, fx+1, fy, fx);
				}
				//우측으로 이동할수있는지
				if(map[fy][fx+1]!=1) {
					move(fy,fx+1,fy,fx);
				}
				//밑으로 이동할수있는지
				if(map[fy+1][fx]!=1) {
					move(fy+1,fx,fy,fx);
				}				
			}
			//세로상태일때
			else if(bx==fx && by+1==fy) {
				//대각선으로 이동할수있는지
				if(map[fy+1][fx+1]!=1 && map[fy][fx+1]!=1 && map[fy+1][fx]!=1) {
					move(fy+1, fx+1, fy, fx);
				}
				//밑으로 이동할수있는지
				if(map[fy+1][fx]!=1) {
					move(fy+1,fx,fy,fx);
				}
				
			}
			
		}
		System.out.println("2dddddd");
		return;
	}
	
	private static void printsim(int fy, int fx, int by, int bx) {
		System.out.println("앞:{"+fy+","+fx+"} | 뒤:{"+by+","+bx+"}");
		int[][] tmp = new int[tp][tp];
		for(int i = 0; i < tp; i++) {
			for(int j = 0; j < tp; j++) {
				tmp[i][j] = map[i][j];
			}
		}		
		tmp[fy][fx] = 8;
		tmp[by][bx] = 8;
		for(int i = 0; i < tp; i++) {
			System.out.println(Arrays.toString(tmp[i]));
		}

	}

}
