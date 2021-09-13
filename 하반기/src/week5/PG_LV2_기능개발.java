package week5;

import java.util.*;

public class PG_LV2_기능개발 {
	
    public int[] solution(int[] progresses, int[] speeds) {   
        Queue<Integer> days = new LinkedList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i< progresses.length; i++){
            int day = (100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i] !=0 ) day++;
            days.offer(day);
        }
        while(!days.isEmpty()){
            int p = days.peek();
            int cnt = 0;
            boolean isdone = false;
            while(!isdone){
                if(!days.isEmpty() && days.peek() <= p){
                    days.poll();
                    cnt++;
                }else{
                    list.add(cnt);
                    cnt = 0;
                    isdone = true;
                }
            }            
        }        
        int[] answer = new int[list.size()];
        for(int i = 0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }

}
