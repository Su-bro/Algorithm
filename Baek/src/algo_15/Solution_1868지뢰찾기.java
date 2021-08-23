package algo_15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution_1868지뢰찾기 {
	static class Info implements Comparable<Info>{
		int y,x,value,zeroCnt;

		private Info(int y, int x, int value, int zeroCnt) {
			super();
			this.y = y;
			this.x = x;
			this.value = value;
			this.zeroCnt = zeroCnt;
		}
		@Override
		public String toString() {
			return "Info [y=" + y + ", x=" + x + ", value=" + value + ", zeroCnt=" + zeroCnt + "]";
		}
		@Override
		public int compareTo(Info o) {
			if(value == o.value) {
				return o.zeroCnt - zeroCnt;
			}else
				return value - o.value;
		}
		
	}	
	static boolean[][] v;
	static int map[][],N,ans,groundCnt,marked;
	static int[] dy = {-1,-1, 0, 1, 1, 1, 0,-1};
	static int[] dx = { 0,-1,-1,-1, 0, 1, 1, 1};
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/algo_15/지뢰찾기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {			
			ans = 0;
			marked = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				char[] c = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = c[j];
				}
			}			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == '.') {
						//이곳이 땅이라면 주변에 지뢰가 몇개있는지 숫자체크
						map[i][j] = countMine(i,j);
					}
				}
			}
			ArrayList<Info> groundList = new ArrayList<Info>();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]<9) {
						int zeroCnt = countZero(i,j);
//						System.out.println(zeroCnt);
						groundList.add(new Info(i, j, map[i][j], zeroCnt));
					}
				}
			}
			
			//그라운드 리스트를 땅에적힌숫자기준 오름차순 정렬, 
			// 땅주변의 0의갯수 기준 내림차순 정렬
			Collections.sort(groundList); 
			
			//그라운드리스트의 사이즈가 곧 땅의 갯수이다.
			groundCnt = groundList.size();
			
			
			for (int i = 0; i < groundCnt; i++) {								
				Info now = groundList.get(i); //클릭한 녀석의 정보
				if(!v[now.y][now.x]) { //아직 밝혀준 땅이 아니라면
					ans++; //클릭해라
					v[now.y][now.x] = true; //밝혀준다.
					
					System.out.println(now+"nowgroud");
					marked++; //밝힌 땅 하나 추가요					
					if(map[now.y][now.x] == 0) { //만약 지금 밟은 땅이 0이라면
						ChainReact(now.y,now.x); //연쇄반응
					}					
				}
				
				
				if(marked == groundCnt) { //땅의 갯수만큼 밝혀줬다면
					break; //종료하자					
				}
				
			}			
			System.out.println("#"+tc+" "+ans);
		}
		
		
	}
	private static void ChainReact(int y, int x) {
		for (int d = 0; d < 8; d++) { //0인 땅 주변에 대해 8방탐색
			int ny = y+dy[d];
			int nx = x+dx[d];
			//방문하지 않았다면
			if(ny>=0 && nx>=0 && ny<N && nx<N && !v[ny][nx]) {
				System.out.println("ChainReact"+d+"{"+ny+","+nx+"}");
				v[ny][nx] = true; //밝혀준다.
				marked++;
				if(map[ny][nx] == 0) { //밝힌땅이 0이라면
					ChainReact(ny, nx); //연쇄반응					
				}
			}
		}		
	}
	private static int countZero(int i, int j) {
		int cnt = 0;
		for (int d = 0; d < 8; d++) {
			//0 발견하면 카운트++
			int ny = i+dy[d];
			int nx = j+dx[d];
			if(ny>=0 && nx>=0 && ny<N && nx<N && map[ny][nx]==0) {
				cnt++;
			}
		}
		
		return cnt;
	}
	private static int countMine(int i, int j) {
		int cnt = 0; //지뢰카운트
		for (int d = 0; d < 8; d++) {
			// 지뢰 발견하면 카운트
			int ny = i+dy[d];
			int nx = j+dx[d];
			if(ny>=0 && nx>=0 && ny<N && nx<N && map[ny][nx]=='*') {
				cnt++;
			}
		}
		
		return cnt;
	}
	private static void print(int[][] map2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == '*') {
					System.out.print("* ");
				}else
					System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
