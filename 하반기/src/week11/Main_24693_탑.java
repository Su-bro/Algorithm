package week11;
/*



*/
import java.io.*;
import java.util.*;
public class Main_24693_탑 {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stn.nextToken());
		stn = new StringTokenizer(br.readLine());
		Stack<int[]> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {			
			int NI = Integer.parseInt(stn.nextToken());				
			while(!st.isEmpty()) {
				if(st.peek()[1] >= NI) {
					sb.append(st.peek()[0]+" ");
					break;
				}				
				st.pop();				
			}			
			if(st.isEmpty()) {
				sb.append(0+" ");				
			}			
			st.push(new int[] {i,NI});			
		}
		System.out.println(sb.toString());
	}		
}
