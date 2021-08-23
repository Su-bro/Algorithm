package algo9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
시작 size = 2;
1초에 상하좌우 이동
size보다 작은 칸 지나감
eat==size , size++
cur 기준 4방향 bfs탐색



*/
public class Main_16236아기상어2 {
	static int n,size,move,eatcnt;
	static int[][] map;
	static int[] cur;
	static boolean able = false;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,-1,0,1};
	static LinkedList<int[]> eatable;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("아기상어.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());		
		map = new int[n][n];
		size = 2;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) cur=new int[] {i,j};
			}
		}	
		
		//print(map);		

		
		
		while(true) {
			able=false; //초기화
			search(); //상어가 먹을수 있는게 있을까 찾아보자
			if(!able) break; //먹을수있는게 없어? 엄마불러!!
			eat(); //먹자			
			//이마이 먹었으면
			if(eatcnt==size) {
				eatcnt=0; //카운트초기화
				size++; //사이즈업!
			}
			//sim();
			
		}
		
		System.out.println(move);
	}
	
	
	
	
	private static void sim() {
		print(map);
		for(int[] a : eatable) {
		System.out.println("상어위치:"+Arrays.toString(cur)+"현제이동한거리:"+move+"상어크기:"+size);
		System.out.println("먹이목록:"+Arrays.toString(a));
		}
		
	}




	private static void eat() {
		//가장 가깝고, 위에 있는놈(0번인덱스) 먹을거야!
		int[] feed = eatable.get(0);
		int dist = feed[0];
		int y = feed[1];
		int x = feed[2];
		
		move += dist; //거리만큼 이동하겠지?
		eatcnt++; //먹은수도 증가하고
		//상어 위치도 바꿔주자고
		map[cur[0]][cur[1]] = 0;
		cur[0] = y; 
		cur[1] = x;
		map[y][x]=9;
		
	}




	private static void print(int[][] arr) {
		System.out.println("-----------------------------");
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
	private static void search() {
		boolean[][] v = new boolean[n][n]; //방문배열
		Queue<int[]> q = new LinkedList<int[]>(); //bfs큐
		eatable = new LinkedList<int[]>();		
		//먹이목록큐 새로만들고
		int y = cur[0];
		int x = cur[1];
		v[y][x]=true;
		q.add(new int[] {y,x}); //상어의 현재위치
		while(!q.isEmpty()) {			
			int[] loc = q.poll();
			int cy = loc[0];
			int cx = loc[1];
			for(int i = 0; i < 4; i++) {
				int ny = cy+dy[i];
				int nx = cx+dx[i];
				if(ny<0 || nx<0 || ny>=n || nx>=n || v[ny][nx]) continue;
				if(map[ny][nx]==0 || map[ny][nx]==size) { 
					//지나갈수있는곳(빈칸이거나 크기가 나랑 같거나)
					v[ny][nx]=true;
					q.add(new int[] {ny,nx});					
				}
				else if(map[ny][nx]!=0 && map[ny][nx]<size) {
					//점심시간이네?
					int dist = caldist(y,x,ny,nx);//거리
					v[ny][nx]=true;
					able = true; //가능 ㅋㅋ
					//먹을목록에 추가하자(거리,좌표)
					eatable.add(new int[] {dist,ny,nx});				
				}				
			}			
		}
		
		//먹이목록 정렬하자
		Collections.sort(eatable, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) { // 거리가 같다면
					return o1[1]-o2[1]; //더 위에있는놈 먹자구~
				}else return o1[0]-o2[0];
				//좌측에있는놈 먹자고 정렬 할 필요는 없어(bfs방향이 좌측우선이라)
				
			}
		});
		
	}
	
	
	private static int caldist(int y, int x, int ny, int nx) {
		int dist = Math.abs(y-ny) + Math.abs(x-nx);
		return dist;
	}

}
