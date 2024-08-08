package algo_15;


import java.util.Scanner;

public class Solution_2115벌꿀채취 {
    static int N, M, C;
    static int[][] map;
    static int maxSum = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test = 1; test <= t; test++) {
            N = sc.nextInt();
            M = sc.nextInt();
            C = sc.nextInt();
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            System.out.println("#" + test + " " + getMaxBenefit());
        }
    }

    static int getMaxBenefit() {
        return processComb();
    }

    static int processComb() {
        int result = 0, aBenefit = 0, bBenefit = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N - M; j++) { // 첫 열부터 연속된 M개 채취가 가능한 열까지, 일꾼 A의 선택
                // 선택된 M개 벌통에서 얻을 수 있는 최대 이익
                maxSum = 0;
                makeMaxSubset(i, j, 0, 0, 0);
                aBenefit = maxSum;
                // 일꾼 B의 선택 ( 일꾼 A와 같은 행에 뒷쪽 열에서 선택 / 일꾼 A의 다음 행에서부터 선택 )

                maxSum = 0;
                bBenefit = 0;
                // 같은행
                for (int j2 = j + M; j2 <= N - M; j2++) {
                    makeMaxSubset(i, j2, 0, 0, 0); // maxSum
                    if (bBenefit < maxSum)
                        bBenefit = maxSum;
                }

                // 다음행
                for (int i2 = i + 1; i2 < N; i2++) {
                    for (int j2 = 0; j2 <= N - M; j2++) {
                        makeMaxSubset(i2, j2, 0, 0, 0);
                        if (bBenefit < maxSum)
                            bBenefit = maxSum;
                    }
                }
                if(result<aBenefit+bBenefit)result=aBenefit+bBenefit;
            }
        }
        return result;
    }

    static void makeMaxSubset(int i, int j, int cnt, int sum, int powerSum) {
        if (sum > C)
            return;
        if (cnt == M) {
            if (maxSum < powerSum)
                maxSum = powerSum;
            return;
        }
        // 선택 - 값 증가
        makeMaxSubset(i, j + 1, cnt + 1, sum + map[i][j], powerSum + (map[i][j] * map[i][j]));
        // 비선택 - 값은 그대로
        makeMaxSubset(i, j + 1, cnt + 1, sum, powerSum);
    }
}
