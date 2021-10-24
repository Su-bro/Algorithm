package week11;

import java.util.*;
import java.io.*;

public class Main_2072오목 {

	static int map[][] = new int[21][21], N,
			// 상 좌 좌상 좌하 하 우 우하 우상
			dy[] = { -1, 0, -1, 1, 1, 0, 1, -1 }, dx[] = { 0, -1, -1, -1, 0, 1, 1, 1 }, cnt;
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/week10/오목.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			int bw = i % 2 + 1;
			map[y][x] = bw;

			for (int d = 0; d < 8; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (map[ny][nx] == bw) {
					// print(map);
					cnt = 1;
					v = new boolean[22][22];
					v[y][x] = true;
					dfs(y, x, bw, d);
					if (cnt >= 5 && cnt != 6) {
						System.out.println(i);
						System.exit(0);
					}
				}
			}
		}
		System.out.println(-1);
	}

	private static void dfs(int y, int x, int bw, int d) {
		int ny = y + dy[d];
		int nx = x + dx[d];
		if (map[ny][nx] == bw && !v[ny][nx]) {
			v[ny][nx] = true;
			cnt++;
			dfs(ny, nx, bw, d);
		}
		ny = y + dy[(d + 4) % 8];
		nx = x + dx[(d + 4) % 8];
		if (map[ny][nx] == bw && !v[ny][nx]) {
			v[ny][nx] = true;
			cnt++;
			dfs(ny, nx, bw, d);
		}
	}

//	private static void print(int[][] m) {
//		for (int i = 0; i < m.length; i++) {
//			for (int j = 0; j < m.length; j++) {
//				System.out.print(m[i][j]+" ");
//			}
//			System.out.println();
//		}
//	}

}
