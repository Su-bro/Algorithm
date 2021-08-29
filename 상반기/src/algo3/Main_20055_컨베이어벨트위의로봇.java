package algo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20055_컨베이어벨트위의로봇 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String b = br.readLine();
		StringTokenizer st  = new StringTokenizer(b);
		int count = 0;
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] belt = new int[N*2];
		int[] inout = new int[N*2];
		String b2 = br.readLine();
		StringTokenizer st2 = new StringTokenizer(b2);
		
		for(int i=0;i<N*2;i++) {
			belt[i]=Integer.parseInt(st2.nextToken());
		}
		inout[N-1] = 2;
		inout[0] = 1;
		
		System.out.println(Arrays.toString(belt));
		System.out.println(Arrays.toString(inout));
		
		
		
	}

}