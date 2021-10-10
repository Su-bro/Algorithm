package week9;

public class PG_LV2_땅따먹기 {
    static int max;
    static int solution(int[][] land) {
        int answer = 0;
        max = 0;
        dfs(land, 0, 0,-1);
        return answer;
    }
    
    public static void dfs(int[][] land, int now, int sum, int bef){
    	System.out.println(now+","+sum+","+bef);
        if(now >= land.length){
            System.out.println(sum);
            return;
        }
        for(int i = 0; i<land[now].length; i++){
            if(i == bef) continue;
            dfs(land,now+1,sum+land[now][i],i);
        }
    }
    
    
    public static void main(String[] args) {
		solution(new int[][] {{1,2,3,5},{5,6,7,8},{4,3,2,1}});
	}

}
