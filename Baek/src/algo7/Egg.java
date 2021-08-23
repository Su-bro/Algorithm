package algo7;
import java.util.Scanner;

public class Egg {
	
	static int N; // 계란의 수 N으로 제한 
	static int eggCount = 0;
	
	static class EggInfo{
		int weight; // 무게
		int durab; // 내구도 durability
		
		EggInfo(){
			durab = 0;
			weight = 0;
		}
		EggInfo(int d, int w) {
			durab = d;
			weight = w;
		}
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		EggInfo[] eggs = new EggInfo[8]; // 계란 정보를 담는 배열 
		
		for(int i = 0; i < N; i++) {
			int d = sc.nextInt();
			int w = sc.nextInt();
			
			eggs[i] = new EggInfo(d, w);
		}
		
		boolean isOk[] = new boolean[8]; // false(0)로 초기화됨 
		
		//isOk[0] = true; 
		solution(eggs, isOk, 0, 0); // 0 :들고 있는 계란 / 0 : 현재 깨진 계랸 수 
		
		System.out.println(eggCount);
		sc.close();
	}


	private static void solution(EggInfo[] eggs, boolean[] isOk, int turn, int m) {
		// 지금 들고 있는 계란이 turn번째 계란이고 
		// m은 깨진 계란의 갯수 
		
		if(turn >= N) {
			eggCount = Math.max(m, eggCount); // 가장 많이 깨뜨려야해 !!!! 흠 
			return; // 가장 오른쪽 계란에 도달 
		}
		if(isOk[turn]) { // 들고 있는 계란이 깨져있다면
			// 다음 계란으로 넘겨
			solution(eggs, isOk, turn+1, m);   
		}
		else { // 계란이 안깨져있다면 
			boolean flag = true; // 칠 계란이 있는지 없는지 확인
			// 있다면 true 없다면 false
			// 안깨진 계란이 있는 상태이므로 true로 초기화 
			
			for(int i = 0; i < N; i++) { // 모든 경우의 수를 살펴보자 
				int temp = 0;
				
				// 칠 수 있는 계란이 있다면 
				if(!isOk[i]) flag = false; 
				
				// 칠 수 있는 계란이 있고 차례가 다르다면 
				if(!isOk[i] && i!=turn) { // i!=turn : 서로 다른 계란이 부딪혀야 함 .
					
					// 1. 들고 있는 계란(turn)과 선택하여 칠 계란(i)의 승부를 봐야함 
					// 2. 승부 볼 계란의 내구도 - 들고 있는 계란의 무게  <= 0 승부 볼 계란 깨짐
					// 3. 들고 있는 계란의 내구도 - 승부 계란의 무게 <= 0 들고 있는 계란 깨짐  
					eggs[turn].durab -= eggs[i].weight;
					eggs[i].durab -= eggs[turn].weight;
					
					if(eggs[i].durab <= 0) { // 2. 승부 볼 계란 깨짐
						isOk[i] = true;
						temp++;
					}
					
					if(eggs[turn].durab <= 0) { // 3. 들고 있는 계란 깨짐  
						isOk[turn] = true;
						temp++;
					}
					// 2, 3 둘다 깨질 수 있으므로 둘다 if문으로 걸어둔다. 
					// 들고 있던 계란을 자리에 내려놓고 다음 오른쪽 계란을 들고 진행해야 하므로 turn+1 을 넘기기 
					solution(eggs, isOk, turn+1, m + temp); 
					
					// 원상복귀 - dfs
					if(eggs[turn].durab <= 0) {
						isOk[turn] = false;
					}
					if(eggs[i].durab <= 0) {
						isOk[i] = false;
					}
					eggs[turn].durab += eggs[i].weight;
					eggs[i].durab += eggs[turn].weight;
					
				}
			}
			// for문 돌면서 모든 경우의 수에 다 돌아보고 오면 
			if(!flag) solution(eggs, isOk, N, m); // turn자리에 N을 넘김으로써 메소드 끝내기 
		}
		
	}

}