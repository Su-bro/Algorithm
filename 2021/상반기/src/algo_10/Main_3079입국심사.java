package algo_10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3079입국심사 {
	static int n,m;
	static int[] gate;
	static long maxHigh = 0;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("입국심사.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		gate = new int[n];
		for (int i = 0; i < n; i++) {
			gate[i] = Integer.parseInt(br.readLine());
			maxHigh = Math.max(maxHigh, gate[i]);
		}
		
		binarySearch();		
	}
	private static void binarySearch() {
		long left = 0;
		long right = maxHigh * m;
		long result = Long.MAX_VALUE;
				
		while (left <= right) { 	
			long mid = (left + right) / 2; 
			long sum = 0;			
			for (int i = 0; i < n; i++) {
				sum += mid / gate[i];				
			}			
			if(sum >= m){
				result = Math.min(result, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(result);
	}
}

