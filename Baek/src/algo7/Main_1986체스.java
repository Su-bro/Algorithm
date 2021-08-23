package algo7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1986체스 {
	static int[][] map;
	static int n,m;
	static int[] kdy = {-1,-2,-2,-1, 1, 2, 2, 1};
	static int[] kdx = {-2,-1, 1, 2, 2, 1,-1,-2};
	
	static int[] dy = {-1,-1,-1, 0, 1, 1, 1, 0};
	static int[] dx = {-1, 0, 1, 1, 1, 0,-1,-1}; 
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("체스.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		//퀸찍기
		st = new StringTokenizer(br.readLine());		
		int q = Integer.parseInt(st.nextToken());
		for(int i = 0; i < q; i++) {
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			map[y][x] = 'Q';					
		}
		//킹찍기
		st = new StringTokenizer(br.readLine());	
		int k = Integer.parseInt(st.nextToken());
		for(int i = 0; i < k; i++) {
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			map[y][x] = 'K';					
		}
		//폰찍기
		st = new StringTokenizer(br.readLine());	
		int p = Integer.parseInt(st.nextToken());
		for(int i = 0; i < p; i++) {
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			map[y][x] = 'P';					
		}
		//print(map);
		//1찍기
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				//if(map[i][j]!=0)System.out.println("("+i+","+j+")"+" : "+(char)map[i][j]);
				if(map[i][j]=='K') {
					//킹체크
					kcheck(i,j);
				}
				if(map[i][j]=='Q') {
					//8방향에 대해 퀸체크
					for(int d = 0; d < 8; d++) {
						qcheck(i,j,d);
					}
				}
			}
		}
		//print(map);	
		int cnt=0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j]==0) cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
		
			
	}
	private static void qcheck(int y, int x, int d) {
		int ny = y+ dy[d];
		int nx = x+ dx[d];
		//퀸킹폰이아닐때
		if(ny>=0 && nx>=0 && ny<n && nx<m && map[ny][nx]<2) {
			//1찍고 계속가라
			map[ny][nx]=1;
			qcheck(ny, nx, d);
		}
		//위치가 2보다 크면(0혹은1이 아니라면 -> 퀸킹폰중하나 ->길막혀서못감)
		else return;
		
	}
	private static void kcheck(int y, int x) {
		//나이트가 이동할수 있는 모든 위치에 대하여
		for(int i = 0; i < 8; i++) {
			int ny = y+ kdy[i];
			int nx = x+ kdx[i];
			if(ny>=0 && nx>=0 && ny<n && nx<m && map[ny][nx]==0) {
				map[ny][nx]=1;
			}
		}
	}
	private static void print(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println("================================");
	}

}
