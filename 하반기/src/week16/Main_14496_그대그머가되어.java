package week16;

import java.util.*;
import java.io.*;

public class Main_14496_그대그머가되어 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            //양방향 표시!!
            list[from].add(to);
            list[to].add(from);
        }

        //치환한 수(cnt) 순으로 정렬해주도록 PriorityQueue 사용
        PriorityQueue<Word> q = new PriorityQueue<>();
        boolean[][] v = new boolean[N+1][N+1];
        q.add(new Word(a, 0));

        while(!q.isEmpty()) {
            Word p = q.poll();

            if(p.w==b) {
                System.out.println(p.cnt);
                return;
            }

            for (int i = 0; i < list[p.w].size(); i++) {
                if(!v[p.w][i]) {
                    v[p.w][i] = true;
                    q.add(new Word(list[p.w].get(i), p.cnt+1));
                }
            }
        }

        System.out.println(-1);
    }

    public static class Word implements Comparable<Word> {
        int w, cnt;

        public Word(int w, int cnt) {
            super();
            this.w = w;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Word o) {
            return Integer.compare(cnt, o.cnt);
        }
    }
}