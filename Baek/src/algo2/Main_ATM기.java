package algo2;

import java.util.Arrays;
import java.util.Scanner;

public class Main_ATM기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N+1];
		
		for(int n=1; n<=N;n++) {		
			nums[n] = sc.nextInt();
		}
		Arrays.sort(nums);
		int ans =0;
		for(int n=1; n<=N;n++) {
			nums[n] = nums[n-1]+nums[n];
			ans += nums[n];			
		}
		System.out.println(ans);
	}
}
