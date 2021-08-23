package algo7;

import java.util.Scanner;


public class Main_16987계란치기 {
	static int[] D,W;
	static int N, ans;
	static boolean broken[];
	static boolean check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		D = new int[N]; //내구도
		W = new int[N];	//무게
		broken = new boolean[N];
		for(int i = 0; i < N; i++) {
			D[i] = sc.nextInt();
			W[i] = sc.nextInt();			
		}
		solution(0,0);
		System.out.println(ans);
	}
	private static void solution(int idx,int b) {
		if(idx == N) { //인덱스 끝까지 가면			
			//맥스값 출력
			if(ans<b)ans=b;
			return;
		}		
		//손에 쥐고 있는 계란이 깨졌다면 다음계란에 대해서
		if(D[idx] <= 0) {
			solution(idx+1,b);
		}
		else {
			check = true; //동작체크
			for(int i = 0; i < N; i++) {
				int temp=0;
				//칠수있으면
				if(D[i]>0) check = false;
				//손에 쥔 계란, 깨진계란 패스
				if(i!=idx && D[i]>0) {
					D[i] -= W[idx]; //쥐고있는 계란의 무게로 i번째 내구도 깐다
					D[idx] -= W[i]; //쥐고있는 계란 내구도도 까인다.
					
					if(D[i]<=0) temp++;
					if(D[idx]<=0) temp++;						
					solution(idx+1,b+temp); // 다음계란에 대해서도 진행한다, 깨진갯수++
					D[i] += W[idx]; //복귀시 다시 더해준다
					D[idx] += W[i];
				}
			}
			//종료옵션
			if(check==false) solution(N,b);
		}
		
	}

}
