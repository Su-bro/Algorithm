package week10;

import java.io.*;
import java.util.*;

public class Main_15654_N과M5 {
	static int N,M,nums[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}		
		Arrays.sort(nums);
//		System.out.println(Arrays.toString(nums));
		dfs(new int[M],0,0,new boolean[N]);
		
	}
	private static void dfs(int[] sel, int idx, int k,boolean[] v) {
		if(k==M) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;						
		}
		for(int i = 0; i<N; i++) {
			if(v[i]) continue;
			sel[k] = nums[i];
			v[i] = true;
			dfs(sel, idx+1, k+1,v);
			v[i] = false;
			
		}
	}

}
