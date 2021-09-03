package week3;
import java.util.*;
public class Solution_모의고사_Comparator예제 {
	public int[] solution(int[] answers) {        
        int[] sol1 = {1,2,3,4,5};
        int[] sol2 = {2,1,2,3,2,4,2,5};
        int[] sol3 = {3,3,1,1,2,2,4,4,5,5};
        int[][] score = {{0,1},{0,2},{0,3}};
        for(int i = 0; i<answers.length; i++){
            if(answers[i] == sol1[i%5]) score[0][0]++;
            if(answers[i] == sol2[i%8]) score[1][0]++;
            if(answers[i] == sol3[i%10]) score[2][0]++;
        }
        Arrays.sort(score, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else {
                    return o2[0] - o1[0];
                }
            }
        });

        ArrayList<Integer> list = new ArrayList<>();
        list.add(score[0][1]);
        if(score[1][0] == score[0][0]) list.add(score[1][1]);
        if(score[2][0] == score[0][0]) list.add(score[2][1]);        

        int[] answer = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

}
