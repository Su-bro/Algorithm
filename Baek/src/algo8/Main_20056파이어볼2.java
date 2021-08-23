package algo8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_20056파이어볼2 {
	
	//Fire 클래스 생성
	static class Fire {
		int m;
		int s;
		int d;
		public Fire(int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	
	static int N,M,K,ans;
	static int[] dy = {-1,-1, 0, 1, 1, 1, 0,-1};
	static int[] dx = { 0, 1, 1, 1, 0,-1,-1,-1};
	static LinkedList<Fire>[][] map;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("상어.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new LinkedList[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = new LinkedList<>();
			}
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			//파이어볼 저장
			map[r][c].add(new Fire(m, s, d));
			
		}
		
		print();
		System.out.println("================시작====================");
		for(int i = 0; i < K; i++) {
			System.out.println("#"+(i+1)+"---------- -------------");
			move();
			print();
			mergecheck();
		}
		sum();
		System.out.println(ans);		
	}
	private static void sum() {
		
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++){
                for(Fire fb : map[i][j])
                    ans += fb.m;
            }
        }
	}
	private static void mergecheck() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j].size() >= 2) {
					System.out.println("merged!! at coordinate :"+i+","+j+"  for "+map[i][j].size());
					//질량과 속력의 합
					int sumM = 0, sumS = 0;
					//방향의 짝수 홀수 검사
					int even = 0, odd = 0;
					for(Fire f : map[i][j]) {
						sumM += f.m; //질량을 더해주고
						sumS += f.s; //속력을 더해주고
						//방향이 짝수이면 even++ 홀수면 odd++;
						if(f.d % 2 == 0)even++;
                        else odd++;						
					}
					int size = map[i][j].size();
					int M = sumM/5;
					int S = sumS/size;
					System.out.println("M,S : "+M + "," + S);
					
					map[i][j].clear(); //해당 좌표에 있는 fire 제거
					
					if(M > 0) { //질량이 0보다 클 때
						for(int d = 0; d < 4; d++) {
							//odd 혹은 even 중 하나가 size일 때(모홀or모짝일때)
							if(odd==size || even==size) {
								map[i][j].add(new Fire(M, S, d*2));
							}
							//아니라면
							else { 
								map[i][j].add(new Fire(M, S, d*2+1));
							}
						}
					}
					
					
				}
			}
		}
		
	}
	private static void move() {
		LinkedList<Fire>[][] moved = new LinkedList[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				moved[i][j] = new LinkedList<>();
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!map[i][j].isEmpty()) {
					for(Fire f : map[i][j]) {
						int dist = f.s;
						int y = i+dy[f.d]*dist;
						int x = j+dx[f.d]*dist;						
						while(y >= N) y -= N;		
						while(y < 0 ) y += N;
						while(x >= N) x -= N;		
						while(x < 0 ) x += N;
						moved[y][x].add(f);
					}
				}
			}
		}
		map = moved;
		
		
	}
	
	private static void print() {
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
					System.out.print(map[i][j].size()+" ");
			}
			System.out.println();
		}
		System.out.println("=============================");
	}
		
}
