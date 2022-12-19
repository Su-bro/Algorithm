package BOJ2503;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int N, ANS, res[] = new int[3];
    static boolean check[] = new boolean[10];
    static Map<String, Integer> board = new HashMap<>();

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("./src/BOJ2503/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int strk = Integer.parseInt(st.nextToken());
            int bll = Integer.parseInt(st.nextToken());
            board.put(str, strk*10+bll);
        }
        combi(0);
        System.out.println(ANS);
    }

    private static void combi(int depth) {
        if (depth > 2) {
            if(checkAns()) {
                ANS++;
            }
            return;
        }
        for (int i = 1; i < 10; i++) {
            if(!check[i]) {
                check[i] = true;
                res[depth] = i;
                combi(depth+1);
                check[i] = false;
            }
        }
    }

    private static boolean checkAns() {
        for(String key : board.keySet()) {
            String keys[] = key.split("");
            int keyInts[] = new int[3];
            int bll = 0;
            int strk = 0;
            for (int i = 0; i < 3; i++) {
                keyInts[i] = Integer.parseInt(keys[i]);
            }
            for (int i = 0; i < 3; i++) {
                if(keyInts[i] == res[i]) {
                    strk++;
                }
                else {
                    for (int j = 0; j < 3; j++) {
                        if(keyInts[i] == res[j]) {
                            bll++;
                        }
                    }
                }
            }
            if(board.get(key) != strk*10+bll) {
                return false;
            }
        }
        return true;
    }

}
