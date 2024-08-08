package algo_13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2531회전초밥 {
	static int N, d, k, c, ans;
	static int[] arr, sushi;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/algo_13/회전초밥.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    d = Integer.parseInt(st.nextToken());
	    k = Integer.parseInt(st.nextToken());
	    c = Integer.parseInt(st.nextToken());
	     
	    sushi = new int[d+1];
	    arr = new int[N];
	    for (int i = 0; i < N; i++) {
	    	arr[i] = Integer.parseInt(br.readLine());
	    }
//	    System.out.println(Arrays.toString(arr));
	    twopointer();
	    System.out.println(ans);
	    
	}

	private static void twopointer() {
		int count = 0;
		for (int i = 0; i < k; i++) {
			if(sushi[arr[i]]==0) count++;
			sushi[arr[i]]++;
		}
		ans = count;
		
		for (int i = 1; i < N; i++) {
			if (ans <= count) {
                if (sushi[c] == 0) ans = count + 1;
                else ans = count;
            }
			sushi[arr[i-1]]--;
			if(sushi[arr[i-1]]==0) count--;
			
			if(sushi[arr[(i+k-1)%N]]==0) count++;
			sushi[arr[(i+k-1)%N]]++;
		}
	}

}
