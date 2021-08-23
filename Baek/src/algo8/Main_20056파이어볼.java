package algo8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20056파이어볼 {
	static int N,M,K,ans;
	static int[] dy = {-1,-1, 0, 1, 1, 1, 0,-1};
	static int[] dx = { 0, 1, 1, 1, 0,-1,-1,-1};
	static ArrayList<int[]> fire;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("상어.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		fire = new ArrayList<int[]>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			//파이어볼 저장
			fire.add(new int[] {r,c,m,s,d});
			
		}
		
		see();
		System.out.println("================시작====================");
		for(int i = 0; i < K; i++) {
			System.out.println("#"+(i+1)+"---------- -------------");
			move();
			see();
			mergecheck();
		}
		sum();
		System.out.println(ans);
		
	}
	private static void sum() {
		
		for(int i = 0; i < fire.size(); i++) {
			ans += fire.get(i)[2]; 
		}
		
	}
	private static void mergecheck() {
		//좌표값을 순회하며
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int y = i;
				int x = j;
				int cnt=0;
				Queue<Integer> dellist = new LinkedList<Integer>();
				//하나의 좌표값에서 fire의 사이즈만큼 순회하며
				for(int f = fire.size()-1; f >=0; f--) {					
					//fire의 좌표값을 얻어낸 후
					
					int fy = fire.get(f)[0];
					int fx = fire.get(f)[1];
					if(y == fy && x == fx) {//해당 좌표와 일치한다면
						cnt++; //카운트 증가
						dellist.add(f); //삭제할놈 증가
						//System.out.println("coordinate :"+i+","+j+" index:"+f+", count:"+cnt+dellist);
					}
				}
				if(cnt>=2) { //해당 좌표값을 가지는녀석이 2놈이상 있다면	
					System.out.println("merged!! at coordinate :"+i+","+j+"  for :"+dellist);
					//질량과 속력의 합
					int sumM = 0, sumS = 0;
					//방향의 짝수 홀수 검사
					boolean even = true, odd = true;					
					while(!dellist.isEmpty()) {
						//삭제할놈들의 인덱스를 하나하나 꺼내가며
						int del = dellist.poll();
						sumM += fire.get(del)[2]; //질량을 더해주고
						sumS += fire.get(del)[3]; //속력을 더해주고
						//방향이 짝수이면 odd false 홀수면 even false
						if(fire.get(del)[4] % 2 == 0)odd = false;
                        else even = false;
						//System.out.println(sumM+","+sumS);
						fire.remove(del);
					}
					int M = sumM/5;
					int S = sumS/cnt;
					System.out.println("M,S : "+M + "," + S);
					for(int k = 0; k < 4; k++) {
						//둘중 하나라도 true 라면 == 모두 짝수거나 홀수
						if(odd || even) {
							fire.add(new int[] {i,j,M,S,k*2});
						}
						else {
							fire.add(new int[] {i,j,M,S,k*2+1});
						}
					}
					
				}
			}
		}
		
	}
	
	private static void move() {
		for(int i = 0; i < fire.size(); i++) {//파이어볼들에 대해
			//해당 파이어볼 호출해서 F에 저장
			int[] F =fire.get(i);
			int dist = F[3]%N;
			int ny = F[0]+( dy[F[4]] * dist );
			int nx = F[1]+( dx[F[4]] * dist );
			//if(ny >= N) ny -= N;
			while(ny >= N) ny -= N;			
			//if(ny < 0 ) ny += N;
			while(ny < 0) ny += N;
			//if(nx >= N) nx -= N;
			while(nx >= N) nx -= N;			
			//if(nx < 0 ) nx += N;
			while(nx < 0 ) nx += N;
			F[0]=ny; //변경된 좌표 저장
			F[1]=nx;
			fire.set(i, F); //좌표가 변경된오브젝트로 변경
		}
		
	}
	
	private static void see() { //현재 상태 관찰
		int[][] map = new int[N][N]; //이 맵에서
		for(int i = 0; i < fire.size(); i++) { //파이어볼들에 대해
			int y = fire.get(i)[0]; //좌표따내고
			int x = fire.get(i)[1];
			map[y][x] = 1; //맵에 찍고
		}
		for(int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("------------------------------------");
		
	}

}
