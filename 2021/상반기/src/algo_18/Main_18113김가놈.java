package algo_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18113김가놈 {
	static int N,K,M,max,arr[],P;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		max = 0;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = -1;
		arr = new int[N+1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		int left = 1; 
		int right = max-K; 
		while(left<=right) {
			int mid = (left+right)/2;
			if(check(mid)) {
				P = Math.max(P,mid);
				left = mid+1;
			}else {
				right = mid-1;
			}
		}		
		System.out.println(P);
	}
	
	private static boolean check(int mid) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if(arr[i] >= 2*K) {
				cnt += (arr[i]-2*K) /mid;
			}else if (arr[i] < 2*K && arr[i]>K) {
				cnt+= (arr[i]-K)/mid;
			}
		}		
		return cnt>=M;
	}

}
