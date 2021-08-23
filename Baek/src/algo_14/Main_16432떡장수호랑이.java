package algo_14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_16432떡장수호랑이 {
	
	static boolean v[][];
	static int N;
	static int give[];
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/algo_14/떡.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		v = new boolean[N][10]; // 날짜별로 호랑이한테 뺏긴 기록 (1~9)
		give = new int[N]; //날짜별로 호냥이한테 적선할 떡의 배열
		list = new ArrayList[N]; //날짜별로 가직고 있는 떡리스트 배열
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			list[i] = new ArrayList<Integer>();
			// 어레이리스트타입 배열 초기화
			for (int j = 0; j < k; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}			
		}
		dfs(0,0); //dfs
		
		//떡대신 머리통
		System.out.println(-1);		
	}
	private static void dfs(int idx,int k) {
		if(idx == N) { //매일 떡을 뺏겼으면 
			for (int i = 0; i < N; i++) {
				//뺏긴 떡 차례대로 출력
				System.out.println(give[i]);
			}
			//바로 종료
			System.exit(0);
		}
		for (int i = 1; i < 10; i++) {
			// 뺏긴 떡이 전날과 동일하지 않고, 해당 날짜에 줘봤던 떡이 아닌 현재 들고있는 떡에 대해
			if(i!=k && list[idx].contains(i) && !v[idx][i]) {				
				v[idx][i] = true; //뺏김 기록
				give[idx] = i; //idx날짜에 i떡 뺏김
				dfs(idx+1,i); //내일보자 호냥이쉑, i->k로들고가
			}
		}		
		//줄 수 있는 떡이 없으면			
//		System.out.println(-1);	 --> 틀림
//		System.exit(0);
	}
}

// 틀렸던 이유1 : 시간초과 없애려고 for문 끝날때 떡 못주는걸로 판단, -1 출력하고 시스템종료시킴
// 생각해보니 첫번째 경우에 떡을 못주더라도 다음 경우에 줄 수 있는데
// 너무 성급하게 삶을 포기하고 머리통을 내줬음

// 이유 2 : 문제를 똑바로 안읽음
// 전날과 똑같은 떡을 안먹는건데 먹어봤던 떡을 안먹는걸로 착각 
// 호랑이성님을 너무 양아치로보고 어렵게 접근했음
