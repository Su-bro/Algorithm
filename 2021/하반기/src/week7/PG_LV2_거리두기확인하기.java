package week7;

public class PG_LV2_거리두기확인하기 {
    static int[] dx={0,0,-1,1}, dy={-1,1,0,0};    
    static int ans;
    static char[][] map;
    
    public void dfs(int y, int x, int dis, boolean[][] check){
        if(dis == 2){
            return;
        }
        check[y][x] = true;
        for(int d = 0; d<4; d++){
            int ny = y+dy[d];
            int nx = x+dx[d];
            if(ny>=5 || nx>=5 || ny<0 || nx<0 || check[ny][nx]) continue;
            if(map[ny][nx] == 'P'){
                // System.out.println("사람만났어");
                ans = 0;
                return;
            }
            else if(map[ny][nx] == 'O'){
                dfs(ny,nx,dis+1,check);
            }
        }
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int p = 0; p<places.length; p++){
            map = new char[5][5];
            for(int i = 0; i<5; i++){
                map[i] = places[p][i].toCharArray();
            }
            ans = 1;
            for(int i = 0; i<5; i++){
                for(int j = 0; j<5; j++){
                    if(map[i][j] == 'P'){
                        dfs(i,j,0,new boolean[5][5]);                     
                    }
                }
            }
            
            answer[p] = ans;
        }
        return answer;
    }

}
