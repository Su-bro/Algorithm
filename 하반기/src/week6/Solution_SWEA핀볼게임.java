package week6;

import java.io.*;
import java.util.*;

public class Solution_SWEA핀볼게임 {
	static int N, answer;
	static int[] dy = { -1, 0, 1, 0 }, dx = { 0, -1, 0, 1 };
	static int[][] map;

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/week6/핀볼게임.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						for (int d = 0; d < 4; d++) {
							int ny = i + dy[d];
							int nx = j + dx[d];
							if (ny >= N || nx >= N || ny < 0 || nx < 0) {
								continue;
							} else {
								dfs(i, j, d, 0, i, j);
							}
						}
					}
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static void dfs(int y, int x, int d, int cnt, int sy, int sx) {
		while (true) {
			if (map[y][x] == -1) {
//			System.out.println("블랙홀을 만나서 종료 y:" + y + " x:" + x + " d:" + d + " cnt:" + cnt);
				answer = Math.max(answer, cnt);
				return;
			}
//		System.out.println("지금= " + "y:" + y + " x:" + x + " d:" + d + " cnt:" + cnt);

			if (map[y][x] >= 1 && map[y][x] <= 5) {
				cnt = cnt + 1;
//			System.out.println("블럭을 만났다");
				switch (map[y][x]) {
				// 상좌하우
				case 1:
					if (d == 2)
						d = 3;
					else if (d == 1)
						d = 0;
					else
						d = (d + 2) % 4;
					break;
				case 2:
					if (d == 0)
						d = 3;
					else if (d == 1)
						d = 2;
					else
						d = (d + 2) % 4;
					break;
				case 3:
					if (d == 0)
						d = 1;
					else if (d == 3)
						d = 2;
					else
						d = (d + 2) % 4;
					break;
				case 4:
					if (d == 2)
						d = 1;
					else if (d == 3)
						d = 0;
					else
						d = (d + 2) % 4;
					break;
				case 5:
					d = (d + 2) % 4;
					break;
				default:
					break;
				}
			} else if (map[y][x] >= 6 && map[y][x] <= 10) {
//			System.out.println(map[y][x] + "번 웜홀을 만났다");
				int[] pos = dohole(y, x, map[y][x]);
				y = pos[0];
				x = pos[1];
			}
			// 블럭이 아니라면
			int ny = y + dy[d];
			int nx = x + dx[d];
			// 경계선을 벗어나면
			if (ny >= N || nx >= N || ny < 0 || nx < 0) {
				int nd = (d + 2) % 4;
//			System.out.println("경계선을벗어나므로 d를 바꾼다, cnt증가");
				d = nd;
				cnt = cnt+1;
			} else if (ny == sy && nx == sx) {
//			System.out.println("시작점으로왔다 = ny:" + y + " nx:" + x + " d:" + d + " cnt:" + cnt);
				if (cnt == 20) {
//				System.out.println(sy+","+sx+","+d);
				}
				answer = Math.max(answer, cnt);
				return;
			} else {
				y = ny;
				x = nx;
			}
		}

	}

	private static int[] dohole(int y, int x, int num) {
		int pos[] = new int[2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == num && i != y && j != x) {
					pos[0] = i;
					pos[1] = j;
				}
			}
		}
		return pos;
	}

}
