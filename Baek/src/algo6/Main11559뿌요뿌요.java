package algo6;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main11559뿌요뿌요 {
	static char[][] map = new char[12][6];
	static boolean[][] v;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int cnt,combo,flag;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("뿌요뿌요.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i<12; i++) {
			String str = br.readLine();
			for(int j = 0; j<6; j++) {
				//char ASCII값 저장
				map[i][j]=str.toCharArray()[j];					
			}
		}
		print();
		while(true) {
			flag=0; //flag 초기화
			for(int i = 0; i < 12; i++) {								
				for(int j = 0; j< 6 ; j++) {
					// '.' 이 아니면 -> 블럭이라면!
					if(map[i][j]!='.') {
						//blk 변수에 저장
						char blk = map[i][j];
						//방문배열 초기화
						v = new boolean[12][6];						
						cnt=1; //카운트 1로 초기화
						search(i,j,blk);
						//올려준 카운트가 4 이상이라면(블럭이 4개 이상 붙어있다면!)
						if(cnt>=4) {
							flag=1; //동작한다!
							crush(); //크러시
							//print();
							System.out.println(blk+" 색 부쉈다.");
						}
					}
				}			
			}
			if(flag==0) {
				//플래그가 0이면(못뿌셨다 == 더 동작할게 없다)
				break;			
			}
			print();			
			if(flag==1) { //플래그가 1이면(뿌셨다면)				
				poll(); 
				System.out.println("중력");
				print();
				System.out.println("현제 콤보는 : "+combo);
			}
			
		}		
		
		//정답
		System.out.println(combo);
		
		
	}
	private static void poll() {
		//좌에서 우로
		for(int j = 5; j >= 0; j--) {
			int space=0; //공간변수 초기화
			for(int i = 11; i >= 0; i--) {	//밑에서 위로검사			
				if(map[i][j]=='.') { //빈공간을 만나면
					space++;     //공간변수++
				}else if(map[i][j]!='.' ) {// . 이 아니면(블럭만나면)
					char tmp = map[i][j]; //해당 블럭을 임시저장
					map[i][j]='.'; //현재 좌표 공간으로
					map[i+space][j]=tmp; //space변수만큼 내려준다.
					
				}
			}
		}
		combo++;
		//함 땡겼기때문에 콤보++;
	}
	
	private static void crush() {
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 6; j++) {
				if(v[i][j]) { //방문배열 트루해준거
					map[i][j]='.'; //빈칸으로
				}
			}
		}
	}
	
	private static void search(int y, int x, char blk) {
		//방문배열 트루
		v[y][x]=true;
		//사방에 대하여
		for(int i = 0; i < 4; i++) {
			int nr = y+dy[i];
			int nc = x+dx[i];
			// 방문하지 않은 블럭이 받아온 blk와 같다면 
			if(nr>=0 && nc>=0 && nr<12 && nc<6 && !v[nr][nc] && map[nr][nc]==blk) {
				cnt++; //카운트를 ++
				//재귀 - 방문 
				search(nr, nc, blk);
			}
		}
		//더이상 방문할 곳이 없다면 종료
	}
	
	private static void print() {
		for(int i = 0; i < 12; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("-------------------");
	}
}
/*
dy = {-1, 0, 1, 0}
dx = { 0, 1, 0, -1}
오른쪽 >> d = (d+1)%4
왼쪽  >>  d = (d-1+n)%4
*/
