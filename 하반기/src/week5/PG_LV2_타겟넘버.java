package week5;

public class PG_LV2_타겟넘버 {
	
    
    static int cnt;
    static void dfs(int[] num, int t,int idx, int sum){
        if(idx == num.length){
            if(sum == t) cnt++;
            return;
        }
        dfs(num,t,idx+1,sum+num[idx]);
        dfs(num,t,idx+1,sum-num[idx]);
        
    }
    public int solution(int[] numbers, int target) {
        cnt = 0;
        dfs(numbers, target,0,0);
        int answer = cnt;
        return answer;
    }

}
