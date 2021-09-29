package week7;
import java.util.*;
public class PG_LV2_게임맵최단거리 {
	
    static int n,m;
    static int[] dy ={-1,1,0,0}, dx = {0,0,-1,1};
    static boolean[][] check;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        check = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();			
        q.offer(new int[] {0,0,1});
        check[0][0] = true;
        
        while(!q.isEmpty()) {
        	int[] now = q.poll();
        	int y = now[0];
        	int x = now[1];
        	int dist = now[2];
        	if(y==n-1 && x==m-1) return dist;
        	for(int d = 0; d<4; d++) {
        		int ny = y+dy[d];
        		int nx = x+dx[d];
        		if(ny>=n || nx>=m || ny<0 || nx<0 || check[ny][nx]) continue;
        		if(maps[ny][nx]==1) {
        			check[ny][nx] = true;
        			q.offer(new int[] {ny,nx,dist+1});
        		}
        	}
        }
        
        return -1;
    }

}
