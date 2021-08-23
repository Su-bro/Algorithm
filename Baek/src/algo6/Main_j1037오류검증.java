package algo6;

import java.util.Arrays;
import java.util.Scanner;

public class Main_j1037오류검증 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][n];
		int[] r = new int[n];
		int rc = 0;
		int[] c = new int[n];
		int cc = 0;
		int di = 0;
		int dj = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		//print(map);
		
		
		for(int i = 0; i < n; i++) {
			int sum1 = 0;
			int sum2 = 0;
			for(int j = 0; j < n; j++) {
				sum1 += map[i][j];
				sum2 += map[j][i];
			}
			r[i] = sum1;
			c[i] = sum2;
		}
		
		//System.out.println(Arrays.toString(r));
		//System.out.println(Arrays.toString(c));
		
		for(int i = 0; i < n; i++) {
			if(r[i]%2!=0) {
				di=i;
				rc++;
			}
			if(c[i]!=2) {
				dj=i;
				cc++;
			}
		}
		
		//System.out.println("di:"+di+" dj:"+dj+" rc:"+rc+" cc:"+cc);
		
		if(rc==0&&cc==0) {
			System.out.println("OK");
		}else if(rc==1 && cc ==1) {
			System.out.printf("Change bit (%d,%d)\n",di+1,dj+1);
		}else {
			System.out.println("Corrupt");
		}

		
		
		
		
	}

	private static void print(int[][] map) {
		for(int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
		
	}
	
	

}
