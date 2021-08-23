package algo5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_9811거북이 {
	static int n,x,y,disY,disX;
	static String[] com;
	static String state;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("거북이.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		n = Integer.parseInt(str);
		
		for(int t = 0; t < n; t++) {
			int[][] map = new int[1001][1001];
			int maxX = Integer.MAX_VALUE;
			int maxY = Integer.MAX_VALUE;
			int minX = 0;
			int minY = 0;
			state = "up";
			y=500;
			x=500;			
			map[y][x]=1;
			str = br.readLine();
			com = str.split("");
			
			for(int j = 0; j < com.length; j++) {
				String Command = com[j];
				switch (Command) {
					case "F": {
						//System.out.println("F다");
						move();
						map[y][x]=1;						
						break;
					}
					case "B": {
						//System.out.println("B다");
						back();
						map[y][x]=1;
						break;
					}
					case "L": {
						//System.out.println("L다");
						if(state=="up") {
							state="left";
						}else if(state == "down") {
							state="right";
						}else if(state == "right") {
							state = "up";
						}else if(state == "left") {
							state = "down";
						}						
						break;
					}
					case "R": {
						//System.out.println("R다");
						if(state=="up") {
							state="right";
						}else if(state == "down") {
							state="left";
						}else if(state == "right") {
							state = "down";
						}else if(state == "left") {
							state = "up";
						}
						break;
					}
				}
				
			}
			for(int i = 0; i < 1000; i++) {
				for(int j= 0; j < 1000; j++) {
					if(map[i][j]==1) {
						maxX=Math.min(maxX, j);
						minX=Math.max(minX, j);
						maxY=Math.min(maxY, i);
						minY=Math.max(minY, i);
					}
				}
			}
			//System.out.println(maxX+ " " + minX + " " + maxY + " " + minY);
			disX = maxX-minX;
			disY = maxY-minY;
			System.out.println(Math.abs(disX*disY));
		}
	}

	private static void back() {
		switch (state) {
			case "up": {
				y--;
				break;
			}
			case "down": {
				y++;
				break;
			}
			case "left": {
				x++;
				break;
			}
			case "right": {
				x--;
				break;
			}			
		}
	}

	private static void move() {
		switch (state) {
			case "up": {
				y++;
				break;
			}
			case "down": {
				y--;
				break;
			}
			case "left": {
				x--;
				break;
			}
			case "right": {
				x++;
				break;
			}
		}
		
	}

}
/*
x * y 값을 출력
dy의 초기값 1
dx의 초기값 0

F뜨면 move() 실행

move 메소드에서
state up : y++
state down : y--
state right : x++
state left : x--



*/