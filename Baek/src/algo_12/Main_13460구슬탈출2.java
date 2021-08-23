package algo_12;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460구슬탈출2 {
	static class Ball {
		int ry, rx, by, bx, move, dir;

		public Ball(int ry, int rx, int by, int bx, int move, int dir) {
			super();
			this.ry = ry;
			this.rx = rx;
			this.by = by;
			this.bx = bx;
			this.move = move;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Ball [ry=" + ry + ", rx=" + rx + ", by=" + by + ", bx=" + bx + ", move=" + move + ", dir=" + dir
					+ "]";
		}

	}

	static int N, M, ans, map[][], dy[] = { -1, 0, 1, 0 }, dx[] = { 0, -1, 0, 1 };
	static boolean v[][][][];

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/algo_12/구슬탈출.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int ry = 0, rx = 0;
		int by = 0, bx = 0;
		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (c[j] == 'R') {
					ry = i;
					rx = j;
					map[i][j] = '.';
				} else if (c[j] == 'B') {
					by = i;
					bx = j;
					map[i][j] = '.';
				} else
					map[i][j] = c[j];
			}
		}
		v = new boolean[N][M][N][M];

		Queue<Ball> q = new LinkedList<Ball>();
		q.add(new Ball(ry, rx, by, bx, 0, -1));

		while (!q.isEmpty()) {
			Ball now = q.poll();
			//System.out.println(now.toString());
			if (map[now.by][now.bx] == 'O') {
                continue;
            } else if (now.move == 11) {
                continue;
            }

            // 성공!
            if (map[now.ry][now.rx] == 'O') {
                System.out.println(now.move);
                System.exit(0);
            }
			
			
			
			int Ry = now.ry;
			int Rx = now.rx;
			int By = now.by;
			int Bx = now.bx;
			v[Ry][Rx][By][Bx] = true;
			for (int d = 0; d < 4; d++) {
				Ball next = move(now, d);
				if (v[next.ry][next.rx][next.by][next.bx])
					continue;
				q.add(next);
				v[Ry][Rx][By][Bx] = true;
			}
		}
		System.out.println(-1);
	}

	private static Ball move(Ball now, int d) {
		Ball next = new Ball(now.ry, now.rx, now.by, now.bx, now.move, now.dir);
		int ny = 0, nx = 0;
		int flag = 0;
		switch (d) {

		case 0: // 상
			if (next.ry > next.by) // 파란공이 더 위에 있으면
				// 위에 있는 파란 공 먼저 움직임.(0)
				flag = 0;
			else
				flag = 1;
			break;
		case 1: // 좌
			if (next.rx > next.bx) // 파란공이 더 왼쪽 있으면
				// 왼쪽에 있는 파란 공 먼저 움직임.(0)
				flag = 0;
			else
				flag = 1;

			break;
		case 2: // 하
			if (next.ry > next.by) // 빨간공이 더 아래 있으면
				// 아래에 있는 빨간 공 먼저 움직임.(1)
				flag = 1;
			else
				flag = 0;

			break;
		case 3: // 우
			if (next.rx > next.bx) // 빨간공이 더 오른쪽 있으면
				// 오른쪽에 있는 빨간 공 먼저 움직임.(1)
				flag = 1;
			else
				flag = 0;

			break;
		}// end of switch

		// 파란공 먼저 움직이는 경우
		if (flag == 0) {
			/// 파란공 move start
			ny = next.by + dy[d];
			nx = next.bx + dx[d];
			while (map[ny][nx] == '.') {
				ny += dy[d];
				nx += dx[d];
			}
			if (map[ny][nx] == 'O') {
				next.by = ny;
				next.bx = nx;
			} else {
				next.by = ny - dy[d];
				next.bx = nx - dx[d];
			}
			/// 파란공 move end

			/// 빨간공 move start
			ny = next.ry + dy[d];
			nx = next.rx + dx[d];
			while (map[ny][nx] == '.') {
				if (ny == next.by && nx == next.bx) break;
				ny += dy[d];
				nx += dx[d];
			}
			if (map[ny][nx] == 'O') {
				next.ry = ny;
				next.rx = nx;
			} else {
				next.ry = ny - dy[d];
				next.rx = nx - dx[d];
			}
			/// 빨간공 move end

		}
		// 빨간공 먼저 움직이는 경우
		else if (flag == 1) {
			ny = next.ry + dy[d];
			nx = next.rx + dx[d];
			while (map[ny][nx] == '.') {
				ny += dy[d];
				nx += dx[d];
			}
			if (map[ny][nx] == 'O') {
				next.ry = ny;
				next.rx = nx;
			} else {
				next.ry = ny - dy[d];
				next.rx = nx - dx[d];
			}

			ny = next.by + dy[d];
			nx = next.bx + dx[d];
			while (map[ny][nx] == '.') {
				if (ny == next.ry && nx == next.rx) break;
				ny += dy[d];
				nx += dx[d];
			}
			if (map[ny][nx] == 'O') {
				next.by = ny;
				next.bx = nx;
			} else {
				next.by = ny - dy[d];
				next.bx = nx - dx[d];
			}
		}

		next.dir = d;
		next.move++;
		return next;
	}

}
