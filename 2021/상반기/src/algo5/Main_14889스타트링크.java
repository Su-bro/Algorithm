package algo5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_14889스타트링크 {
	static int n;
	
	static int[][] map;
	static boolean[] check;	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		n = Integer.parseInt(br.readLine());		
		map = new int[n][n];
		
		check = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < n; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		combination(0,0);
		System.out.println(min);
		
	}
	

	static void combination(int idx, int k) {
		if(k == n/2) {			
			calc();			
			return;
		}
		
		for(int i = idx; i < n; i++) {
			if(!check[i]) {
				check[i]=true;
				combination(i+1, k+1);
				check[i]=false;
			}
		}
	}



	static void calc() {
		int trueTeam = 0;
		int falseTeam = 0;
		for(int i = 0; i < n-1; i++) {
			for(int j = i+1; j < n; j++) {
				if(check[i]==true && check[j]==true) {					
					trueTeam+=map[i][j];
					trueTeam+=map[j][i];
					
				}else if(check[i]==false && check[j]==false) {
					falseTeam+=map[i][j];
					falseTeam+=map[j][i];
				}					
				
			}
		}		
		int diff = Math.abs(trueTeam-falseTeam);
		if (diff == 0) {
			System.out.println(diff);
			System.exit(0);
		}
		min = Math.min(diff, min);
		
	}
}
