package algo5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9811거북이2 {
	static int maxX,minX,maxY,minY;
	static int state,x,y;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < n; t++) {			
			maxX=minX=maxY=minY=state=y=x=0;
			
			String str = br.readLine();			
			
			for(int j = 0; j < str.length(); j++) {
				char cmd = str.charAt(j);
				if(cmd=='F') {
					//System.out.println("F다");						
					y+=dy[state];
					x+=dx[state];
					//map[y][x]=1;
					check();
				}else if(cmd == 'B') {
					//System.out.println("B다");						
					y-=dy[state];
					x-=dx[state];
					//map[y][x]=1;
					check();
				}else if(cmd == 'L') {
					//System.out.println("L다");
					if(state==0) {
						state=3;
					}else if(state == 1) {
						state=2;
					}else if(state == 2) {
						state = 0;
					}else if(state == 3) {
						state = 1;
					}
				}else if(cmd == 'R') {
					//System.out.println("R다");
					if(state==0) {
						state=2;
					}else if(state == 1) {
						state=3;
					}else if(state == 2) {
						state = 1;
					}else if(state == 3) {
						state = 0;
					}
				}
				
			}

			//System.out.println(maxX+ " " + minX + " " + maxY + " " + minY);			
			System.out.println((maxX-minX)*(maxY-minY));
		}
	}
    static void check() {
        maxX = Math.max(maxX, x);
        minX = Math.min(minX, x);
        maxY = Math.max(maxY, y);
        minY = Math.min(minY, y);
    }
}