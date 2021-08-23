package algo7;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2636치즈2 {
	static int cnt,min;	
	static boolean[][] v;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("치즈.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];		
		for(int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < map[0].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < map.length; i++) {
			map[i][0]=2;
			map[i][m-1]=2;
		}
		for(int i = 0; i < map[0].length; i++) {
			map[0][i]=2;
			map[n-1][i]=2;
		}
		
		boolean check = true;
		int time = 0;
		while(check) {
			cnt=0;
			time++;
			check = false;
			for(int i = 1; i < map.length-1; i++) {
				for(int j = 1; j < map[0].length-1; j++) {
					if(map[i][j]==1) {
						check = true;
						cnt++;
						v = new boolean[n][m];
						boolean y = aircheck(i,j,map);
						if(y) map[i][j]=3;				
					}
				}
			}
			if(cnt!=0)min=cnt;
			if(!check) {
				System.out.println(time-1);
				System.out.println(min);
				System.exit(0);
			}
			melt(map);
		}
		
		
	}
	private static void melt(int[][] map) {
		for(int i = 1; i < map.length-1; i++) {
			for(int j = 1; j < map[0].length-1; j++) {
				if(map[i][j]==3) map[i][j]=2;				
			}
		}
	}
	private static boolean aircheck(int y, int x, int[][] map) {	
		
		for(int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(map[ny][nx]==2) {				
				return true;				
			}else if (map[ny][nx]==0 && !v[ny][nx]){
				v[ny][nx]=true;
				boolean a = aircheck(ny,nx, map);
				if(a==true)return true;
				v[ny][nx]=false;
			}			
		}
		
		return false;
	}
	
	private static void print(int[][] map) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				System.out.printf("%d ",map[i][j]);
			}
			System.out.println();
		}
		
	}

}
