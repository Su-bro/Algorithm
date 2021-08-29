package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol3_Meteor {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str= br.readLine();
		StringTokenizer st = new StringTokenizer(str);		
		int Y=Integer.parseInt(st.nextToken());
		int X=Integer.parseInt(st.nextToken());		
		
		long beforeTime = System.currentTimeMillis();
		char[][] arr = new char[Y][X];
		for(int i=0;i<Y;i++) arr[i]=br.readLine().toCharArray();						
		//최소거리찾기
		//00부터 돌면서 X찾기, X 있으면 해당줄 #위치 찾기
		int dist = 99;
		for(int i =0;i<Y;i++) {
			for(int j=0;j<X;j++) {
				if(arr[i][j]=='X') {
					for(int k =i;k<Y;k++) {						
						if(arr[k][j]=='#') {
							if(dist>(k-i-1)) dist = k-i-1;							
						}
					}
				}				
			}
		}	
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
			System.out.println("");
			for(int j=0;j<X;j++) {
				System.out.print(arr[i][j]);
			}
		}
		
		long afterTime = System.currentTimeMillis(); 
		long secDiffTime = (afterTime - beforeTime);
		System.out.println("시간차이(m) : "+secDiffTime);
	}
}

