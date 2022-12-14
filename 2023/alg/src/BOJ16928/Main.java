package BOJ16928;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, min = Integer.MAX_VALUE;
    static Map<Integer, Integer> ladder = new HashMap<>();
    static Map<Integer, Integer> snake = new HashMap<>();
    static boolean check[] = new boolean[101];
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
//        FileInputStream fis = new FileInputStream("src/BOJ16928/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        q.offer(new int[] {1, 0});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowLocation = now[0];
            int count = now[1];

            if(nowLocation == 100) {
                min = Math.min(min, count);
            }

            check[nowLocation] = true;
            if(ladder.containsKey(nowLocation)) {
                nowLocation = ladder.get(nowLocation);
                check[nowLocation] = true;
            }
            if(snake.containsKey(nowLocation)) {
                nowLocation = snake.get(nowLocation);
                check[nowLocation] = true;
            }

            for (int i = 6; i > 0; i--) {
                int nextLocation = nowLocation + i;
                if(nextLocation <= 100) {
                    if(!check[nextLocation] && count+1 < min) {
                        q.offer(new int[]{nowLocation + i, count + 1});
                    }
                }
            }
        }
        System.out.println(min);
    }
}
