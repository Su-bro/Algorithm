package algo_12;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_1445일아데 {
	// 위치, 쓰레기현황
	static class info implements Comparable<info> {
		int y; 
		int x;
		int gar;
		int ngar;		

		public info(int y, int x, int gar, int ngar) {			
			this.y = y;
			this.x = x;
			this.gar = gar;
			this.ngar = ngar;
		}

		@Override
		//쓰레기 덜밟은순, 덜지나간순으로 정렬할수있게 만들고
		public int compareTo(info o) {
			if (this.gar == o.gar) {
				return this.ngar - o.ngar;
			}
			return this.gar - o.gar;
		}

		@Override
		public String toString() {
			return "Info [y=" + y + ", x=" + x + ", gar=" + gar + ", ngar=" + ngar + "]";
		}
		
	}

	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static int n, m, map[][];
	static boolean[][] v;
	static ArrayList<int[]> gq = new ArrayList<int[]>();
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/algo_12/일아데.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		v = new boolean[n][m];	
		
		PriorityQueue<info> pq = new PriorityQueue<info>();
		for (int i = 0; i < n; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				
				//일단 맵에 찍고
				map[i][j] = c[j];
				
				if (c[j] == 'S') { //스타트포인트 pq에 넣고
					// 밟은 쓰레기, 지나간쓰레기 순으로 우선순위 정렬된 큐	
					pq.add(new info(i,j,0,0));
					v[i][j] = true; //여긴 어차피 true
					
				} 				
				else if(c[j]=='g') {
					//쓰레기만나면 좌표저장하고
					gq.add(new int[] {i,j});
				}
			}
		}
		
		//near garbage (n) 을 찍어준다
		nearg();		
		print(map);	
		
		//결과값
		int result_gar = 0;
		int result_ngar = 0;
		
		L:while (!pq.isEmpty()) {			
			info now = pq.poll();
			System.out.println(now.toString());			
			// 꺼내옴
			int y = now.y;
			int x = now.x;
			
			for (int i = 0; i < 4; i++) {	
				
				int ny = y+dy[i];
				int nx = x+dx[i];
				int gar = now.gar;
				int ngar = now.ngar;
				
				if(ny<0 || nx <0 || ny>= n || nx >= m || v[ny][nx]) continue;
				if(map[ny][nx] == 'F') {
//					System.out.println("만났다");
					result_gar = gar;
					result_ngar = ngar;
					break L;
				}
				if(map[ny][nx] == 'g') gar++; //쓰레기만나면
				if(map[ny][nx] == 'n') ngar++; //쓰레기근처면
				v[ny][nx] = true; //어찌됐든 거긴 지나갔으니까 트루
//				//pq에 넣고				
				pq.add(new info(ny, nx, gar, ngar));
				
			}
			
			
		}
		System.out.println(result_gar+" "+result_ngar);
		땡겨();

	}

	private static void 땡겨() {
		System.out.println("와우");
		
	}

	private static void nearg() {
		//가바지포인트 찍어준거
		for(int[] point : gq) {
			for(int d = 0 ; d< 4 ; d++) {
				int y = point[0] + dy[d]; 
				int x = point[1] + dx[d];
				//좌표따와서 사방에 n체크
				if(y<0 || x <0 || y>= n || x >= m)
					continue;
				if(map[y][x] == '.' )
					map[y][x] = 'n';
			}
		}
	}

	private static void print(int[][] map2) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print((char) map2[i][j]);
			}
			System.out.println();
		}

	}

}
