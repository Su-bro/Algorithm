package BOJ2941;

import java.io.*;

public class Main {

    static final String[] croatianAlphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) throws Exception {;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for (String ca : croatianAlphabets) {
            while (input.contains(ca)) {
                input = input.replaceFirst(ca, " ");
            }
        }
        System.out.println(input.length());
    }
}
