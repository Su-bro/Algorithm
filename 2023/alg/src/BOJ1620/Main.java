package BOJ1620;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static HashMap<Integer, String> map = new HashMap<>();
    static HashMap<String, Integer> map4s = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            map.put(i, str);
            map4s.put(str, i);
        }

        for (int i = 0; i < M; i++) {
            String temp = br.readLine();
            if (isNumeric(temp)) {
                System.out.println(map.get(Integer.parseInt(temp)));
            } else {
                System.out.println(map4s.get(temp));
            }
        }

    }
    public static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
