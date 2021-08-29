package algo_16;


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main_2302극장 {
	
	// ㅁ ㅁ ㅁ ㅁ ㅁ ㅁ
	// N=1,1가지 / N=2,2가지 / N=3,3가지 / N=4,5가지
	// N(n) = (N(n-2) + N(n-1) )가지
	//점화식 = dp[N] = dp[N - 2] + dp[N - 1]
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] dp = new int[N+1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		
		
		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2]; //점화식배열 미리 만들어둠
		}
//		System.out.println(Arrays.toString(dp));

		int ans = 1;

		// vip 좌석을 제외한 나머지 좌석의 경우의 수를 서로 곱함.
		int beforeSeat = 0;
		for (int i = 0; i < M; i++) {
			int temp = sc.nextInt();
			ans *= dp[temp - beforeSeat - 1];      //점화식배열
			//vip == 4, (4-0-1) = 3 1,2,3 3개의 경우의수dp[3]=3를 ans에 곱함
			//vip ==7, (7-4-1) =2 1,2 2개의 경우의수dp[2]=2를 ans에 곱함
			beforeSeat = temp; // 4  -> 7
			
		}
		ans *= dp[N - beforeSeat]; // 마지막 vip 좌석 다음 좌석에서 끝 좌석까지의 경우의 수.
		//(9-7) = 2, dp[2] = 2 를 ans에 곱함
		System.out.println(ans);
	}

}