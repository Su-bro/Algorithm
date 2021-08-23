package algo9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16988바둑2 {
	static int N,M,cnt,ans;
	static int[][] map;
	static int max = 0;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static boolean[][] v;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("baduk.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());				
			}
		}
		
		//print(map);
		
		dfs(0);
		
		System.out.println(ans);
		
	}
	private static void dfs(int k) {
		if(k == 2) {
			//바둑돌 2개를 뒀다.
			//print(map);
			cnt = 0;
			
			v = new boolean[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j]==2 && !v[i][j]) {
						v[i][j]=true;
						Queue<int[]> q = new LinkedList<int[]>();
						q.add(new int[] {i,j});
						int tcnt = 1;
						flag = false;
						while(!q.isEmpty()) {
							int[] tp = q.poll();
							int y = tp[0];
							int x = tp[1];
							for(int d = 0; d < 4; d++) {
								int ny = y+dy[d];
								int nx = x+dx[d];
								if (nx < 0 || ny < 0 || nx >= M || ny >= N || v[ny][nx] || map[ny][nx] == 1)
									continue;
								if(map[ny][nx]==0) {
									flag = true;
								}
								if(map[ny][nx]==2) {
									v[ny][nx]=true;
									q.add(new int[] {ny,nx});
									tcnt++;
								}
							}
						}
						if(flag) continue;
						
						cnt+=tcnt;
						
					}
				}
			}	
			
			
			ans = Math.max(cnt, ans);
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j]==0) {
					map[i][j] = 1;
					dfs(k+1);
					map[i][j] = 0;
					
				}
			}
		}
		
	}
	
	private static void print(int[][] arr) {
		for(int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println("===========================");
		
	}
	
	
	

}
