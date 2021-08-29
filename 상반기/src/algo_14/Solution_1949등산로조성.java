package algo_14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1949등산로조성 {
	static class Node {
		int y, x, h, len;
		boolean gongsa;

		private Node(int y, int x, int h, int len, boolean gongsa) {
			this.y = y;
			this.x = x;
			this.h = h;
			this.len = len;
			this.gongsa = gongsa;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", h=" + h + ", len=" + len + ", gongsa=" + gongsa + "]";
		}

	}

	static int map[][], T, N, K, dy[] = { 0, 0, 1, -1 }, dx[] = { 1, -1, 0, 0 }, ans;
	static boolean[][] v;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/algo_14/등산로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			ArrayList<Node> list = new ArrayList<Node>();
			ans = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			int max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) {
						list.add(new Node(i, j, max, 1, true));
					}
				}
			}
			for (Node node : list) {
				v = new boolean[N][N];
				v[node.y][node.x] = true;
				dfs(node);
//				System.out.println(ans);
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void dfs(Node node) {
		int y = node.y;
		int x = node.x;
		int h = node.h;
		int len = node.len;
		boolean gongsa = node.gongsa;
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 0 || nx < 0 || ny >= N || nx >= N || v[ny][nx])
				continue;
			if (map[ny][nx] < h) {
				v[ny][nx] = true;
				dfs(new Node(ny, nx, map[ny][nx], len + 1, gongsa));
				v[ny][nx] = false;
//				System.out.println(now+"->직진:"+new Node(ny, nx, map[ny][nx], len+1, gongsa));
			} else {
				if (map[ny][nx] < h + K && gongsa) {
					v[ny][nx] = true;
					dfs(new Node(ny, nx, h - 1, len + 1, false));
					v[ny][nx] = false;
//					System.out.println(now+"->깎아서:"+map[ny][nx]+new Node(ny, nx, h-1, len+1, false));
				}
			}
		}
		ans =Math.max(ans, len);
	}
}
