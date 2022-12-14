package BOJ16922;

import java.util.Scanner;

// 로마 숫자 만들기
public class Main {

    static int N, cnt, res[], rom[] = {1, 5, 10, 50};
    static boolean dp[] = new boolean[1001];

    // I(1) V(5) X(10) L(50) 을 사용해 N개의 문자열로 만들 수 있는 숫자의 갯수를 구하자
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        res = new int[N];
        repetitionCombination(0, 0, 0);
        System.out.println(cnt);
    }

    private static void repetitionCombination(int K, int idx, int sum) {
        if (idx == N) {
            if (!dp[sum]) {
                dp[sum] = true;
                cnt++;
            }
            return;
        }
        for (int i = K; i < 4; i++) {
            repetitionCombination(i, idx + 1, sum + rom[i]);
        }
    }

}
