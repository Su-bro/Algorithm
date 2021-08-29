package algo2;

import java.util.Scanner;

public class Main_직사각형을만드는법 {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;
		//n이 1일경우 1~15까지 2일경유 2*m이 N을 넘지 않는선
		for(int n=1; n<=N;n++) {
			//정사각형 거르고 곱한값이 N을 넘지 않는선
			for(int m = n+1; (m*n)<=N ; m++) { 
				sum++;

			}
			
		}
		System.out.println(sum);
	}
}

/*  for 6
 *  case1 : 2 3 4 5 6
 *  case2 : 3
 *  case3 : 
 */

/*  for 15
 *  case1 : 2 3 4 5 6 7 8 9 10 11 12 13 14 15
 *  case2 : 3 4 5 6 7
 *  case3 : 4 5
*/