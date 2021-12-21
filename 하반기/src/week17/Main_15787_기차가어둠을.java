package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
/*
 승객을 한칸씩 뒤로 밀거나 당기는 연산, n번째 위치에 승객을 삽입하는 연산은
 각각 배열 / 연결리스트에서 구현시간이 O(N)시간이 걸리므로 이를 명령수 M번 반복하게 되면 시간초과가 걸릴 가능성이 크다.

 하지만 문제에서 주어진 기차의 좌석수가 20개 이므로 비트 연산을 이용해 계산하면 상수시간에 계산이 가능하다.
 주어진 명령어에 대해 비트 연산을 마친 뒤 HashSet에 결과를 넣어줘서 중복되지 않은 값을 세준다.

 */
public class Main_15787_기차가어둠을 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int MASK = Integer.MIN_VALUE>>>1;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] train = new int[N+1];
        for(int numCmd=0; numCmd<M; numCmd++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if(cmd == 1) {
                int i = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                train[i] |= 1<<x;
            }else if(cmd == 2) {
                int i = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                train[i] &= ~(1<<x);
            }else if(cmd == 3) {
                int i = Integer.parseInt(st.nextToken());

                train[i] = (train[i]<<1);
                train[i] &= ((1 << 21) - 1);
            }else { //cmd == 4
                int i = Integer.parseInt(st.nextToken());

                train[i] = (train[i]>>>1);
                train[i] &= ~1;
            }

        }

        HashSet<Integer> hs = new HashSet<>();
        for(int i=1; i<=N; i++) hs.add(train[i]);

        System.out.println(hs.size());
    }

}