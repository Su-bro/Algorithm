package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18233_러버덕을사랑하는모임 {
	static int N, P, E;
	static int[][] arr;
	static int[] num, doll;
	static boolean[] visit;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		arr = new int[N][2];
		num = new int[P];
		doll = new int[N];
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		dfs(0,0);
		for(int k : doll) {
			sb.append(k).append(" ");
		}
		System.out.println(flag?sb:-1);
	}

	private static void dfs(int cnt, int start) {
		if (cnt == P) {
			int min = 0, max = 0;
			for (int i = 0; i < P; i++) {
				min += arr[num[i]][0];
				max += arr[num[i]][1];
			}
			
			// E가 min과 max 범위 안에 있는지
			if (!(min <= E && E <=max))
				return;
			// 남은 인형의 개수
			int div = E - min;
			
			// 조건을 만족할 경우 -1을 출력하지 않음
			flag = true;
			for (int i = 0; i < P; i++) {
				// 해당하는 사람에게 인형을 주고 남은 인형을 분배하는 로직
				doll[num[i]] = arr[num[i]][0];
				if(div==0) continue;
				int get = arr[num[i]][1] - arr[num[i]][0];
				if (div > get) {
					div -= get;
					doll[num[i]]+=get;
				}else {
					doll[num[i]]+=div;
					div=0;
				}	
			}
			
			return;
		}
		for (int i = start; i < N; i++) {
			if (arr[i][0] <= E) {
				num[cnt] = i;
				dfs(cnt + 1, i+1);
				// 하나라도 만족할 경우 모두 종료시킴.
				if (flag)
					return;
			}
		}
	}

}