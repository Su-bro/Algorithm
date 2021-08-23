package algo6;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/**
 * 
 * https://www.acmicpc.net/problem/3190
 * 
 */

public class Main_3190뱀 {
	static int[][] map,dir;
	static ArrayList<int[]> bamm;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1}; 
	public static void main(String[] args) throws IOException {		
		
		bamm = new ArrayList<int[]>();
		bamm.add(new int[]{0,0});		
		
		System.setIn(new FileInputStream("뱀.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		map = new int[N][N];
		map[0][0]=1;
		int K = sc.nextInt();
		for(int i = 0; i < K; i++) {
			int y = sc.nextInt()-1;
			int x = sc.nextInt()-1;
			map[y][x] = 2;			
		}
		//print(map);
		int L = sc.nextInt();
		dir = new int[L][2];
		for(int i = 0; i < L; i++) {
			dir[i][0] = sc.nextInt();
			dir[i][1] = sc.next().charAt(0);
		}
		//print(dir);
		
		int time = 0; //시간초기값
		int d = 0; //방향 초기값
		int x = 0; //좌표 초기값
		int y = 0;
		int lv = 0; //레벨 초기값
		while(true) { // lv가 명령횟수보다 작을동안
			//System.out.println(lv+"번째 시작한다 "+dir[lv][0]+"까지 이동한다");
			//System.out.println(d+"방향으로 이동");		
			//방향에 대한 다음칸 검색
			int nx = x+dx[d];
			int ny = y+dy[d];			

			//System.out.println(time+1);
			//다음칸이 공백이면
			if(nx<N && ny<N && nx>=0 && ny>=0 && map[ny][nx]==0) {
				x=nx;
				y=ny;
				map[y][x] = 1;
				bamm.add(new int[] {y,x});
				map[bamm.get(0)[0]][bamm.get(0)[1]] = 0;
				bamm.remove(0);
				time++;
			}
			//다음칸이 사과면
			else if (nx<N && ny<N && nx>=0 && ny>=0 && map[ny][nx]==2) {
				x=nx;
				y=ny;
				map[y][x] = 1;
				bamm.add(new int[]{y,x});
				time++;
			}
			//벽이거나 꼬리면 사망
			else {				
			System.out.println(time+1);
			System.exit(0);
			}
			//print(map);
			if(lv<L) {
				if(time==dir[lv][0]) {
					if(dir[lv][1]=='D') {
						d = (d+1)%4;
						//System.out.println(d+"로방향바뀐다D");
						lv++;
					}else if(dir[lv][1]=='L') {
						d = (d+3)%4;
						//System.out.println(d+"로방향바뀐다L");
						lv++;
					}
					
				}
			}
		}			
	}
	
	private static void print(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
	
	

}
