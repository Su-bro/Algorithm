package BOJ1316;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/BOJ1316/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            Set<Character> charSet = new HashSet<>();
            String next = br.readLine();
            char[] chars = next.toCharArray();
            char prev = chars[0];
            boolean isGroupWord = true;
            for(char c : chars) {
                if(charSet.contains(c) && prev != c) {
                    isGroupWord = false;
                    break;
                } else {
                    charSet.add(c);
                    prev = c;
                }
            }
            if (isGroupWord) {
                count++;
            }
        }
        System.out.println(count);
    }
}
