package week10;

import java.util.*;
import java.io.*;
public class Main_13458_시험감독 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] map = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		long Ans = (long) 0;
		for (int i = 0; i < map.length; i++) {	
			int cnt = map[i];
			Ans++;
			cnt-=B;
			if(cnt < 0) {
				cnt =0;
			}
			Ans+=cnt/C;
			if(cnt%C != 0) {
				Ans++;
			}
		}
		System.out.println(Ans);		
	}
}
