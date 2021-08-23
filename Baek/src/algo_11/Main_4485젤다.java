package algo_11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4485젤다 {

	static class Cur implements Comparable<Cur> {
		int y;
		int x;
		int w;

		public Cur(int y, int x, int w) {
			super();
			this.y = y;
			this.x = x;
			this.w = w;
		}

		@Override
		public int compareTo(Cur c) {
			// TODO Auto-generated method stub
			return w - c.w;
		}

	}

	static int dy[] = { -1, 1, 0, 0 }, dx[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// System.setIn(new FileInputStream("src/algo_11/젤다.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = 1;

		while (true) {
			int ans = 0;
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break; // 0찍어주면 종료

			int[][] map = new int[n][n];
			int[][] dij = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dij[i][j] = Integer.MAX_VALUE; // 다익스트라배열은 맥스로 체워준다
				}
			}
			// 시작지점 코스트.
			dij[0][0] = map[0][0];
			// print(map);

			// bfs용 큐
			Queue<Cur> q = new LinkedList<>();
			// 수정 : Queue에서 가중치를 기준으로 comparable한 PriorityQueue 변경
			// 이유 : 작은 가중치를 먼저 고려하기 때문에 다른 자식에서 해당 커서를 바라볼 때
			// 갓차피 작은 가중치합산으로 dij배열을 갱신해줬기때문에 빠른패스가능
			// 즉, 최소가중치를 미리 가져와서 다익스트라 배열을 만들어준다면 시간을 아낄 수 있다.
			// 앵 아니네??????????

			// 시작지점 add
			q.add(new Cur(0, 0, map[0][0]));
			while (!q.isEmpty()) {
				// 커서
				Cur cur = q.poll();
				int y = cur.y;
				int x = cur.x;
				for (int d = 0; d < 4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];

					if (ny < 0 || nx < 0 || ny >= n || nx >= n || dij[ny][nx] <= dij[y][x] + map[ny][nx])
						continue;
					// 자식 커서에 해당하는 다익스트라 배열값이
					// 현재위치의 다익스트라배열값 + map 자식의 가중치보다 클 경우 최소거리 갱신

					dij[ny][nx] = dij[y][x] + map[ny][nx];
					// 자식 커서에 해당하는 다익스트라 배열값은 현재 다익스트라배열값 + 자식의 가중치
					q.add(new Cur(ny, nx, map[ny][nx])); // 큐에 자식add

				}

			}
			// print(dij);
			ans = dij[n - 1][n - 1];// 목표위치의 다익배열값은 결국 최소스패닝

			System.out.println("Problem " + t + ": " + ans);
			t++;
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}

	}

}
