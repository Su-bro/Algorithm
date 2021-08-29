package algo_14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_3020개똥벌레 {
	
	static int N,M;
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("src/algo_14/개똥.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int[] soon = new int[N/2];    //석순
        int[] jong = new int[N/2];    //종유석
        int[] arr = new int[M];
        int min = Integer.MAX_VALUE;
        int minCnt = 0;

        for(int i=0; i<N; i++) {
            int l = Integer.parseInt(br.readLine());
            if(i%2==0)
                soon[i/2] = l;
            else
                jong[i/2] = l;
        }
        //정렬
        Arrays.sort(soon);
        Arrays.sort(jong);

        for(int i=1; i<M+1; i++) {
            int j = binarySearch(N/2-1, i, soon); //이분탐색
            int k = binarySearch(N/2-1, M-i+1, jong); //이분탐색
            arr[i-1] = j+k;            
            min = Math.min(min, arr[i-1]);
        }

        for(int i=0; i<M; i++) {
            if(min==arr[i])
                minCnt++;
        }

        System.out.println(min+" "+minCnt);
    }

    static int binarySearch(int max, int h, int[] arr) {
        int left = 0;
        int right = max;

        int min = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (h <= arr[mid]) {
                min = Math.min(min, mid);
                right = mid - 1;
            }
            else
                left = mid + 1;
        }

        if (min == Integer.MAX_VALUE)
            return 0;

        return N / 2 - min;
    }
}


