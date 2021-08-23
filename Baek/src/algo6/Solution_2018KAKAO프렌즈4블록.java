package algo6;

import java.util.Arrays;
//https://programmers.co.kr/learn/courses/30/lessons/17679
public class Solution_2018KAKAO프렌즈4블록 {	
	
	
	public static void main(String[] args) {
		/**
		 * # Testcase 1
		 */
//		int m = 4;
//		int n = 5;
//		String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		/**
		 * # Testcase 2
		 */
		int m = 6;
		int n = 6;
		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};			
		
		int a = solution(m,n,board);
		System.out.println(a);
	}
	
	/**
	 * 
	 * Solution
	 * 
	 */
	static int cnt,answer;
	static int[][] map;
	static boolean [][] check;
    public static int solution(int m, int n, String[] board) {
    	map = new int[m][n]; 
    	for(int i = 0; i < m; i++) {
    		char[] c = board[i].toCharArray();
    		for(int j = 0; j < n; j++) {
    			map[i][j] = c[j];
    		}
    	}
    	//print(map);
    	while(true) {	    	   	   	
	    	
	    	
	    	//2x2블럭 탐색
	    	check = new boolean[m][n]; 
	    	for(int i = 0; i <m-1; i++) {
	    		for(int j = 0; j < n-1; j++) {
	    			if(map[i][j]!=0) search(i,j);    			
	    		}
	    	}
	    	
	    	//true인 부분 제거
	    	boolean flag = false;
	    	for(int i = 0; i < m; i++) {
	    		for(int j = 0; j < n; j++) {
	    			if(check[i][j]) {
	    				flag = true;
	    				map[i][j]=0;
	    				answer++;
	    			}
	    		}
	    	}
	    	//print(map);
	    	gravity(map);
	    	
	    	//print(map);	    	
	    	if(!flag)break;
    	}
    
    	return answer;
    }    
    
    
    private static void gravity(int[][] map) {
		for(int j = map[0].length-1; j >= 0; j--) {
			int space=0;
			for(int i = map.length-1; i >= 0; i--) {				
				if(map[i][j]==0) {
					space++;
				}else if(map[i][j]!=0 ) {
					int tmp = map[i][j];
					map[i][j]=0;
					map[i+space][j]=tmp;
					
				}
			}
		}
    	
	}


	public static void search(int i, int j) {    	
		int id = i+1;
		int jr = j+1;
		//검사블럭과 검사블럭의 down, left, dleft가 일치한다면 
		if(map[i][j] == map[id][j] && map[i][j] == map[i][jr] && map[i][j] == map[id][jr]) {
			//해당 구역 true
			check[i][j] = check[id][j] = check[i][jr] = check[id][jr] = true;
		}		
	}
	
	
	private static void print(int[][] map) {
		for(int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
		
	}

}
