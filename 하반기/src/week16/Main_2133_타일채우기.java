package week16;

import java.io.*;

public class Main_2133_타일채우기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[31];
        arr[2]=3;   arr[4]=11;  arr[6]=41;

        for(int i=4; i<=N; i+=2)    {
            if(i%2==0) {
                arr[i]=3*arr[i-2]+2;
                for(int j=1; i-2-2*j>=2; j++) {
                    arr[i]+=2*arr[i-2-2*j];
                }
            }
        }
        System.out.println(arr[N]);
    }
}
