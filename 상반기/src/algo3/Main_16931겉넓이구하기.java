package algo3;

import java.util.Scanner;

public class Main_16931겉넓이구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int map[][] = new int[1000][1000];		
		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int sum = 0;
				
		for (int i = 1; i <=N; i++)
	    {
	        for (int j = 1; j <=M; j++)
	        {
	        	map[i][j] = sc.nextInt();
	        }
	    }
		
		for (int i = 1; i <=N; i++)
	    {
	        for (int j = 1; j <=M; j++)
	        {
	        	sum+=2;
	        	for(int k=0; k<4; k++) {
	        		int rx = i + dx[k];
	        		int ry = j + dy[k];
	        		int dif = 0;
	        		if(map[i][j]>map[rx][ry]) {
	        			dif = map[i][j] - map[rx][ry];
	        		}
	        		sum+=dif;	        		
	        	}	        	
	        }
	    }
		System.out.println(sum);
		
	}

}
