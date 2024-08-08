package week12;

import java.util.Arrays;
import java.util.Scanner;

public class KmapsackTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		int[] weights = new int[N+1]; //물건의 무게정보
		int[] profits = new int[N+1];//물건의 가치정보
		int[][] D = new int[N+1][W+1]; //해당물건까지 고려하여 해당무게를 만들떄의 최대가치
		int[] dp = new int[W+1];
		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) { //첫물건부터 고려
			for (int w = 1; w <= W; w++) { //무게 1부터 고려
				if(weights[i]<=w) { //가방에 넣을 수 있는 상황
					//넣을까
					D[i][w] = Math.max( D[i-1][ w-weights[i]] + profits[i] , D[i-1][w] );
					
					//말까
				}else { //가방에 넣지 못하는 상황 
					D[i][w] = D[i-1][w];
				}
			}
		}
		for (int i = 0; i < N+1; i++) {
			System.out.println(Arrays.toString(D[i]));
		}
		
		
		System.out.println(D[N][W]);
		
	}

}
