package week2;

import java.util.Arrays;

public class Solution_직업군추천하기 {
	public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        //직업군 배열
        String[] SI = table[0].split(" ");
        String[] CONTENTS = table[1].split(" ");
        String[] HARDWARE = table[2].split(" ");
        String[] PORTAL = table[3].split(" ");
        String[] GAME = table[4].split(" ");
        //직업군 사전순 배열
        String[] lang = {"CONTENTS","GAME","HARDWARE","PORTAL","SI"};
        //직업군 점수 배열
        int[] score = {0,0,0,0,0};        
        for(int i = 0; i<languages.length; i++){
            //해당 언어가 직업군 배열에 존재할경우.
            if(Arrays.asList(SI).indexOf(languages[i]) >0 ){
                //해당 언어의 직업군 배열 인덱스 점수를 점수 배열에 더한다.
                score[4] += (6-Arrays.asList(SI).indexOf(languages[i]))*preference[i];
            }
            if(Arrays.asList(CONTENTS).indexOf(languages[i]) >0 ){
                score[0] += (6-Arrays.asList(CONTENTS).indexOf(languages[i]))*preference[i];
            }
            if(Arrays.asList(HARDWARE).indexOf(languages[i]) >0 ){
                score[2] += (6-Arrays.asList(HARDWARE).indexOf(languages[i]))*preference[i];
            }
            if(Arrays.asList(PORTAL).indexOf(languages[i]) >0 ){
                score[3] += (6-Arrays.asList(PORTAL).indexOf(languages[i]))*preference[i];
            }
            if(Arrays.asList(GAME).indexOf(languages[i]) >0 ){
                score[1] += (6-Arrays.asList(GAME).indexOf(languages[i]))*preference[i];    
            }
        }
        int max = 0;
        for(int i = 0; i<score.length; i++){
            //직업군 점수 최대치
            if(score[i]>max){
                max = score[i];
                //최대치 점수 갱신
                answer = lang[i];
            }
        }


        return answer;
    }

}
