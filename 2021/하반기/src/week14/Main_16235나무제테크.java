package week14;

import java.io.*;
import java.util.*;

public class Main_16235나무제테크 {
    static int N, M, K;
    static int[][] A;
    static int[][] map;
    static LinkedList<tree> t;
    static Queue<tree> dead;
    static int[] dx = { 1, 1, 0, -1, -1, -1, 0, 1 };
    static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        t = new LinkedList<tree>();
        dead = new LinkedList<tree>();
        for (int i = 1; i < N + 1; i++) {
            Arrays.fill(map[i], 5);
        }
        // print();
        A = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < N + 1; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            t.add(new tree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), true));
        }

        while (K != 0) {
            // print();
            spring();
            summer();
            fall();
            winter();
            K--;
        }

        System.out.println(t.size());

    }

    private static void winter() {
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                map[i][j] += A[i][j];
            }
        }
    }

    private static void fall() {

        ArrayList<tree> baby=new ArrayList<tree>();//아기나무
        for (tree tmp : t) {
            if (tmp.age % 5 == 0) {
                for (int d = 0; d < 8; d++) {
                    int nx = tmp.x + dy[d];
                    int ny = tmp.y + dx[d];
                    if (nx >= 1 && nx < N + 1 && ny >= 1 && ny < N + 1) {//사방에 아기나무 심어주기
                        baby.add(new tree(nx, ny, 1, true));//일단 아기나무 좌표를 넣어줌
                    }

                }
            }
        }
        t.addAll(0, baby);//앞에다가 어린 나무를 붙여주면 어린 나무부터 양분을 먹게된다

    }

    private static void summer() {
        while(!dead.isEmpty()) {//죽은 나무 다 양분으로
            tree t=dead.poll();
            map[t.x][t.y]+=t.age/2;
        }
    }

    private static void spring() {//처음 입력은 한칸에 나무 하나

        Iterator<tree> it=t.iterator();//이터레이터로하면 속도가 느리다??
        while(it.hasNext()) {
            tree tmp=it.next();//다음꺼 하나 받아주고
            int r=tmp.x;
            int c=tmp.y;
            int age=tmp.age;

            if(map[r][c]<age) {//양분이 나이만큼 없으면
                dead.offer(tmp);//죽은나무 링크드 리스트에 넣어주고
                it.remove();//중간에 삽입 삭제는 링크드가 빠름
            }else {//있으면
                map[r][c]-=age;//나이만큼 양분 먹고
                tmp.age++;//나이 한살 추가
            }
        }

    }

    public static void print() {
        for (int i = 0; i < N + 1; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println(t.toString());
        System.out.println();
    }

}

class tree {
    int x, y, age;
    boolean alive;

    tree(int x, int y, int age, boolean alive) {
        this.x = x;
        this.y = y;
        this.age = age;
        this.alive = alive;

    }

    @Override
    public String toString() {
        return "tree [x=" + x + ", y=" + y + ", age=" + age + "]";
    }

}