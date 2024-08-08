package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 아이디어
 신호등 갯수만큼 배열을 만든 뒤, 고장난 신호등에는 1을 assign
 신호등을 for문으로 순회하며 그 인덱스까지 고장난 신호등 갯수 누적합을 구해준다.

 한 신호등 lights[i]에 대해서, K구간만큼 정상적 신호를 받기 위해 고쳐야 할 신호등 갯수는  lights[i]-lights[i-K]이다.

 i=K; i<=N까지의 신호등에 대해 min(lights[i]-lights[i-K])을 구해서 출력한다.
 */
public class Main_14465_소가길을건너간이유 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] lights = new int[N+1];

        //고장난 신호등 + 1
        for(int i=0; i<B; i++) lights[Integer.parseInt(br.readLine())] = 1;

        //누적합
        for(int i=1; i<=N; i++) lights[i]+=lights[i-1];

        int answer = Integer.MAX_VALUE;

        for(int i=K; i<=N; i++) {
            answer = Integer.min(answer, lights[i]-lights[i-K]);
        }

        System.out.println(answer);
    }

}