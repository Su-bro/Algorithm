package week16;


import java.util.*;
import java.io.*;

public class Main_16564_히오스프로그래머 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] level = new int[N];
        for (int i = 0; i < N; i++) {
            level[i] = Integer.parseInt(br.readLine());
        }

        long answer = 0;
        Arrays.sort(level);

        long left = level[0];
        long right = Integer.MAX_VALUE;

        while(left <= right) {
            long middle = (left + right) / 2;
            long sum = 0;

            //각 level값과 middle을 비교하고, 레벨업이 생기면 sum에 더해준다.
            for (int i = 0; i < N; i++) {
                if(middle >= level[i]) sum += middle - level[i];
            }

            //만약 sum이 K를 넘어서지 않으면, min(level), 즉 최소 목표 레벨의 최댓값을 갱신하고 left↑
            //만약 sum이 K를 넘어서면(middle이 너무 크면), right↓
            if(sum <= K) {
                left = middle + 1;
                answer = Math.max(answer, middle);
            } else right = middle - 1;
        }

        System.out.println(answer);
    }

}