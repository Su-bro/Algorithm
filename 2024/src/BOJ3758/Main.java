package BOJ3758;

import java.io.*;
import java.util.*;

public class Main {

    static int dataCount;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/BOJ3758/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dataCount = Integer.parseInt(br.readLine());
        for (int t = 0; t < dataCount; t++) {
            String[] info = br.readLine().split(" ");
            int numberOfTeams = Integer.parseInt(info[0]);
            int numberOfProblems = Integer.parseInt(info[1]);
            int myTID = Integer.parseInt(info[2]);
            int numberOfLogs = Integer.parseInt(info[3]);
            Submission[] submissions = new Submission[numberOfTeams + 1];
            for (int i = 1; i <= numberOfTeams; i++) {
                submissions[i] = new Submission(i);
            }
            for (int i = 0; i < numberOfLogs; i++) {
                String[] log = br.readLine().split(" ");
                int tid = Integer.parseInt(log[0]);
                int pid = Integer.parseInt(log[1]);
                int score = Integer.parseInt(log[2]);
                submissions[tid].count++;
                submissions[tid].lastSubmissionTime = i;
                Map<Integer, Integer> solved = submissions[tid].solved;
                if (!solved.containsKey(pid)) {
                    solved.put(pid, score);
                } else {
                    Integer prevScore = solved.get(pid);
                    if (score > prevScore) {
                        solved.put(pid, score);
                    }
                }
            }
            List<Submission> submissionList = new ArrayList<>();
            for (int i = 1; i <= numberOfTeams; i++) {
                submissionList.add(submissions[i]);
            }
            submissionList.sort(new SubmissionComparator());

            for (int i = 0; i < submissionList.size(); i++) {
                if (submissionList.get(i).tid == myTID) {
                    System.out.println(i+1);
                }
            }
        }
    }
}

class Submission {
    // team's id
    int tid;
    int count;
    int lastSubmissionTime;
    // key: pid, value: score
    Map<Integer, Integer> solved;

    // default constructor
    Submission(int tid) {
        this.tid = tid;
        this.solved = new HashMap<>();
    }

    public String toString() {
        return "tid: " + tid + ", solved: " + solved;
    }

    public int totalScore() {
        int total = 0;
        for (int score : solved.values()) {
            total += score;
        }
        return total;
    }
}

class SubmissionComparator implements Comparator<Submission> {
    @Override
    public int compare(Submission s1, Submission s2) {
        int scoreCompare = Integer.compare(s2.totalScore(), s1.totalScore());
        if (scoreCompare != 0) {
            return scoreCompare;
        }
        int countCompare = Integer.compare(s1.count, s2.count);
        if (countCompare != 0) {
            return countCompare;
        }
        return Integer.compare(s1.lastSubmissionTime, s2.lastSubmissionTime);
    }
}
