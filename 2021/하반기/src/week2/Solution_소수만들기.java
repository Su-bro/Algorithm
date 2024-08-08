package week2;

import java.util.Arrays;

public class Solution_소수만들기 {
	static int ans;
    public void primecheck(int num){
        //소수인가
        boolean isprime = true;
        for(int i = 2; i<num/2; i++){ //2부터 숫자의(1/2)-1까지 나누어보았을때
            if(num%i == 0){ //나누어 떨어지면 소수가 아니다.
                isprime = false;
            }
        }
        if(isprime){ //한번도 나누어 떨어진적이 없으면 소수다
            ans++;
        }
    }    
    public void combination(int[] nums, int[] sel, int idx, int cnt){        
        if(cnt == 3){//전부 골랐으면
            //배열의 합을 구해라.
            int sum = Arrays.stream(sel).sum();
            //배열이 소수인지 체크
            primecheck(sum);
            return;
        } 
        for(int i = idx; i< nums.length;i++) {
            //고를 숫자의 인덱스 올려가면서
			sel[cnt] = nums[i];//고르고
			combination(nums, sel, i+1, cnt+1); //재귀
		}
    }
    
    public int solution(int[] nums) {
        ans = 0;   
        combination(nums, new int[3], 0,0);

        return ans;
    }

}
