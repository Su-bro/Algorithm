package algo_14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_4013특이한자석 {

	static int[][] gear;
	static int Ans;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("src/algo_14/톱니바퀴.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 바퀴배열 2차원배열로 저장
		int T = Integer.parseInt(st.nextToken());		
		// k번 작업
		for (int tc = 1; tc <= T; tc++) {
			int k = Integer.parseInt(br.readLine());
			Ans = 0;
			gear = new int[4][8];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					gear[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				// 돌리는 바퀴
				int idx = Integer.parseInt(st.nextToken());
				// 돌리는 방향
				int dir = Integer.parseInt(st.nextToken());
				// idx = 2번톱니바퀴 = 1번 배열
				sol(idx - 1, dir);
			}

			if (gear[0][0] == 1) {
				Ans += 1;
			}
			if (gear[1][0] == 1) {
				Ans += 2;
			}
			if (gear[2][0] == 1) {
				Ans += 4;
			}
			if (gear[3][0] == 1) {
				Ans += 8;
			}

			System.out.println("#" + tc + " " + Ans);
		}
	}

	private static void sol(int idx, int dir) {
		left(idx - 1, dir * -1);
		right(idx + 1, dir * -1);
		// 마지막에 처음놈 로테이트
		rotate(idx, dir);
	}

	private static void rotate(int idx, int dir) {
		if (dir == 1) {
			int[] tmp = new int[8];
			tmp[0] = gear[idx][7];
			for (int j = 1; j < 8; j++) {
				tmp[j] = gear[idx][j - 1];
			}
			gear[idx] = tmp;
		}

		if (dir == -1) {
			int[] tmp = new int[8];
			tmp[7] = gear[idx][0];
			for (int j = 0; j < 7; j++) {
				tmp[j] = gear[idx][j + 1];
			}
			gear[idx] = tmp;
		}
	}

	static void left(int idx, int dir) {
		if (idx < 0)
			return;
		// 양 극이 다르면
		if (gear[idx][2] != gear[idx + 1][6]) {
			// 다음 녀석까지 검사해야함(만약 이놈이 돌면 다음놈에서 이놈 검사를 못함)
			// 도는 방향을 반대로 바꿔준다.
			left(idx - 1, -dir);
			// 다 돌고 끝나면 다시 뒤로 돌아오면서 돌리고
			rotate(idx, dir);
		}
		// 같으면 그 아래의 톱니바퀴도 돌지 않기때문에 그대로 끝.
	}

	static void right(int idx, int dir) {
		if (idx > 3)
			return;

		if (gear[idx][6] != gear[idx - 1][2]) {
			right(idx + 1, -dir);
			rotate(idx, dir);
		}
	}
}
