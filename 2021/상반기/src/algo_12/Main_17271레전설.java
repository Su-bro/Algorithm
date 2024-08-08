package algo_12;

import java.util.Scanner;
public class Main_17271레전설 {
	static int fight_time,Bskill_time,dp[];
	public static void main(String[] args) {
		//System.setIn(new FileInputStream("src/algo_12/레전설.txt"));
		Scanner sc = new Scanner(System.in);
		fight_time = sc.nextInt();
		Bskill_time = sc.nextInt();
		dp = new int[fight_time+1];		
		dp[0] = 1;
		for (int i = 1; i <= fight_time; i++) {
			dp[i] = dp[i-1]; //시간이 1초 추가되면 전보다 많이 쓸수있으니까 들고가자.
			if(i-Bskill_time>=0) { //지금시간-b스킬시간이 0보다 크거나같으면 b스킬시간 한번이상 쓸수있지
				// i-Bskill_time초에서 스킬사용한만큼 i초에서 쓸 수 있지
				dp[i] = (dp[i] + dp[i-Bskill_time])%1000000007;
			}
			
		}
		//System.out.println(Arrays.toString(dp));
		System.out.println(dp[fight_time]);
	}
}
