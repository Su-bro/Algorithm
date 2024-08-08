package week7;
import java.util.*;
public class PG_LV2_프렌즈4블록 {
	
    static int N,M,ans;
    static char map[][];
    static boolean check[][];
    static int[] dy = {1,1,0}, dx={1,0,1};
    public int solution(int m, int n, String[] board) {
        N = m;
        M = n;
        map = new char[N][M];
        check = new boolean[N][M];
        for(int i = 0; i<N; i++){
            map[i] = board[i].toCharArray();
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println("---------------------");
        
        boolean boom = true;        
        while(boom){      
            boom = false;  
            for(int i = 0; i<N; i++){
                for(int j = 0; j<M; j++){
                    if(map[i][j] >='A'){
                        char temp = map[i][j];
                        int ny1 = i+dy[0];
                        int ny2 = i+dy[1];
                        int ny3 = i+dy[2];
                        int nx1 = j+dx[0];
                        int nx2 = j+dx[1];
                        int nx3 = j+dx[2];
                        if(ny1>=N || ny1<0 || nx1>=M || nx1<0) continue;
                        if(map[ny1][nx1] == temp && map[ny2][nx2] == temp && map[ny3][nx3] == temp){
                            // System.out.println(i+","+j+"|"+ny1+","+nx1+"|"+ny2+","+nx2+"|"+ny3+","+nx3);
                            boom = true;
                            check[i][j] = true;
                            check[ny1][nx1] = true;
                            check[ny2][nx2] = true;
                            check[ny3][nx3] = true;

                        }
                    }
                }
            }
            for(int i = 0; i<N; i++){
                for(int j = 0; j<M; j++){
                    if(check[i][j]){
                        ans++;
                        check[i][j] = false;
                        map[i][j] = '*';
                    }
                }
            }
            for(int i = 0; i<N; i++){
                System.out.println(Arrays.toString(map[i]));
            }
            System.out.println("---------------------");
            for(int j = 0; j<M; j++){
                int cnt = 0;
                for(int i = N-1; i>=0; i--){                
                    if(map[i][j] == '*'){
                        cnt++;
                    }
                    else if(map[i][j]!='*'){
                        map[i+cnt][j] = map[i][j];
                        if(cnt>0) map[i][j] = '*';
                    }

                }
            }
            for(int i = 0; i<N; i++){
                System.out.println(Arrays.toString(map[i]));
            }
            System.out.println("---------------------");
            
        }
        
        
        return ans;
    }

}
