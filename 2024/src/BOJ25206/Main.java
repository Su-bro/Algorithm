package BOJ25206;

import java.io.*;

public class Main {

    private static float totalScore;
    private static float totalCredits;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String input = br.readLine();
            if(input == null){
                break;
            }
            String[] arr = input.split(" ");
            float credits = Float.parseFloat(arr[1]);
            String grade = arr[2];
            if (grade.equals("P")){
                continue;
            }
            float score = Score.getScore(grade);
            totalScore += credits*score;
            totalCredits += credits;
        }
        float gpa = totalScore/totalCredits;
        System.out.println(gpa);
    }

    public enum Score {
        AP("A+", 4.5F),
        AZ("A0", 4.0F),
        BP("B+", 3.5F),
        BZ("B0", 3.0F),
        CP("C+", 2.5F),
        CZ("C0", 2.0F),
        DP("D+", 1.5F),
        DZ("D0", 1.0F),
        F("F", 0.0F)
        ;

        final String grade;
        final float score;

        Score(String s, float v) {
            grade = s;
            score = v;
        }
        public static float getScore(String grade) {
            for(Score s : Score.values()){
                if(s.grade.equals(grade)){
                    return s.score;
                }
            }
            return 0.0F;
        }

    }
}
