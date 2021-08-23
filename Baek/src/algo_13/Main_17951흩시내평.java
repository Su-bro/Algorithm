package algo_13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17951흩시내평 {
	/*
	  K그룹 -> 두 시험지 합
	  순서대로 시험지 점수 더한거, 나머지 더한거 비교, 제일 작은거
	  시험지 점수 합이 high값을 낮춰가면서 low+hig/2 보다 크면 
	  보다 작은 다른그룹의 시험점수가 최대	  
	  high 초기값은 시험 점수 총합으로 하는게?
	  low는 0점?
	 
	 */
	static int N,K,arr[],ans;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/algo_13/흩시내평.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		int high = 0;
		int low = 0;
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			arr[i] = temp;
			high += temp;
		}
		
		while(low <= high) {
			int mid = (low + high) / 2;
			int score = 0;
			int min = Integer.MAX_VALUE;
			int count = 1;
			boolean flag = false;
			
			for (int i = 0; i < N; i++) {
				score += arr[i]; // 순서대로 더해본다
				if(score >= mid) { //더한값이 mid보다 크다?
					min = Math.min(min, score); //최소점수에 넣고
					score = 0; //스코어는 0
					count++; //다음그룹으로
					
					if(count > K) { //그룹 전부 체크했다면(score가 mid보다 크다면)
						flag = true; //전부했다.
						break; //전부했으니까 break;
					}
				}
			}
			
			
			if (flag) { //전부 체크했다면(score가 mid보다 크다면)
	            low = mid + 1; //low 조절
	          //해당 탐색의 min점수의 최대값
	            ans = Math.max(ans, min); //답 저장해주고
	          
	        }
	        else high = mid - 1; //전부 체크 못했으면(score가 mid보다 작다면)
			//high 조절
		}
		System.out.println(ans);
		
	}

}
