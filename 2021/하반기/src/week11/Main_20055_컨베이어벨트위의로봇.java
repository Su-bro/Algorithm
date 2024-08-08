package week11;

import java.util.*;
import java.io.*;
public class Main_20055_컨베이어벨트위의로봇 {
	static int N,K,map[][],cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		map = new int[2*N][2];
		for (int i = 0; i < 2*N; i++) {
			map[i][0] = Integer.parseInt(st.nextToken());			
		}
		int dan = 0;
		while(true) {			
			// 1. 단계올리기
			dan++;			
			// 2. 벨트회전
			int[] temp = map[0];
			map[0] = map[(N*2)-1];
			for(int i=1; i<N*2; i++) {
				int[] temp2 = map[i];
				map[i] = temp;
				temp = temp2;
			}			
			// 3. 내리기
			if(map[N-1][1] == 1) map[N-1][1] = 0;			
			// 4. 로봇이동
			for(int i = N-2; i>=0; i--) {
				if(map[i][1] == 1) {
					if(map[i+1][0] > 0 && map[i+1][1] == 0) {
						map[i][1] = 0;
						map[i+1][1] = 1;
						map[i+1][0]--;
					}
				}
			}			
			// 5. 내리기
			if(map[N-1][1] == 1) map[N-1][1] = 0;			
			// 6. 내구도 검사
			cnt = 0;
			for(int[] n : map) {
				if(n[0]==0) cnt++;
			}			
			// 7. 로봇 올리기
			if(map[0][0] > 0) {
				map[0][1] = 1;
				map[0][0]--;
				if(map[0][0] == 0) cnt++;
			}			
			// 8. 내구도검사
			if(cnt>=K) break;
			
		}
		System.out.println(dan);		
		
	}
}

/*
3 2
1 2 3 4 5 6

*/