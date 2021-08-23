package algo_10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468안전영역 {
	static int n,maxHeight;
	static int[][] map;	
	static boolean[][] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/algo_10/안전영역.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}
		//print();
		for (int i = 0; i < maxHeight-1; i++) {
			v = new boolean[n][n];
			int safe = countsafezone(i);
			System.out.println();
		}
		
	}
	private static int countsafezone(int h) {
		int cnt = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j]>h && v[i][j]) {
					q.add(map[i][j]);
				}
			}
		}		
		
		return cnt;
	}
	
	private static void print() {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	

}
