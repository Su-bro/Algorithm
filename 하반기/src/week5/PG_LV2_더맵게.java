package week5;

import java.util.*;

public class PG_LV2_더맵게 {
	
    public int solution(int[] scoville, int K) {
        int answer = 0;        
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for(int s : scoville){
            q.offer(s);
        }
        while(q.peek()<K){
            if(q.size() == 1) return -1;
            
            int a = q.poll();
            int b = q.poll();
            int res = a+(b*2);
            q.offer(res);            
            answer++;                       
        }
        
        return answer;
    }

}
