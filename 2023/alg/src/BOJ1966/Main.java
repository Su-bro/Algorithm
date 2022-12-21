package BOJ1966;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int T, size, targetLocation;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("./src/BOJ1966/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            targetLocation = Integer.parseInt(st.nextToken());

            Queue<int[]> printQue = new LinkedList<>();
            PriorityQueue<Integer> weightQue = new PriorityQueue<>(Collections.reverseOrder());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
                int next = Integer.parseInt(st.nextToken());

                int isTarget;
                if (i == targetLocation) {
                    isTarget = 1;
                } else {
                    isTarget = 0;
                }
                printQue.offer(new int[]{next, isTarget});
                weightQue.offer(next);
            }
            int cnt = 0;
            while (!printQue.isEmpty()) {
                // 출력물의 우선순위가 가장 높다면
                if (printQue.peek()[0] == weightQue.peek()) {
                    int[] out = printQue.poll();
                    weightQue.poll();
                    cnt++;

                    if (out[1] == 1) {
                        break;
                    }
                } else {
                    printQue.offer(printQue.poll());
                }
            }
            System.out.println(cnt);
        }

    }

}
