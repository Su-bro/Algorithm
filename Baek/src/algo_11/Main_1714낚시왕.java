package algo_11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
접근 방법
1. 상어의 정보를 어떻게 담을까?
 상어의 정보를 담고있는 Shark 클래스를 만든다
 어레이리스트 2차원배열에 shark 정보를 add한다.

2. 상어를 어떻게 낚아볼까? catch() 메소드
   0번 열부터 C-1번 열까지 반복하며 해당 열 중 가장 가까이 있는 sum+=shark.d, 해당 상어 제거

3. 상어의 이동은 어떻게 구현할까? move() 메소드
  상어의 r, c를 받아온다, d 에 따른 방향으로 속력%r or 속력%c 만큼(속력이 경계선을 넘어가는것을 감안한 모듈러)
  

4. 상어가 2마리 이상일때 eat()
 어레이리스트를 돌면서 사이즈가 2 이상이면 해당 어레이리스트는 상어의 크기 기준으로 sort 해줘야겠지
 그리고 인덱스0이 아닌놈들은 다 삭제
 

*/

public class Main_1714낚시왕 {
	// 상어 오브젝트 클래스
	static class Shark implements Comparable<Shark>{
		int s, d, z;

		public Shark(int s, int d, int z) {
			super();
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public int compareTo(Shark o) {
			return o.z -z;
		}

	}

	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, 1, -1 };
	// 상어 오브젝트를 담는 2차원 어레이리스트
	static LinkedList<Shark>[][] map;
	static int R, C, M, sum;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/algo_11/낚시.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new LinkedList[R][C];
		// 어레이리스트 초기화
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = new LinkedList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c].add(new Shark(s, d, z));
		}
//		print();		
		
		for (int i = 0; i < C; i++) {
			fish(i);			
			move();
			eat();
//			print();
		}
		
		System.out.println(sum);

	}

	private static void eat() {
		LinkedList<Shark>[][] ate = new LinkedList[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				ate[i][j] = new LinkedList<>();
				if(!map[i][j].isEmpty()) {					
					Collections.sort(map[i][j]);
					ate[i][j].add(map[i][j].get(0));
				}
			}
		}
		map = ate;
		
	}

	private static void move() {
		LinkedList<Shark>[][] moved = new LinkedList[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				moved[i][j] = new LinkedList<>();
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!map[i][j].isEmpty()) {
					Shark now = map[i][j].get(0); // 제일 처음놈을 불러
					int ny=i,nx=j;
					int s = now.s;
					int d = now.d;
					int z = now.z;
					if(d == 1 || d==2) {
						if(s>=R*2) {
							s %= R*2;
						}
						for (int k = 0; k < s; k++) {
							ny = ny+dr[d];
							nx = nx+dc[d];
							if (nx < 0 || nx >= C || ny < 0 || ny >= R) {
								ny = ny-dr[d];
								nx = nx-dc[d];
//								System.out.println("방향전환");
								if (d == 1) {
									d = 2;
								} else if (d == 2) {
									d = 1;
								}
								k--;
							}
						}
//						System.out.println(i+","+j+"->"+ny+","+nx);
					}
					
					if(d == 3 || d==4) {
						if(s>=C*2) {
							s %= C*2;
						}
						for (int k = 0; k < s; k++) {
							ny = ny+dr[d];
							nx = nx+dc[d];
							if (nx < 0 || nx >= C || ny < 0 || ny >= R) {
								ny = ny-dr[d];
								nx = nx-dc[d];
//								System.out.println("방향전환");
								if (d == 3) {
									d = 4;
								} else if (d == 4) {
									d = 3;
								}
								k--;
							}
						}
					}
//					System.out.println(i+","+j+"->"+ny+","+nx);
					moved[ny][nx].add(new Shark(s, d, z));
				}
			}
		}
		map = moved;
	}

	private static void fish(int c) {
		for (int i = 0; i < R; i++) {
			if (map[i][c].size() == 1) {
				Shark s = map[i][c].get(0);
				sum += s.z;
				map[i][c].clear();
				break;
			}
		}
	}

	private static void print() {

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// System.out.print(map[i][j].size()+" ");
				if (!map[i][j].isEmpty())
					System.out.print(map[i][j].get(0).z + " ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println("=============================");
	}

}
