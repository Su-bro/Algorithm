package algo_14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
  key = 97~102
  door = 65 70
  wall = 35
 */

public class Main_1194달이차오른다 {
	static class Cur {
		int y, x, depth, key;

		private Cur(int y, int x, int depth, int key) {
			this.y = y;
			this.x = x;
			this.depth = depth;
			this.key = key;
		}

	}

	static int N, M, map[][],dy[] = { -1, 0, 1, 0 }, dx[] = { 0, -1, 0, 1 };
	
	static boolean v[][][];

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/algo_14/달.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M][64];
		int y = 0, x = 0;

		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < c.length; j++) {
				map[i][j] = c[j];
				if (c[j] == '0') {
					map[i][j] = '.';
					y = i;
					x = j;
				}
			}
		}
		bfs(y, x);
	}
	private static void bfs(int py, int px) {
		Queue<Cur> q = new LinkedList<Cur>();
		
		q.add(new Cur(py, px, 0, 0));
		v[py][px][0] = true;

		while (!q.isEmpty()) {
			Cur now = q.poll();
			int y = now.y;
			int x = now.x;
			int key = now.key;
			int depth = now.depth;
			if (map[y][x] == '1') { // 끝지점
				System.out.println(depth);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
				if	(map[ny][nx] == '#' || v[ny][nx][key]) continue;

				if (map[ny][nx] >= 'a' && map[ny][nx] <= 'f' ) { // 열쇠를 찾았다면
					// key비트 or 키값비트 연산
					int nowKey = (1 << (map[ny][nx] - 'a')) | key;

					if (!v[ny][nx][nowKey]) {
						v[ny][nx][nowKey] = true; // 해당지점 방문
						v[ny][nx][key] = true; // key얻었다.
						q.add(new Cur(ny, nx, depth + 1, nowKey));
					}
				}

				else if (map[ny][nx] >= 'A' && map[ny][nx] <= 'F') { // 문이면
					int door = (1 << (map[ny][nx] - 'A')) & key; // 키비트와 해당 문비트 and연산(열쇠검사)

					if (door > 0) { // 오픈가능하면
						v[ny][nx][key] = true;
						q.add(new Cur(ny, nx, depth + 1, key)); // 이동
					}
				}
				else {
					v[ny][nx][key] = true;
					q.add(new Cur(ny, nx, depth + 1, key));
				}
			}			
		}
		System.out.println(-1);
	}
}
