package algo9;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {
	static int[][] map,copy;
	static int T,n,line,maxcore,ans;
	static LinkedList<int[]> corelist;
	static boolean flag;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,-1,0,1};
	static ArrayList<int[]> kkk;
	public static void main(String args[]) throws Exception  {		
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			kkk = new ArrayList<int[]>();
			n = sc.nextInt()+2;			
			line = 9999;
			maxcore = 0;
			ans = 0;
			corelist = new LinkedList<int[]>();			
			map = new int[n][n];
			copy = new int[n][n];			
			for(int i = 1; i < n-1; i++) {								
				for(int j = 1; j < n-1; j++) {				
					map[i][j] = sc.nextInt();					
				}
			}
			
			//�ܰ�ó��
			for(int i = 0; i < n; i++) {
				map[0][i] = 2;
				map[i][0] = 2;
				map[n-1][i] = 2;
				map[i][n-1] = 2;
			}
			
			for(int i = 2; i<n-2; i++) {
				for(int j = 2; j<n-2; j++) {
					if(map[i][j]==1) {//�ھ ������
						//�ھ���ġ ����
						corelist.add(new int[] {i,j});
					}
				}				
			}
			
			dcopy();			
			dfs(0,0);			
			
			for(int[] a : kkk) {
				if(a[0]==maxcore) {
					line = Math.min(line, a[1]);
				}
			}
			
			System.out.println("#"+tc+" "+line);
		}
		
		
		
		
		
	}	
	



	private static void dcopy() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				copy[i][j] = map[i][j];
			}
		}
		
	}
	private static void dfs(int idx, int con) {
		
		if(idx == corelist.size()) {			
			maxcore = Math.max(maxcore, con);
			if(con>=maxcore) {
				int lc = countlines();
				kkk.add(new int[] {maxcore,lc});
			}
			return;
		}
		
		int[] loc = corelist.get(idx);
		int y = loc[0];
		int x = loc[1];
		
		for(int d = 0; d<4; d++) {
			flag = false;
			conn(y,x,d,idx+3,0);	
			if(flag) dfs(idx+1,con+1);
			else dfs(idx+1,con);
			deconn(y,x,d,idx+3);
		}
		
	}


	private static int countlines() {
		int a=0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(copy[i][j]>2) {
					a++;
				}
			}
		}
			
		return a;
	}




	private static void deconn(int y, int x, int d,int mark) {		
		int ny = y+dy[d];
		int nx = x+dx[d];
		if(copy[ny][nx]==mark) {
			copy[ny][nx]=0;
			deconn(ny,nx,d,mark);			
		}
	}
	
	private static void conn(int y, int x, int d,int mark,int cnt) {			
		
		int ny = y+dy[d];
		int nx = x+dx[d];
		if(copy[ny][nx]==2) {
			flag = true;
			return;		
		}
		else if(copy[ny][nx]==0) {
			copy[ny][nx]=mark;
			conn(ny,nx,d,mark,cnt+1);			
		}		
		
		
		
	}


	private static void print(int[][] arr) {		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("==============================");
	}
  
}
