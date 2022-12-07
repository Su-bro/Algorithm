package BOJ;


import java.io.*;
import java.util.*;

public class Solution {

    static int N,M;
    static char map[][];

    public static void main(String[] args) throws IOException {
//        FileInputStream fis = new FileInputStream("src/BOJ/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = chars[j];
            }
        }
        int minFalldownDist = getDist();
        move(minFalldownDist);
        mapPrint(map);
    }

    static void move(int dist) {
        for (int i = 0; i < M; i++) {
            for (int j = N - 1; j >= 0; j--) {
                if(map[j][i] == 'X') {
                    map[j+dist][i] = 'X';
                    map[j][i] = '.';
                }
            }
        }
    }
    static int getDist() {
        int dist = N;
        for (int i = 0; i < M; i++) {
            int distOfLine = 0;
            boolean isBlock = false;
            for (int j = N - 1; j >= 0; j--) {
                if (map[j][i] == '#') {
                    distOfLine = 0;
                } else if (map[j][i] == '.') {
                    distOfLine++;
                } else if (map[j][i] == 'X') {
                    isBlock = true;
                    break;
                }
            }
            if (isBlock) {
                dist = Math.min(dist, distOfLine);
            }
        }

        return dist;
    }

    static void mapPrint(char[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println(new String(input[i]));
        }
    }
}
