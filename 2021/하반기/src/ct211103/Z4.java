package ct211103;


import java.util.*;
/*
grid	result
[[2,1,1,3,5,1],[1,1,3,3,5,5],[8,3,3,3,1,5],[3,3,3,4,4,4],[3,3,4,4,4,4],[1,4,4,4,4,4]]	[3,2]
[[10,20,30],[40,50,60],[70,80,90]]	[1,9]
[[1,1,1,1],[1,1,1,1]]	[2,4]
*/
public class Z4 {
	public static void main(String[] args) {
		
	}
    /*
    마름모의 크기n
    1 1x1
    2 3x2
    3 5x3
    4 7x4
    5 9x5
    n n+n-1 x n     
    */    
    static int N,M,size;
    public int[] solution(int[][] grid) {
        int[] answer = new int[2];
        N = grid.length;
        M = grid[0].length;
        size=1;
        //최대 마름모 크기 구하기
        for(int i = 1; i<350; i++){
            if(i+i-1 <= Math.max(N,M) && i <= Math.min(N,M)){
                size = i;
            }
        }
        // System.out.println(size);
        boolean able = false;
        //격자안에 만들수있는 최대 마름모 크기부터 2까지 줄여가면서
        for(int s = size; s>1; s--){
            //4가지의 경우에 대해(하좌,하우,좌하,우하)
            //마름모를 만들 수 있는지 체크, 
            for(int i = 0; i<N; i++ ){
                for(int j = 0; j<M; j++){
                    //1.하좌
                    if(i+(s+s-2) < N && j-(s-1) >= 0 && grid[i][j] == grid[i+(s+s-2)][j-(s-1)]){
                        boolean flag = true;
                        // System.out.println(s+","+i+","+j+"하좌 체크");
                        for(int k = 0; k<size;k++){
                            for(int l=k; l<k+size; l++){
                                // System.out.println("l:"+l+" k:"+k+"->"+grid[i+l][j-k]);
                                if(grid[i+l][j-k]!=grid[i][j]) flag = false;
                            }
                        }
                        if(flag) {
                            // System.out.println(s+","+i+","+j+"하좌");
                            answer[0] = size;
                            answer[1]++;
                            able = true;
                            // System.out.println(Arrays.toString(answer));                            
                        }
                    }
                    
                    //2.하우
                    if(i+(s+s-2) < N && j+(s-1) < M && grid[i][j] == grid[i+(s+s-2)][j+(s-1)]){
                        boolean flag = true;
                        // System.out.println(s+","+i+","+j+"하우 체크");
                        for(int k = 0; k<size;k++){
                            for(int l=k; l<k+size; l++){
                                // System.out.println("l:"+l+" k:"+k+"->"+grid[i+l][j+k]);
                                if(grid[i+l][j+k]!=grid[i][j]) flag = false;
                            }
                        }
                        if(flag) {
                            // System.out.println(s+","+i+","+j+"하우");
                            answer[0] = size;
                            answer[1]++;
                            able = true;
                            // System.out.println(Arrays.toString(answer));                            
                        }
                    }
                    
                    //3.좌하
                    if(j-(s+s-2) >= 0 && i+(s-1) < N && grid[i][j] == grid[i+(s-1)][j-(s+s-2)]){
                        boolean flag = true;
                        // System.out.println(s+","+i+","+j+"좌하 체크");
                        for(int k = 0; k<size;k++){
                            for(int l=k; l<k+size; l++){
                                // System.out.println("l:"+l+" k:"+k+"->"+grid[i+k][j-l]);
                                if(grid[i+k][j-l]!=grid[i][j]) flag = false;
                            }
                        }
                        if(flag) {
                            // System.out.println(s+","+i+","+j+"좌하가능");
                            answer[0] = size;
                            answer[1]++;
                            able = true;
                            // System.out.println(Arrays.toString(answer));                            
                        }
                    }                    
                    //4.우하
                    if(j+(s+s-2) < M && i+(s-1) < N && grid[i][j] == grid[i+(s-1)][j+(s+s-2)]){
                        boolean flag = true;
                        // System.out.println(s+","+i+","+j+"우하 체크");
                        for(int k = 0; k<size;k++){
                            for(int l=k; l<k+size; l++){
                                // System.out.println("ni:"+i+k+" nj:"+j+l+"->"+grid[i+k][j+l]);
                                if(grid[i+k][j+l]!=grid[i][j]) flag = false;
                            }
                        }
                        if(flag) {
                            // System.out.println(s+","+i+","+j+"우하가능");
                            answer[0] = size;
                            answer[1]++;
                            able = true;
                            // System.out.println(Arrays.toString(answer));                            
                        }
                    }
                }
                
            }
            //s 사이즈에 가능했다면 사이즈를 더 줄이는건 멈추자
            if(able) break;
        }
        if(!able){
            answer[0] = 1;
            answer[1] = N*M;
        }

    
        
        return answer;
    }

}
