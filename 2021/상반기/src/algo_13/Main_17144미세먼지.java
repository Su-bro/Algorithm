package algo_13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17144미세먼지 {
	static class Dust{
		int x,y,dust;
		public Dust(int x, int y, int dust) {
			this.x = x;
			this.y = y;
			this.dust = dust;
		}		
	}
	static int N, M, T,dy[]= {-1,1,0,0},dx[]= {0,0,-1,1}, map[][],map2[][],c1,c2;
	static Queue<Dust> q;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/algo_13/미세먼지.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		q = new LinkedList<Dust>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					c2=i;
				}
			}
		}
//		print(map);
		c1 = c2-1;
		
		for (int i = 0; i < T; i++) {
			diffusion();
			active();
		}
		
//		print(map);
		
		
//		print(map);
		
		System.out.println(check());
		
	}
	private static void active() {
		//c1에 대해서
		for(int i = c1-1; i>0; i--) {
			map[i][0]=map[i-1][0];
		}
		for (int i = 0; i < M-1; i++) {
			map[0][i] = map[0][i+1];
		}
		for (int i = 0; i < c1; i++) {
			map[i][M-1] = map[i+1][M-1];
		}
		for (int i = M-1; i>0; i--) {
			map[c1][i] = map[c1][i-1];
		}
		map[c1][1] = 0;
		
		//c2에 대해서
		
		for(int i = c2+1; i<N-1; i++) {
			map[i][0]=map[i+1][0];
		}
		for (int i = 0; i < M-1; i++) {
			map[N-1][i] = map[N-1][i+1];
		}
		for (int i = N-1; i > c2; i--) {
			map[i][M-1] = map[i-1][M-1];
		}
		for (int i = M-1; i>0; i--) {
			map[c2][i] = map[c2][i-1];
		}
		map[c2][1] = 0;
	}
	private static int check() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {			
			for (int j = 0; j < M; j++) {				
				if(map[i][j]>0) {
					cnt+=map[i][j];
				}
			}
		}
		
		return cnt;
	}
	private static void diffusion() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]>=5) {
					int div5 = map[i][j]/5;
					for (int d = 0; d < 4; d++) {
						int ny = i+dy[d];
						int nx = j+dx[d];
						if(ny<0 || nx<0 || ny>=N || nx>=M || map[ny][nx]==-1) continue;
						q.add(new Dust(nx, ny, div5));
						map[i][j]-=div5;
					}
				}
			}
		}
		while (!q.isEmpty()) {
			Dust add = q.poll();
			map[add.y][add.x]+=add.dust;
		}
	}
	private static void print(int[][] map2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.printf("|%2d",map[i][j]);
			}
			System.out.println("|->"+i);			
		}
		System.out.println("===================");		
		
	}

}
