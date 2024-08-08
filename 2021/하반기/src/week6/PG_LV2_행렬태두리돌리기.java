package week6;

public class PG_LV2_행렬태두리돌리기 {
	
    public int[] solution(int rows, int columns, int[][] queries) {        
        int[][] map = new int[rows][columns];
        int[][] ori = new int[rows][columns];
        int o = 0;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                o++;
                map[i][j] = o;
                ori[i][j] = o;
            }
        }
        // for(int i = 0; i<rows; i++){
        //     System.out.println(Arrays.toString(map[i]));
        // }
        
        int[] answer = new int[queries.length];
        for(int q = 0; q<queries.length; q++){
            int min = 100000;
            int[] query = queries[q];
            int fy = query[0] -1;
            int fx = query[1] -1;
            int ty = query[2] -1;
            int tx = query[3] -1;
            for(int i = fx+1; i<=tx; i++){
                map[fy][i] = ori[fy][i-1];
                min = Math.min(min, map[fy][i]);
                // System.out.print(map[fy][i]+",");
            }
            for(int i = fy+1; i<=ty; i++){
                map[i][tx] = ori[i-1][tx];
                min = Math.min(min, map[i][tx]);
                // System.out.print(map[i][tx]+",");
            }
            for(int i = tx-1; i>=fx; i--){
                map[ty][i] = ori[ty][i+1];
                min = Math.min(min, map[ty][i]);
                // System.out.print(map[ty][i]+",");
            }
            for(int i = ty-1; i>=fy; i--){
                map[i][fx] = ori[i+1][fx];
                min = Math.min(min, map[i][fx]);
                // System.out.print(map[i][fx]+",");
            }
            // System.out.println(min);
            for(int i = 0; i<rows; i++){
                for(int j = 0; j<columns; j++){
                    ori[i][j] = map[i][j];
                }
            }
            answer[q] = min;
        }
        
        
        return answer;
    }

}
