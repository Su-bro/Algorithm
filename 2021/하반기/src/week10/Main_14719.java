package week10;

import java.io.*;
import java.util.*;

public class Main_14719 {
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int ans = 0;
		int[][] map = new int[H][W];		
		st = new StringTokenizer(br.readLine());
		//벽이아닌곳에 1찍어
		for(int i = 0; i<W; i++) {
			int h = Integer.parseInt(st.nextToken());
			for(int j = 0; j<H-h; j++) {
				map[j][i] = 1;
			}
		}		
		//양 사이드 빈공간에서 벽만날때까지 0찍어
		for(int i = 0; i<H; i++) {
			if(map[i][0] == 1) {
				for(int j = 0; j<W; j++) {
					if(map[i][j] != 1) break;
					map[i][j] = 0;
				}				
			}			
			if(map[i][W-1] == 1) {
				for(int j = W-1; j>=0; j--) {
					if(map[i][j] != 1) break;
					map[i][j] = 0;
				}				
			}
		}
		//다 0찍고 남은 1이 빗물이겠지
		for(int i = 0; i<H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j] == 1) ans++;
			}
		}
		System.out.println(ans);
	}

}
