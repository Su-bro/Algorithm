package algo9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
1. 벽을 3개 세운다 
2. 바이러스를 상하좌우로 발산(탐색 -> if(virus) 4방향=0, virus
3. 안전구역(0의갯수) cnt , cnt/max 비교, max값 = ans

1)) 재귀함수 wall(i)  -> 빈공간 map에 벽찍고 wall(i++)
2)) i가 3이되면(벽을 3개 찍으면) 바이러스 발산, 안전구역 검색, 리턴 
3)) 위 과정을 반복하면, 벽을 찍는 모든 경우에 대한 발산,안전구역검색 
4)) 안전구역 카운트, max값을 정답으로

조건 - > max는 전역 변수 (지역과 상관없이 계속 비교)

 */
public class Main_14502연구소 {
	static int[][] map;
	static int N,M;
	static int max = 0;
	static int[] dy = {-1, 0, 0, 1};
	static int[] dx = { 0,-1, 1, 0};
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("연구소.txt"));
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
		
		makewall(0);
		
		System.out.println(max);
		
	}
	
	
	
	
	private static void makewall(int w) {
		if(w==3) {//벽 3개 세웠는가?
			//확산 ㄱㄱ
			spread();			
			return;
		}		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				//빈공간이라면
				if(map[i][j]==0) {
					//벽을 만들어준다.
					map[i][j]=8;					
					makewall(w+1);//재귀
					//복귀시에는 찍었던 벽 다시 제거
					map[i][j]=0;				
					
				}
			}
		}
	}
	
	
	private static void spread() {
		//새로운 지도에 map deepcopy
		int[][] copy = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copy[i][j] = map[i][j];
			}
		}
		//bfs를 위한 큐
		Queue<int[]> q = new LinkedList<int[]>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {				
				if(copy[i][j]==2) {//바이러스를 만나면
					q.add(new int[] {i,j});
				}
			}
		}
		
		
		
		while(!q.isEmpty()) {
			int[] cdn = q.poll();
			int y = cdn[0];
			int x = cdn[1];
			for(int d = 0; d<4; d++) {						
				int ny = y + dy[d];
				int nx = x + dx[d];
				if(ny>=0 && nx>=0 && ny<N && nx<M && copy[ny][nx]==0) {				
					copy[ny][nx]=2; //사방에 바이러스 뿌림
					q.add(new int[] {ny,nx});
				}
			}			
		}
		//print(copy);	
		//안전지대 찾기
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copy[i][j]==0) cnt++;
			}
		}


		//최대값비교
		max = Math.max(max, cnt);
		
	}
	
	
	
	
	private static void print(int[][] arr) {
		System.out.println("===============================");
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	

}
