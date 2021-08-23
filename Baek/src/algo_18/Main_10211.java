package algo_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10211 {
	static int T,N,arr[],max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
//			System.out.println("---------------");
			max = -1000; // -1000이상의 음수가 나옴
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int nums = 1; nums <= N; nums++) { //계산할 범위는 1부터 5까지
				for (int i = nums-1; i < N; i++) { //시작점 인덱슨는 계산할범위-1
					int sum = 0;
					for (int j = 0; j < nums; j++) { //계산할 범위만큼 sum에 이전인덱스++
						sum+=arr[i-j];
					}					
					max = Math.max(max, sum); //max값 계산
//					System.out.println("X:"+nums+", sum:"+sum+", max:"+max);
				}
			}
			
			
//			System.out.println(Arrays.toString(arr));
			System.out.println(max);
		}
	}

}


