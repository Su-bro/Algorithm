package ct211103;

import java.util.*;

/*
histogram	result
[2, 2, 2, 3]	4
[6, 5, 7, 3, 4, 2]	12
*/
public class Z3 {
	public static void main(String[] args) {
		
	}	
	
    //n개의 히스토그램중 2개만 true인 조합
    //0 ~ n-1 중 2개를 가지는 조합?
    //true인 a1, a2에 대해
    //map[a1], map[a2]에 대해 둘중 작은값이 h
    //water = |a1-a2|-1 * h
    
    // N이 100,000이면
    // 10만 C 2 -> 50억.. 터질까
    // 거리가1인 |a1-a2| == 1 은 안쓴다    
    static int max,sel[],n,map[];    
    public int solution(int[] hist) {
        map = hist;
        max = 0;
        n = map.length;
        sel = new int[2];
        combi(0,0);
        
        return max;
    }
    //Basic Combination
    public static void combi(int cnt, int start){
        if(cnt==2){
            // System.out.println(Arrays.toString(sel));
            int water = (Math.abs(sel[0]-sel[1])-1) * (Math.min(map[sel[0]],map[sel[1]]));
            max = Math.max(max,water);
            return;
        }
        for(int i = start; i<n;i++){
            //가지치기
            if(cnt==1){
                //a1이랑 a2 거리가 1이면 빗물은 무조건 0이니까 패스
                if(Math.abs(sel[0]-i) != 1){
                    sel[cnt] = i;
                    combi(cnt+1,i+1);
                }
            }
            else{
                sel[cnt] = i;
                combi(cnt+1,i+1);
            }
        }
    }

}
