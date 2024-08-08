package week12;
import java.util.*;
import java.io.*;

class Main_공격준비 {
	static class info{
		String log;
		int k;
		public info(String log, int k) {
			this.log = log;
			this.k = k;
		}
		@Override
		public String toString() {
			return "info [log=" + log + ", k=" + k + "]";
		}		
		
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 송수신 기록의 수 		
		String[] logs = new String[n]; // 송수신 기록
		Stack<info> stack = new Stack<info>();
		for(int i = 0 ; i < n ; i ++)
		{
			logs[i] = br.readLine();	
			if(!stack.isEmpty() && stack.peek().log.equals(logs[i])) {
				int k = stack.pop().k;
				stack.add(new info(logs[i],k+1));
			}
			else {
			stack.add(new info(logs[i],1));
			}
		}
		Stack<info> print = new Stack<info>();
		while(!stack.isEmpty()) {
			print.add(stack.pop());
		}
		System.out.println(print.size());
		while(!print.isEmpty()) {
			info i = print.pop();
			if(i.k>1) {
				System.out.println(i.log+" ("+i.k+")");
			}
			else {
				System.out.println(i.log);
			}
		}
	}
}
