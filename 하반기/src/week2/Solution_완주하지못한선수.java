package week2;

import java.util.*;

public class Solution_완주하지못한선수 {
	public static String solution(String[] participant, String[] completion) {        
        Arrays.sort(participant);//정렬
        Arrays.sort(completion);        
        for(int i=0; i<completion.length; i++){//인덱스 찾아가면서            
            if(!completion[i].equals(participant[i])){//일치하지않는다 == 완주못했다.       
                return participant[i]; //그놈출력
            }
        }//일치하지않는걸 못찾았다면
        return participant[participant.length-1];//마지막인덱스가 미완주자겠지
    }
	public static void main(String[] args) {
		System.out.println(solution(new String[]{"leo", "kiki", "eden"},new String[]{"eden", "kiki"}));
	}

}
