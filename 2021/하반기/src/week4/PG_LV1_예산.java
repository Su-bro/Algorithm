package week4;

import java.util.Arrays;

public class PG_LV1_예산 {
	
	
	public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int i: d){
            if(budget >= i){
                answer++;
                budget -= i;
            }
        }
        return answer;
    }
	
	

}
