package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str= br.readLine();
		StringTokenizer st = new StringTokenizer(str);		
		int Y=Integer.parseInt(st.nextToken());
		int X=Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[Y][X];
		for(int i=0;i<Y;i++) arr[i]=br.readLine().toCharArray();
		
		
		//최소거리찾기
		//밑에서부터 돌면서 땅찾기
		int dist = 99;
		for(int j =X-1;j>=0;j--) {
			boolean flag = false;//플래그 디폴트
			int tmp = 0;//임시값
			
			for(int i=Y-1;i>=0;i--) {
				
				if(arr[i][j]=='#') {	//세로로 올라오며 땅을 만났을 때				
					if(i>0&&arr[i-1][j]=='#') { //i가 0보다 크고(out of range방지) 위에 있는 블럭도 땅일 때
						tmp=0; //임시값 초기화
					}					
					if(i>0&&arr[i-1][j]=='.')tmp++; // 공백이 있다면 임시값 +1						
				}
				
				
				if(arr[i][j]=='.') { //공백을 만났을 때
					if(i>0&&arr[i-1][j]=='#')tmp=0; //위에 땅이 있다면 임시값 초기화
					if(i>0&&arr[i-1][j]=='.')tmp++; //공기가 또 있다? 임시값 +1
					if(i>0&&arr[i-1][j]=='X') { // 창모를 만난다면?!
						flag = true; //깃발올려
						break;// 빠져나가쟈 
					}
				}
				
			}
			// 플래그가 트루일때 and 임시값이 최소거리보다 작을 때 최소거리는 tmp
			if(flag==true&&dist>tmp)dist=tmp;			
			
		}
		//System.out.println(dist);
		//무벼앳(밑에서부터 올라오면서 X가 있으면 .로 바꾸고 dist만큼 밑에 X로)
		for(int i=Y-1;i>=0;i--) {
			for(int j=X-1;j>=0;j--) {
				if(arr[i][j]=='X') {
					arr[i][j]='.';
					arr[i+dist][j]='X';
				}				
			}
		}
		//출력
		for(int i =0;i<Y;i++) {
			System.out.println(new String(arr[i]));
		}
		br.close();
	}
}