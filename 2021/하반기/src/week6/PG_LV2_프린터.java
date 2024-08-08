package week6;
import java.util.*;

public class PG_LV2_프린터 {
	
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<int[]>();
        for(int i = 0; i<priorities.length; i++){
            if(i == location){
                q.offer(new int[] {priorities[i], 1});
            }else{
                q.offer(new int[] {priorities[i], 0});
            }
        }
        int max = 0;
        while(!q.isEmpty()){            
            max = getmax(q);
            int[] tmp = q.poll();
            if(tmp[0] < max) {
                q.offer(tmp);                
            }
            else {
                answer++;
                if(tmp[1] == 1){
                    return answer;
                }
            }
            
        }
        
        return answer;
    }
    public int getmax(Queue<int[]> q){
        int max = 0;
        for(int i = 0; i<q.size(); i++){
            int[] tmp = q.poll();
            max = Math.max(max,tmp[0]);
            q.offer(tmp);
        }        
        return max;
    }

}
