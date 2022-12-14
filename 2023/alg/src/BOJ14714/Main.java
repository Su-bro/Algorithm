package BOJ14714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, A,B, dA, dB, dist[][][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken())-1;
        B = Integer.parseInt(st.nextToken())-1;
        dA = Integer.parseInt(st.nextToken());
        dB = Integer.parseInt(st.nextToken());
        dist = new int[500][500][2];
        int ans = bfs();
        if (ans >= 0) {
            System.out.println(ans);
        } else {
            System.out.println("Evil Galazy");
        }
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {A, B, 0, 0});
        dist[A][B][0] = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nA = now[0], nB = now[1], turn = now[2], depth = now[3];
            if(nA == nB) return depth;
            if (turn == 0) {
                int xA;
                xA = (nA + dA) % N;
                if(dist[xA][nB][1] == 0) {
                    dist[xA][nB][1] = 1;
                    q.offer(new int[] {xA, nB, 1, depth + 1});
                }
                xA = (nA - dA + N) % N;
                if(dist[xA][nB][1] == 0) {
                    dist[xA][nB][1] = 1;
                    q.offer(new int[] {xA, nB, 1, depth + 1});
                }
            }
            if (turn == 1) {
                int xB;
                xB = (nB + dB) % N;
                if(dist[nA][xB][0] == 0) {
                    dist[nA][xB][0] = 1;
                    q.offer(new int[] {nA, xB, 0, depth + 1});
                }
                xB = (nB - dB + N) % N;
                if(dist[nA][xB][0] == 0) {
                    dist[nA][xB][0] = 1;
                    q.offer(new int[] {nA, xB, 0, depth + 1});
                }
            }
        }
        return -1;
    }
}
