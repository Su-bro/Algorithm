package algo_11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10830행렬제곱 {
	static int N;
	static long B;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/algo_11/행렬제곱.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] res = solution(arr, B);
		
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++)
                System.out.print(res[i][j]%1000+" ");
            System.out.println();
        }

		

	}

	private static int[][] solution(int[][] a, long b) {
        if(b==1) return a;
        else if(b%2==0) { //b가 2의배수라면 
        	// temp는 a의 b/2제곱
            int[][] temp = solution(a, b/2);
            // tmep*temp
            return square(temp, temp);
        }
        else {
            return square(solution(a, b-1), a);
        }
	}

	private static int[][] square(int[][] a, int[][] A) {
		//임시배열
		int[][] temp = new int[N][N];
		
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int sum = 0;
                for(int k=0; k<N; k++) { //행,열곱샘
                    sum += a[i][k]*A[k][j];
                }
                temp[i][j] = sum%1000;
            }
        }

        return temp;
	}

}
