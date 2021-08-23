package algo2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Main_Coordinate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// Nx2 배열 생성
		int[][] nums = new int[N][2]; 
		
		for(int n=0;n<N;n++) {
			nums[n][1] = sc.nextInt();
			nums[n][0] = sc.nextInt();
		}		
		Arrays.sort(nums, new Comparator<int[]>() {
			@Override
			public int compare(int[] t1, int[] t2) {
				if(t1[0]==t2[0]) return Integer.compare(t1[1], t2[1]);
				return Integer.compare(t1[0], t2[0]);
			}
		});
		
		for(int a=0;a<N;a++)
		System.out.println(nums[a][1]+" "+nums[a][0]);
		sc.close();
	}
}
