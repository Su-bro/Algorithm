package week4;

import java.util.*;

public class PG_LV2_두개뽑아서더하기 {
	
	
	int[] sel = new int[2];
    ArrayList<Integer> list = new ArrayList<>();
    boolean[] check = new boolean[200];
    public void comb(int[] numbers,int cnt,int idx){
        if(cnt == 2) {
            if(!check[sel[0]+sel[1]]){
                list.add(sel[0]+sel[1]);
                check[sel[0]+sel[1]] = true;
            }
            return;
        }
        for(int i=idx; i<numbers.length; i++){
            sel[cnt] = numbers[i];
            comb(numbers, cnt+1,i+1);
        }        
    }
    public int[] solution(int[] numbers) {        
        comb(numbers,0,0);
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i = 0; i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

}
