package week14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_16437양구출작전 {
	
	static int N;
	static int[] vertex;
	static List<Integer>[] edgeList;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
			N = Integer.parseInt(br.readLine());
			vertex = new int[N + 1];
			edgeList = new ArrayList[N + 1];
			visit = new boolean[N + 1];
			for (int i = 0; i <= N; ++i) edgeList[i] = new ArrayList<>();
			for (int i = 2; i <= N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String kind = st.nextToken();
				int cnt = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				vertex[i] = kind.equals("S") ? cnt : -cnt;
				edgeList[to].add(i);
			}
			
			bw.write(dfs(1) + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static long dfs(int v) {
		if (edgeList[v].isEmpty()) return vertex[v] > 0 ? vertex[v] : 0;
		
		visit[v] = true;
		long sum = vertex[v];
		for (int nv : edgeList[v]) {
			if (visit[nv]) continue;
			sum += dfs(nv);
		}

		return sum > 0 ? sum : 0;
	}
}