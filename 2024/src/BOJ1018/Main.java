package BOJ1018;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

    static final char[][] START_WITH_W = {
        {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
        {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
        {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
        {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
        {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
        {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
        {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
        {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
    };

    static final char[][] START_WITH_B = {
        {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
        {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
        {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
        {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
        {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
        {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
        {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
        {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
    };

    static int height, width;
    static char[][] board;
    static int[][] diffWithW, diffWithB;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BOJ1018/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        height = Integer.parseInt(input.split(" ")[0]);
        width = Integer.parseInt(input.split(" ")[1]);
        board = new char[height][width];
        diffWithW = new int[height + 1][width + 1];
        diffWithB = new int[height + 1][width + 1];

        for (int i = 0; i < height; i++) {
            board[i] = br.readLine().toCharArray();
        }

        // 각 칸에서 두 가지 패턴과의 차이를 계산하여 누적 합 배열에 저장
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                diffWithW[i + 1][j + 1] = diffWithW[i][j + 1] + diffWithW[i + 1][j] - diffWithW[i][j] + (board[i][j] != START_WITH_W[i % 8][j % 8] ? 1 : 0);
                diffWithB[i + 1][j + 1] = diffWithB[i][j + 1] + diffWithB[i + 1][j] - diffWithB[i][j] + (board[i][j] != START_WITH_B[i % 8][j % 8] ? 1 : 0);
            }
        }

        int minRepaints = Integer.MAX_VALUE;

        // 8x8 부분 보드 탐색
        for (int i = 0; i <= height - 8; i++) {
            for (int j = 0; j <= width - 8; j++) {
                int repaintsW = diffWithW[i + 8][j + 8] - diffWithW[i][j + 8] - diffWithW[i + 8][j] + diffWithW[i][j];
                int repaintsB = diffWithB[i + 8][j + 8] - diffWithB[i][j + 8] - diffWithB[i + 8][j] + diffWithB[i][j];
                minRepaints = Math.min(minRepaints, Math.min(repaintsW, repaintsB));
            }
        }

        System.out.println(minRepaints);
    }
}
