package algo4;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main_1966프린터큐 {
	static int T,N,M,Ans;	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T= sc.nextInt();
		for(int t = 1; t <= T; t++) {
			Ans = 0;
			N = sc.nextInt(); //문서의 갯수
			M = sc.nextInt(); //검사할 문서 위치
			Queue<int[]> q = new LinkedList<>();			
			for(int i = 0; i < N; i++) {
				int tmp = sc.nextInt();
				q.offer(new int[] {i,tmp});
			}			
			while(!q.isEmpty()) {
				int tmp[] = q.poll();
				boolean able = true;				
				for (int[] qq : q) {
					if(qq[1] > tmp[1]) {
						able = false;
					}
				}
				if(able) {
					Ans++;
					if(tmp[0]==M) break;
				}else {
					q.add(tmp);
				}						
			}
			System.out.println(Ans);	
			//System.out.println("배열 :"+Arrays.toString(arr)+" 큐 :"+q);
		}		
	}
}
