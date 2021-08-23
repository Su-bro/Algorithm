package algo4;

import java.util.Scanner;

public class Main_14888연산자끼워넣기 {
	static int[] cal = new int[4];
	static int[] nums;
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	static int N;	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i]=sc.nextInt();			
		}
		for(int i = 0; i<4; i++) {
			cal[i] = sc.nextInt();
		}
		dfs(nums[0],1);
		System.out.println(MAX);
		System.out.println(MIN);
	}
	
	public static void dfs(int num, int idx) {
		if (idx == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}
 
		for (int i = 0; i < 4; i++) {			
			if (cal[i] > 0) { 				
				cal[i]--; 
				switch (i) { 
				case 0:	dfs(num + nums[idx], idx + 1);	break;
				case 1:	dfs(num - nums[idx], idx + 1);	break;
				case 2:	dfs(num * nums[idx], idx + 1);	break;
				case 3:	dfs(num / nums[idx], idx + 1);	break; 
				}				
				cal[i]++;
			}
		}
	}
}