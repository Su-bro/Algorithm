package algo7;

import java.util.Scanner;


public class Main_16987계란치기2 {
	static int[] D,W;
	static int N, ans;
	static boolean check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		D = new int[N]; //내구도
		W = new int[N];	//무게	
		for(int i = 0; i < N; i++) {
			D[i] = sc.nextInt();
			W[i] = sc.nextInt();			
		}
		solution(0);
		System.out.println(ans);
	}
	private static void solution(int idx) {
		if(idx == N) { //인덱스 끝까지 가면
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				//깨진 갯수 카운트
				if(D[i]<=0) cnt++;				
			}
			//맥스값 출력
			if(ans<cnt)ans=cnt;
			return;
		}		
		//손에 쥐고 있는 계란이 깨졌다면 다음계란에 대해서
		
		check = false; //동작 했는지 검사
		for(int i = 0; i < N; i++) {				
			//손에 쥔 계란, 깨진계란 패스
			if(i==idx || D[i]<=0 || D[idx]<=0) continue;
			check=true; //동작체크
			D[i] -= W[idx]; //쥐고있는 계란의 무게로 i번째 내구도 깐다
			D[idx] -= W[i]; //쥐고있는 계란 내구도도 까인다.
			solution(idx+1); // 다음계란에 대해서도 진행한다.
			D[i] += W[idx]; //복귀시 다시 더해준다
			D[idx] += W[i];
		}
		//동작하지 않는다면  다음 계란을 쥔다
		if(check==false) solution(idx+1);
		
		
	}

}
