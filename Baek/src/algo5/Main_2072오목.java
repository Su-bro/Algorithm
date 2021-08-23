package algo5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2072오목 {
	static int[] dy = {-1,-1,-1,0,1,1,1,0};
	static int[] dx = {-1,0,1,1,1,0,-1,-1};
	static int size = 19;
	static int map[][] = new int[size][size];
	static int n,ans,Wcnt,Bcnt;
	static boolean flag;
	static Queue<Integer> q = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("오목.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		n = Integer.parseInt(br.readLine());		
		
		for(int turn = 1; turn <= n; turn++) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			if(turn%2==1) {
				map[y][x] = 1;
			}else {
				map[y][x] = 2;
			}
			//print();
			
			if(turn>8) {
				for(int i = 0; i < size; i++) {
					for(int j = 0; j < size; j++) {
						if(map[i][j]==1) {
							for(int k = 0; k < 8; k++) {
								Bcnt=1;
								scB(i,j,k,turn);
							}
							
						}else if(map[i][j]==2) {
							for(int k = 0; k < 8; k++) {
								Wcnt=1;
								scW(i,j,k,turn);
							}
						}						
					}
				}			
			}			
		}
		
		if(!flag) {
			System.out.println(-1);
		}else {
			System.out.println(q.poll());
		}
		
	}
	
	
	private static void scB(int y, int x, int k, int turn) {
		
		int nr = y+dy[k];
		int nc = x+dx[k];
		if(Bcnt==5 && nr>=0 && nr<size && nc>=0 && nc<size && map[nr][nc]!=1 ) {
			System.out.println(turn);
			flag=true;
			q.add(turn);
			System.exit(0);
		}
		
		if(nr>=0 && nr<size && nc>=0 && nc<size) {
			if(map[nr][nc]==1) {
				Bcnt++;
				scB(nr, nc, k, turn);
			}
		}		
	}

	private static void scW(int y, int x, int k, int turn) {		
		int nr = y+dy[k];
		int nc = x+dx[k];		
		if(Wcnt==5 && nr>=0 && nr<size && nc>=0 && nc<size && map[nr][nc]!=2 ) {
			System.out.println(turn);			
			flag=true;
			q.add(turn);
			System.exit(0);
		}		
		if(nr>=0 && nr<size && nc>=0 && nc<size) {
			if(map[nr][nc]==2) {
				Wcnt++;
				scW(nr, nc, k, turn);	
				
			}
		}
		
	}

}
