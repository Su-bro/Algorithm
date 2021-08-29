package algo_13;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_경주로건설 {
	
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
		System.out.println(solution1(board));
	}



	static class Info implements Comparable<Info>{
		int y,x,price,dir;
		public Info(int y, int x, int price, int dir) {
			this.y = y; //위치 
			this.x = x;
			this.price = price; //도로가격
			this.dir = dir; // 방향
		}
		@Override
		public int compareTo(Info o) {
			//도로가격 오름차순 정렬가능하지
			return price-o.price;
		}		
	}

	public static int solution1(int[][] board) {
		int[] dy = {1,0,-1,0}, dx = {0,1,0,-1};
        int answer = 0;
        int N = board.length; //보드길이
        
        int[][] memo = new int[N][N]; //찬용이꺼 벤치마킹(메모이제이션)        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
            	memo[i][j] = Integer.MAX_VALUE;            	
            }
        }
        memo[0][0] = 0;
        
        //도로가격을기준으로하는 우선순위큐야
//        PriorityQueue<Info> pq = new PriorityQueue<Info>(); 오히려 pq를 안쓰는게 더 좋았다
        Queue<Info> q = new LinkedList<Info>();
        //오른쪽으로 갈수있으면, 아래로 내려갈수있으면 직선가격, 방향 추가해준다
        if(board[0][1]!=1)q.add(new Info(0,1,100,1));
        if(board[1][0]!=1)q.add(new Info(1,0,100,0));
        while(!q.isEmpty()) { //bfs
        	Info now = q.poll();
        	int y = now.y;
        	int x = now.x;        	
        	int dir = now.dir;
//        	if(y==N-1 && x==N-1) return now.price; //도착하면 가격리턴해주자
        	for (int d = 0; d < 4; d++) {
				if(d == (dir+2)%4) continue; //지나온방향은 패쓰
				int price = now.price;
				int ny = y+dy[d];
				int nx = x+dx[d];
				if(ny>=N || nx>=N || ny<0 || nx<0 || board[ny][nx]==1) continue; //경계선,못가는곳체크
				int nextprice = 0; 
				if(d==dir) nextprice = 100; //직선가격 100원이요
				if(d!=dir) nextprice = 600; //곡선가격 600원(직선끼고커브돌았으니까)
				if(memo[ny][nx] >= price+nextprice) { //해당메모이제이션의 가격보다 쌀 경우
					memo[ny][nx]= price+nextprice;
					q.add(new Info(ny, nx, price+nextprice, d)); //도로가격더한거 add
				}
			}        	
        }        
        return memo[N-1][N-1];
    }
    
}
