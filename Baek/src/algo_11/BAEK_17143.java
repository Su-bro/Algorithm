package algo_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BAEK_17143 {
	static int R, C, M;
	static shark[][] map;
	static int ans;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new shark[R + 1][C + 1];
		for (int i = 1; i < R + 1; i++) {
			for (int j = 1; j < C + 1; j++) {
				map[i][j] = new shark(0, 0, 0, false);
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			// System.out.println(r+" "+c);
			map[r][c].s = Integer.parseInt(st.nextToken());
			map[r][c].d = Integer.parseInt(st.nextToken());
			map[r][c].z = Integer.parseInt(st.nextToken());
			map[r][c].flag = true;
		}
//		get_shark(1);
//		move_shark();
//		print();
		for (int fishing = 1; fishing < C + 1; fishing++) {
			get_shark(fishing);
			move_shark();

		}
		System.out.println(ans);

	}

	private static void print() {
		for (int i = 1; i < R + 1; i++) {
			for (int j = 1; j < C + 1; j++) {
				System.out.print(map[i][j].flag + " ");
			}
			System.out.println();
		}
	}

	private static void move_shark() {
		int[] dx = { 0, 0, 0, 1, -1 };
		int[] dy = { 0, -1, 1, 0, 0 };
//		print();
//		System.out.println();
		ArrayList<move_shark> move_shark = new ArrayList<>();
		for (int i = 1; i < R + 1; i++) {
			for (int j = 1; j < C + 1; j++) {
				if (map[i][j].flag) {// �� ������
					int s = map[i][j].s;
					int nx = j;
					int ny = i;
					int d = map[i][j].d;
					if (d == 1 || d == 2) {
						int rotate = (R - 1) * 2;
						if (s >= rotate)
							s = s % rotate;
						for (int k = 0; k < s; k++) {

							nx = nx + dx[d];
							ny = ny + dy[d];
							if (nx < 1 || nx >= C + 1 || ny < 1 || ny >= R + 1) {
								//System.out.println("befor: " + "ny: " + ny + " " + "nx: " + nx);
								nx = nx - dx[d];
								ny = ny - dy[d];
								if (d == 1) {
									d = 2;
								} else if (d == 2) {
									d = 1;
								} else if (d == 3) {
									d = 4;
								} else if (d == 4) {
									d = 3;
								}
								k--;
								// continue;
							}
						}
					}
					if (d == 3 || d == 4) {
						int rotate = (C - 1) * 2;
						if (s >= rotate)
							s = s % rotate;
						for (int k = 0; k < s; k++) {

							nx = nx + dx[d];
							ny = ny + dy[d];
							if (nx < 1 || nx >= C + 1 || ny < 1 || ny >= R + 1) {
								///System.out.println("befor: " + "ny: " + ny + " " + "nx: " + nx);
								nx = nx - dx[d];
								ny = ny - dy[d];
								if (d == 1) {
									d = 2;
								} else if (d == 2) {
									d = 1;
								} else if (d == 3) {
									d = 4;
								} else if (d == 4) {
									d = 3;
								}
								k--;
								// continue;
							}
						}
					}
					move_shark.add(new move_shark(ny, nx, s, d, map[i][j].z, true));
					map[i][j].flag = false;
					map[i][j].d = 0;
					map[i][j].s = 0;
					map[i][j].z = 0;
				}
			}
		}

		for (int i = 0; i < move_shark.size(); i++) {
			int r = move_shark.get(i).r;
			int c = move_shark.get(i).c;
			int d = move_shark.get(i).d;
			int z = move_shark.get(i).z;
			int s = move_shark.get(i).s;
			if (map[r][c].flag) {
				if (map[r][c].z < z) {// ���� �ִ� ���� ���� �� �� �� ũ��
					map[r][c].s = s;
					map[r][c].d = d;
					map[r][c].z = z;
				} else {
					continue;// ���� ������ �� �� ������ �ƹ��͵� ���ϰ� �н�
				}
			} else {
				map[r][c].s = s;
				map[r][c].d = d;
				map[r][c].z = z;
				map[r][c].flag = true;
			}

		}

	}

	private static void get_shark(int fishing) {
		for (int i = 1; i < R + 1; i++) {
			if (map[i][fishing].flag) {
				// System.out.println("fsdf");
				ans += map[i][fishing].z;
				map[i][fishing].flag = false;
				map[i][fishing].s = 0;
				map[i][fishing].d = 0;
				map[i][fishing].z = 0;

				break;
			}
		}

	}

}

class shark {
	int s, d, z;
	boolean flag;

	public shark() {
		super();
	}

	public shark(int s, int d, int z, boolean flag) {
		super();

		this.s = s;
		this.d = d;
		this.z = z;
		this.flag = flag;
	}

}

class move_shark {
	int r, c, s, d, z;
	boolean flag;

	public move_shark() {
		super();
	}

	public move_shark(int r, int c, int s, int d, int z, boolean flag) {
		super();
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
		this.flag = flag;
	}

}