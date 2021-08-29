package week2;

import java.util.Arrays;

public class Solution_K번째수 {
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i<commands.length; i++){
            int len = commands[i][1]-commands[i][0]+1;
            int[] sliced = new int[len];
            for(int j = 0; j<len; j++){
                sliced[j] = array[commands[i][0]-1+j];
            }
            Arrays.sort(sliced);
            answer[i] = sliced[commands[i][2]-1];            
        }
        return answer;
    }
}
