package algo9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20057마법상어토네이도 {
	static int N;
	static int[][] map;
	static int[] dy = { 0, 1, 0, -1};
	static int[] dx = {-1, 0, 1, 0};
	static int out;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("토네이도.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());				
			}
		}
		
		//print(map);
		int cnt = 0;
		int d = 0;
		int x = N/2;
		int y = N/2;
		int l =1;
		//토네이도 이동
		while(y!=0 || x!=0) {			
			for(int i=0; i<l; i++) {
				//System.out.println(y+","+x);
				y = y+dy[d];
				x = x+dx[d];				
				//토네이도 진행방향에 모래가 있다면
				if(map[y][x]!=0) {					
					spread(y,x,d);
					print(map);
					System.out.println(out);
				}
				if(y==0&&x==0) break;
								
			}
			cnt++;		
			if(cnt%2==0) l++;
			d = (d+1)%4;					
		}
		
		System.out.println(out);
		
		
		
	}
	
	private static void spread(int y, int x, int d) {
		//불어오는 방향에 따라서		
		int rat5 = map[y][x]*5/100;
		int rat10 = map[y][x]*10/100;
		int rat7 = map[y][x]*7/100;
		int rat2 = map[y][x]*2/100;
		int rat1 = map[y][x]*1/100;		
		int a = map[y][x]-rat5-(2*rat10)-(2*rat7)-(2*rat2)-(2*rat1);
		map[y][x] -= map[y][x];
		
		
		
		
		
		
		switch (d) {
		case 0:
			//System.out.println("case0");
			//move
			if(x-1>=0) map[y][x-1]+=a;
			else out+=a;
			//5
			if(x-2>=0)map[y][x-2] += rat5;				
			else out+= rat5;
			//10
			if(x-1>=0 && y-1>=0)map[y-1][x-1] += rat10;				
			else out+=rat10;
			if(x-1>=0 && y+1<N)map[y+1][x-1] += rat10;				
			else out+=rat10;
			
			//7
			if(y-1>=0)map[y-1][x]+=rat7;
			else out+=rat7;
			if(y+1<N)map[y+1][x]+=rat7;
			else out+=rat7;
			
			//2
			if(y-2>=0)map[y-2][x]+=rat2;
			else out+=rat2;
			if(y+2<N)map[y+2][x]+=rat2;
			else out+=rat2;
			
			//1
			if(x+1<N && y-1>=0)map[y-1][x+1] += rat1;				
			else out+=rat1;
			if(x+1<N && y+1<N)map[y+1][x+1] += rat1;
			else out+=rat1;
			
			
			break;

		case 1:
			//System.out.println("case1");
			//move
			if(y+1<N) map[y+1][x]+=a;
			else out+=a;
			
			//5
			if(y+2<N)map[y+2][x] += rat5;				
			else out+= rat5;
			
			//10
			if(x-1>=0 && y+1<N)map[y+1][x-1] += rat10;				
			else out+=rat10;
			if(x+1<N && y+1<N)map[y+1][x+1] += rat10;				
			else out+=rat10;
			
			//7
			if(x-1>=0)map[y][x-1]+=rat7;
			else out+=rat7;
			if(x+1<N)map[y][x+1]+=rat7;
			else out+=rat7;
			
			//2
			if(x-2>=0)map[y][x-2]+=rat2;
			else out+=rat2;
			if(x+2<N)map[y][x+2]+=rat2;
			else out+=rat2;
			
			//1
			if(x+1<N && y-1>=0)map[y-1][x+1] += rat1;				
			else out+=rat1;
			if(x-1>=0 && y-1>=0)map[y-1][x-1] += rat1;
			else out+=rat1;			
			break;
			
		case 2:
			//System.out.println("case2");
			
			//move
			if(x+1<N) map[y][x+1]+=a;
			else out+=a;
			
			//5
			if(x+2<N)map[y][x+2] += rat5;				
			else out+= rat5;
			
			//10
			if(x+1<N && y-1>=0)map[y-1][x+1] += rat10;				
			else out+=rat10;
			if(x+1<N && y+1<N)map[y+1][x+1] += rat10;				
			else out+=rat10;
			
			//7
			if(y-1>=0)map[y-1][x]+=rat7;
			else out+=rat7;
			if(y+1<N)map[y+1][x]+=rat7;
			else out+=rat7;
			
			//2
			if(y-2>=0)map[y-2][x]+=rat2;
			else out+=rat2;
			if(y+2<N)map[y+2][x]+=rat2;
			else out+=rat2;
			
			//1
			if(x-1>=0 && y-1>=0)map[y-1][x-1] += rat1;				
			else out+=rat1;
			if(x-1>=0 && y+1<N)map[y+1][x-1] += rat1;
			else out+=rat1;
			
			break;
		case 3:
			
			//System.out.println("case3");
			//move
			if(y-1>=0) map[y-1][x]+=a;
			else out+=a;
			
			//5
			if(y-2>=0)map[y-2][x] += rat5;				
			else out+= rat5;
			
			//10
			if(x-1>=0 && y-1>=0)map[y-1][x-1] += rat10;				
			else out+=rat10;
			if(x+1<N && y-1>=0)map[y-1][x+1] += rat10;				
			else out+=rat10;
			
			//7
			if(x-1>=0)map[y][x-1]+=rat7;
			else out+=rat7;
			if(x+1<N)map[y][x+1]+=rat7;
			else out+=rat7;
			
			//2
			if(x-2>=0)map[y][x-2]+=rat2;
			else out+=rat2;
			if(x+2<N)map[y][x+2]+=rat2;
			else out+=rat2;
			
			//1
			if(x+1<N && y+1<N)map[y+1][x+1] += rat1;				
			else out+=rat1;
			if(x-1>=0 && y+1<N)map[y+1][x-1] += rat1;
			else out+=rat1;			
			break;
			
			
		}
		
	}

	private static void print(int[][] arr) {
		for(int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println("=======================");
	}

}
