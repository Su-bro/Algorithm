package BOJ2607;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int wordLength;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/BOJ2607/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String word = br.readLine();
        char[] wordArr = word.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : wordArr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        wordLength = word.length();

        for (int i = 0; i < n - 1; i++) {
            String nextWord = br.readLine();
            if (isSimilar(new HashMap<>(map), nextWord)) {
                count++;
//                System.out.println("is similar : " + nextWord);
            }
        }
        System.out.println(count);
    }

    public static boolean isSimilar(Map<Character, Integer> map, String word) {
        char[] wordArr = word.toCharArray();
        Map<Character, Integer> compareMap = new HashMap<>();
        for (char c : wordArr) {
            compareMap.put(c, compareMap.getOrDefault(c, 0) + 1);
        }
//        System.out.println("map : " + map + "\ncompareMap : " + compareMap);
        int diff = getDiff(map, compareMap);
        int lengthDiff = Math.abs(wordLength - word.length());
//        System.out.println("diff : " + diff+ " lengthDiff : " + lengthDiff);
        return (lengthDiff == 0 && diff <= 2) || (lengthDiff == 1 && diff <= 1);
    }

    public static int getDiff(Map<Character, Integer> map, Map<Character, Integer> compareMap) {
        int diff = 0;
        Set<Character> allChars = new HashSet<>(map.keySet());
        allChars.addAll(compareMap.keySet());
        for (char c : allChars) {
            int v = map.getOrDefault(c, 0);
            int cv = compareMap.getOrDefault(c, 0);
            diff += Math.abs(v - cv);
        }
        return diff;
    }
}
