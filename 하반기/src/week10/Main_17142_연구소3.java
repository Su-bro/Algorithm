package week10;

import java.io.*;
import java.util.*;

public class Main_17142_연구소3 {
	static int N, M, map[][], dy[] = { -1, 1, 0, 0 }, dx[] = { 0, 0, -1, 1 }, ans = -1, min = 99999;
	static ArrayList<int[]> list = new ArrayList<int[]>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					list.add(new int[] { i, j });
			}
		}
		select(new int[M][2], 0, 0);
		if (min != 99999)
			ans = min;
		System.out.println(ans);
	}

	private static void select(int[][] sel, int k, int idx) {
		if (k == M) {
			bfs(sel);
			return;
		}
		for (int i = idx; i < list.size(); i++) {
			sel[k] = list.get(i);
			select(sel, k + 1, i + 1);
		}
	}

	private static void bfs(int[][] sel) {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = map[i][j];
			}
		}
		Queue<int[]> q = new LinkedList<>();
		for (int[] n : sel) {
			q.add(new int[] { n[0], n[1], 2 });
			temp[n[0]][n[1]] = -1;
		}
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int y = now[0];
			int x = now[1];
			int sec = now[2];
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= N || temp[ny][nx] == 1)
					continue;
				if (temp[ny][nx] > 2 && temp[ny][nx] < sec + 1)
					continue;
				if (temp[ny][nx] == 0) {
					temp[ny][nx] = sec + 1;
					q.add(new int[] { ny, nx, sec + 1 });
				} else if (temp[ny][nx] != 2 && temp[ny][nx] > sec + 1) {
					temp[ny][nx] = sec + 1;
					q.add(new int[] { ny, nx, sec + 1 });
				} else if (temp[ny][nx] == 2) {
					temp[ny][nx] = -2;
					q.add(new int[] { ny, nx, sec + 1 });
				}
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (temp[i][j] == 0) return;
				if (temp[i][j] > 2) {
					max = Math.max(max, temp[i][j] - 2);
				}
			}
		}
		min = Math.min(min, max);
	}
}
