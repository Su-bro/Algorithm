package week7;
import java.util.*;
public class PG_LV2_다리를지나는트럭 {
	
    static public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totweight = 0;
        int comp =0;
        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        for(int t : truck_weights){
            truck.offer(t);
        }
        for(int i = 0; i<bridge_length; i++){
            bridge.offer(0);
        }
        System.out.println(truck);
        while(comp < truck_weights.length){
            answer++;          
            int out = bridge.poll();
            if(out>0){
            	totweight -=out;
                comp++;
            }
            if(!truck.isEmpty() && totweight + truck.peek() <= weight){                
                int nexttruck = truck.poll();
                bridge.offer(nexttruck);
                totweight += nexttruck;
                
            }
            else{
                bridge.offer(0);
            }
            
        }        
        return answer;
    }
    
    public static void main(String[] args) {
		System.out.println("dd");
		int ans = solution(2, 10, new int[] {7,4,5,6});
		System.out.println(ans);
	}

}
