package algo_10;

import java.io.*;
import java.util.*;

//접근방법
/*
1. 치즈 내부의 공기는 치즈를 녹이지 않는다. 그렇다면 공기가 외부의 공기인지 내부의 공기인지 어떻게 판단할까.
  - 외각에 2를 칠해준다, 2는 외부의 공기임을 나타낸다.

2. 외부의 공기를 전부 2로 칠해주기 위해선 어떻게 해야할까
  - 맵을 탐색하다 2를 만난다면, BFS를 돌린다.
  - 어떤 BFS? -> 2를 만난 좌표 y , x를 인자로 가져간다, dy, dx에 대한 사방탐색을 통해 
  - 0을 만나면 2로 바꿔주고 방문체크를 해준다. bfs를 시작할 때 해당 좌표 또한 방문체크하는것을 잊지 말자.
  
3. 외부 공기를 전부 칠했으니, 치즈를 어떻게 녹여볼까?
 - 생각나는 방법
 	1) 맵을 탐색하다 치즈를 만나면 해당 치즈 기준으로 상하좌우에 외부공기(2) 가 있는지 검사, 2가 있다면 녹여준다.
 	   녹여준 치즈가 공기가되면 해당 좌표에 의해 밑에 있는 치즈까지 녹을 수 있으므로, 방문체크를 해준다.
 	   문제점 : 탐색을 2번이나하게된다.
 	   
 	2) 2번의 BFS과정에서 0뿐만 아니라 1를 만났을 때도 공기로 바꿔준다. 방문체크 또한 해줘야한다.
 
4. 모두 녹는데 걸리는 시간은 어떻게 측정할까?
	- BFS를 돌릴 때 마다 전역변수 count++ 해준다.

5. 멈추는 순간은 어떻게 정하지?
	- 모든 동작을 while문에 넣으면 된다. flag가 true일 동안 동작한다.  남아있는 치즈가 1개 이상이라면(치즈를 만난다면) flag=true
	
6. 치즈가 모두 녹기 전 마지막 치즈의 개수?
	- bfs를 돌린 후에 치즈의 갯수를 세어주는 메소드를 만들어줘야겠다.
	  min값과 countCheese 값을 비교하여 최소값을 min에 저장한다.
	  다만 countCheese는 0보다 큰 값이어야 한다. 	   

*/
public class Main_2636치즈_bfs {
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int N,M,min,stage;
	static int[][] map;
	static boolean[][] v;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/algo_10/치즈.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+2][M+2];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}			
		}		
		for (int i = 0; i < N; i++) {
			map[i][0] = map[i][M+1] = 2;
		}
		for (int i = 0; i < M; i++) {
			map[0][i] = map[N+1][i] = 2;
		}
		
		
		
		flag = true;
		while(flag) {
			stage++;
			countCheese();
			sol();
			//print();
		}
		
		
		
		
		
		System.out.println(stage-1);
		System.out.println(min);
		
		
	}
	private static void sol() {
		
		v = new boolean[N][M];		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 2 && !v[i][j]) {
					bfs(i,j);
				}
			}
		}
			
		
		
	}
	
	private static void countCheese() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) cnt++;
			}
		}		
		if(cnt == 0) {
			flag=false;
			return;
		}
		min = Math.min(min, cnt);
	}
	private static void bfs(int i, int j) {
		v[i][j] = true;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int y = c[0];
			int x = c[1];			
			for (int d = 0; d < 4; d++) {
				int ny = y+dy[d];
				int nx = x+dx[d];
				if(ny<0 || nx<0 || ny>=N || nx>=M) continue;
				if(map[ny][nx] == 0 || map[ny][nx]==1) {
					if(map[ny][nx] == 0) q.add(new int[] {ny,nx});
					v[ny][nx] = true;
					map[ny][nx] = 2;
					
				}
			}			
		}
		
	}
	
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.printf("%2d",map[i][j]);
			}
			System.out.println();
		}
		System.out.println("---------------------------");
	}

}
