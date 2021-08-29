package algo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_16926배열돌리기01{
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, R, S;
    static int[][] matrix, copy;    
    public static void main(String[] args) throws IOException  {
    	
    	
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());  
        
        
        N = Integer.parseInt(st.nextToken());   	
    	M = Integer.parseInt(st.nextToken());
    	S = Integer.parseInt(st.nextToken());    	
    	
    	
    	
    	matrix = new int[N][M];
    	copy = new int [N][M];    	
    	
    	
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(in.readLine());    		
    		for(int j = 0; j < M; j++) {
    			matrix[i][j] = Integer.parseInt(st.nextToken());
    		}
    		
    		
    		
    	}    	
    	//----------S만큼 턴 동작
    	for(int i=0;i<S;i++) {
    		turn(0);
    	}
    	
    	
    	//출력
    	for(int i = 0; i < N; i++) {
    		for(int j =0; j<M;j++) {
    			System.out.print(matrix[i][j]+" ");
    		}
    		System.out.println();
    	}
    	
    	
    	
    	
    	
    }
    //턴 동작 설정
	private static void turn(int idx) {
		
		
		if(idx==Math.min(N,M)/2) {//N,M중 작은수/2 4,5=2
			//붙어넣기/초기화
			matrix = copy;
			copy = new int[N][M];
			return;
		}		
		
		
		// 0부터 가로끝-1 까지     //idx만큼 줄어든가로끝
		for(int i = idx; i < M-1-idx; i++) {
			copy[idx][i] = matrix[idx][i+1];
		}   // 0 , 0 =  0 , 1 
		
		// 0부터 세로끝-1 까지 //idx만큼 줄어든 세로끝
		for(int i = idx; i < N-1-idx; i++) {
			copy[i][M-1-idx] = matrix[i+1][M-1-idx];
		}      // 0, 가로끝-1-idx  =  1, 가로끝-1-idx 
		
		for(int i = M-1-idx; i > idx; i--) {
			copy[N-1-idx][i] = matrix[N-1-idx][i-1];
		}
		for(int i = N-1-idx; i > idx; i--) {
			copy[i][idx] = matrix[i-1][idx];
		}
		turn(idx+1);
		//idx가 1 증가한다면 경계처리 범위가 1줄어든다			
	}  


}
	


