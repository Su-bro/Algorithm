package week16;


import java.io.*;
import java.util.*;

public class Main_17829_222풀링 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        // N*N 크기의 배열을 그대로 쓰고, 작은 크기의 사각형에 덮어씌우자.
        pooling(arr, N);
        System.out.println(arr[0][0]);
    }

    private static void pooling(int[][] arr, int N) {
        if(N==1) return; //2*2 배열까지 탐색, 정렬 끝났으니까 종료

        for (int i = 0; i < N; i+=2) {
            for (int j = 0; j < N; j+=2) {
                int[] tmp = {arr[i][j], arr[i][j+1], arr[i+1][j], arr[i+1][j+1]};
                Arrays.sort(tmp);
                arr[i/2][j/2] = tmp[2]; // 두번째로 높은 수만 담기
            }
        }

        // (N/2)*(N/2) 크기의 작은 사각형 탐색
        pooling(arr, N/2); 
    }
}