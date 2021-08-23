package algo_10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_내리막길dp {

	static int[][] graph;
	static int[][] dp;
	static int M, N;
	static int[] x = { 0, 1, 0, -1 };
	static int[] y = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = br.readLine().split(" ");
		M = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);
		graph = new int[M + 1][N + 1];
		dp = new int[M + 1][N + 1];

		for (int i = 1; i <= M; i++) {
			s = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				graph[i][j] = Integer.parseInt(s[j - 1]);
				dp[i][j] = -1;
			}
		}
		int res = dfs(1,1);
		bw.write(res + "\n");
		bw.flush();

	}

	public static int dfs(int sm,int sn) {
		int count=0;
		for (int i = 0; i < 4; i++) {
			int m = sm + y[i];
			int n = sn + x[i];
			if ((1 <= m && m <= M) && (1 <= n && n <= N)) {
				if (graph[m][n] < graph[sm][sn]) {
					if (m == M && n == N) 
					   count += 1;				
					else
					   count += dfs(m, n);
				}
			}
		}
		return count;
	}
}