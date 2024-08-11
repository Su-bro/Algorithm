package BOJ1927;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/BOJ1927/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(pq.poll() + "\n");
                }
            } else {
                pq.add(x);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
