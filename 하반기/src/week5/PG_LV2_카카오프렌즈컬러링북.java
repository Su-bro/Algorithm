package week5;

public class PG_LV2_카카오프렌즈컬러링북 {
	
    static int M,N,area;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;    
    static boolean[][] check;
    
    public void dfs(int y, int x, int[][] picture,int color) {
        check[y][x] = true;
        for(int d = 0; d<4; d++){
            int ny = y+dy[d];
            int nx = x+dx[d];
            if(ny>=N || nx>=M || ny<0 || nx<0 )continue;
            if(!check[ny][nx] && picture[ny][nx] == color){
                check[ny][nx] = true;
                area++;
                dfs(ny,nx,picture,color);
            }
        }
        
    }
    public int[] solution(int m, int n, int[][] picture) {
        N=m;
        M=n;
        int[] answer = new int[2];
        int cnt = 0;
        check = new boolean[N][M];
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(!check[i][j] && picture[i][j] != 0){                    
                    cnt++;
                    area = 1;
                    dfs(i,j,picture,picture[i][j]);
                    // System.out.println("고향"+area);
                    answer[1] = Math.max(answer[1],area);
                }
            }            
        }        
        answer[0] = cnt;  
        return answer;
    }

}
