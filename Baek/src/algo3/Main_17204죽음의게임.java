package algo3;

import java.util.Scanner;

public class Main_17204죽음의게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int num[] = new int[150];
		for(int i = 0; i<N;i++) {
			num[i]=sc.nextInt();
		}		
		
		boolean check[] = new boolean[150];		
		int count = 0;
		int nxt = 0;
		while(true) {			
			if(check[nxt]) {
				count = -1;
				break;
			}
			
			check[nxt]=true;
			nxt = num[nxt];					
			count++;
			
			if(nxt==K) {
				break;
			}
			
			
		}
		System.out.println(count);
	}

}
