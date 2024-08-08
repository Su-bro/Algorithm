package BOJ1157;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toUpperCase();
        char[] chars = input.toCharArray();
        int[] charCount = new int[26];
        int maxCount = 0;
        for (char c : chars) {
            charCount[c - 'A']++;
            maxCount = Math.max(maxCount, charCount[c - 'A']);
        }
        int maxIndex = 0;

        for (int i = 1; i < charCount.length; i++) {
            if (charCount[i] == maxCount) {
                if (maxCount == charCount[maxIndex]) {
                    System.out.println("?");
                    return;
                }
                maxIndex = i;
            }
        }
        System.out.println((char) (maxIndex + 'A'));
    }
}
