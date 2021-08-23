package algo4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main_12873기념품 {
	static double k;
	static int move;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<Integer>();
		int n = sc.nextInt();
		for(int i = 1; i <=n; i++) {
			q.add(i);
		}
		double k = 1;
		while(q.size()>1) {
			move = (int)(k*k*k)%q.size();
			
			if(move==0) {
				for(int i = 1; i < q.size(); i++) {
					int tmp = q.poll();
					q.offer(tmp);
				}
				q.poll();
				k++;
			}else {
				for(int i = 1; i <move ; i++) {
					int tmp = q.poll();
					q.offer(tmp);
				}
				q.poll();
				k++;			
			}				
		}		
		System.out.println(q+" "+move);
	}

}
/*


1 1  %10
1 2 3 4 5 6 7 8 9 10
1 2 3 4 5
1 2 3


2 8  %9
2 3 4 5 6 7 8 9 10 
2 3 4 5
2 3

3 27 %8
2 3 4 6 7 8 9 10 
2

4 64 %7
2 4 6 7 8 9 10


5 125

6 216

7 343

8 512

9 729

10  1000
*/



