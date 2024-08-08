package week4;
import java.util.*;
public class PG_LV2_다트게임_B {
	//https://programmers.co.kr/learn/courses/30/lessons/17682
    public int solution(String dartResult) {
        int answer = 0;        
        char[] arr = dartResult.toCharArray();
        int[] score = new int[3];
        System.out.println(Arrays.toString(arr));
        int round = -1;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] >= '0' && arr[i] <= '9'){ //라운드시작
                round++;
                if(arr[i] == '1' && arr[i+1] == '0'){
                    score[round] = 10;
                    i++;
                }else{
                    score[round] = arr[i]-48;
                }
            }
            else if(arr[i] == 'D'){
                int a = score[round];
                score[round] = score[round] * score[round];             
            }else if(arr[i] == 'T'){
                int a = score[round];
                score[round] = score[round] * score[round] * score[round];             
            }else if(arr[i] == '*'){
                score[round] *= 2;
                if(round>0) score[round-1] *=2;
            }else if(arr[i] == '#'){
                score[round] *= -1;
            }             
        }
        System.out.print(Arrays.toString(score));
        for(int i = 0; i<3; i++){
            answer += score[i];
        }
        
        return answer;
    }

}
