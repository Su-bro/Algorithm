package algo8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17135캐슬디펜스 {
	static class Enemy{
		int y;
		int x;
		public Enemy(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static int N,M,D,max;
	static int[][] map,copy;
	static int[] set,arr;
	
	static ArrayList<Enemy> enemy, arc;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("캐슬.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		set = new int[3];
		
		map = new int[N+1][M];
		max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//궁수의 위치 배열
		arr = new int[M];
		for(int i = 0; i < M; i++) {
			arr[i] = i;
		}
		
		//조합을 이용한 풀이
		combination(0,0);
		System.out.println(max);
		
	}
	private static void combination(int len, int k) {
		if(len==3) {
			
			//궁수 3명의 조합이 배정되면
			//적 위치 저장
			enemy = new ArrayList<>();
			copy = new int[N+1][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					copy[i][j] = map[i][j];
					if(map[i][j]==1) {
						//적 목록에 추가
						enemy.add(new Enemy(i, j));
					}
				}
			}
			//궁수 위치 저장
			arc = new ArrayList<>();
			for(int i = 0; i < 3; i++) {
				copy[N][arr[set[i]]] = 2;
				arc.add(new Enemy(N, set[i]));
			}
			sol(copy);
			//System.out.println(Arrays.toString(set));
			//print();
			return;			
		}
		if(k==arr.length) return;
		
		set[len] = arr[k];
		combination(len+1, k+1);
		combination(len, k+1);
		
	}
	
	private static void sol(int[][] map) {
		int cnt=0;
		//적을 전부 죽일때까지
		while (enemy.size() !=0) {
			//죽일놈 저장
			ArrayList<Enemy> kill = new ArrayList<>();
			
			for(int i = 0; i < arc.size(); i++) {
				//이 궁수의 적들에 대한 거리계산배열
				int[] dir = new int[enemy.size()];
				int minDir = Integer.MAX_VALUE;				
				//적과의 거리 저장
				for(int j = 0; j < enemy.size(); j++) {
					dir[j] = dist(arc.get(i), enemy.get(j));
					//i번 궁수에 대한 적의 최소거리 저장
					if(minDir > dir[j]) minDir = dir[j];
				}
				
				//사격할 타겟 좌표 어레이리스트 생성
				ArrayList<Enemy> target = new ArrayList<>();
				
				for(int j = 0; j < enemy.size(); j++) {
					// 선택된 적이 최소거리인 동시에 사정거리 안이라면
					if(dir[j] == minDir && dir[j]<=D) {
						target.add(enemy.get(j));
					}
				}
				//해당 궁수가 사격할 타겟이 0라면 컨티뉴
				if(target.size()==0) continue;
				else if(target.size()==1) { //타겟이 하나라면
					kill.add(target.get(0)); //타겟을 죽일목록에 저장
				}
				else if (target.size()>=2) { //타겟이 2개 이상이라면
					int minX = Integer.MAX_VALUE; //제일 왼쪽에 있는놈찾자
					
					for(int j = 0; j < target.size(); j++) {
						//제일 왼쪽에 있는 타겟 찾아냄
						if(minX > target.get(j).x) minX = target.get(j).x;
					}
					
					for(int j = 0; j < target.size(); j++) {
						if(target.get(j).x == minX) {
							kill.add(target.get(j));
						}
					}
				}
			}
			
			//킬목록 삭제
			for(int i = 0; i < kill.size(); i++) {
				for(int j = 0; j < enemy.size(); j++) {
					if(kill.get(i).y == enemy.get(j).y && kill.get(i).x == enemy.get(j).x) {
						enemy.remove(j);
						cnt++;
						break;
					}
				}
			}
			
			int c = enemy.size();
			int idx = 0;
			while(c>0) {
				if(enemy.get(idx).y+1 !=N) {
					enemy.add(new Enemy(enemy.get(idx).y+1, enemy.get(idx).x));
				}
				enemy.remove(idx);
				c--;
			}			
		}
		if(max < cnt) max = cnt;
	}
	
	
	private static int dist(Enemy a, Enemy e) {		
		return Math.abs(a.y-e.y)+Math.abs(a.x-e.x);
	}
	private static void print() {
		for(int i = 0; i < N+1; i++) {
			System.out.println(Arrays.toString(copy[i]));
		}
		System.out.println("===================");
	}
	
	

}
