package algo5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;


//접근 방식 : 상하좌우붙어있는 집만 같은단지, 대각선은 다른단지 = 8방x 4방o
//배열 탐색 -> 1발견 -> 방문배열 true -> 상하좌우의 1탐색 재귀
// 동작 -> 섹션넘버+1 -> 탐색하며 카운트+1 -> 탐색이 끝나면 카운트 저장
// 조건1 : 단지수를 출력하라 -> 섹션 출력
// 조건2 : 탐색중지시 섹션별 카운트를 오름차순으로 정렬 -> 우선순위 큐 사용

public class Main_2667단지번호붙이기 {
	static int n,cnt,section;
	static int[][] map;
	static boolean[][] check;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("단지.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//우선순위 큐 사용
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		n = Integer.parseInt(br.readLine());	
		// nxn 지도, 방문배열
		map = new int[n][n];
		check = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			String[] str = br.readLine().split("");
			
			for(int j = 0; j < n; j++) {
				map[i][j]= Integer.parseInt(str[j]);
			}
		}
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				//방문하지 않은 1 발견
				if(map[i][j]==1 && !check[i][j]) { 
					section++; //섹션 +1
					cnt = 0; //카운트 초기화
					search(i,j);
					q.add(cnt);
				}
			}
		}
		//출력
		System.out.println(section);
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
		
		
		
	}
	
	private static void search(int y, int x) {
		cnt++;
		map[y][x]=section;
		check[y][x]=true;
		print();
		//4개의 다리로 재귀씨앗 뿌림
		for(int k = 0; k < 4; k++) {
			int nr = y+dy[k];
			int nc = x+dx[k];
			if(nr>=0 && nr<n && nc>=0 && nc<n) {
				if(map[nr][nc]==1 & !check[nr][nc]) {										
					search(nr,nc);
				}
			}			
		}		
		return;		
	}

	static void print() {
		for(int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(map[i]));			
		}
		System.out.println("---------------------------------------------");
	}

}
