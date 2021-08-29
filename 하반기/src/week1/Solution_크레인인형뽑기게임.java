package week1;

import java.util.*;

public class Solution_크레인인형뽑기게임 {
	public static int solution(int[][] board, int[] moves) {        
        int answer = 0;        
        Stack<Integer> stack = new Stack<>();
        for(int move : moves){
            for(int i = 0; i < board.length; i++){
            	if(board[i][move-1] != 0) {
            		 System.out.println(move+"인형을 만났네 : "+ board[i][move-1]);
            		stack.add(board[i][move-1]);
            		board[i][move-1] = 0;
                    if(stack.size() >= 2) {
            		    if(stack.peek().equals(stack.elementAt(stack.size()-2))) {
            			 System.out.println(stack+ "터져요");
            			stack.pop();
            			stack.pop();
            			answer +=2;
            		    }
            	    }     
            		break; //포문브레이크      		
            	}
            	          	
            }               
        }
         System.out.println(stack);
        return answer;
    }
	
	public static int solution2(int[][] board, int[] moves) {        
        int answer = 0;        
        Stack<Integer> stack = new Stack<>();
        for(int move : moves){
            for(int i = 0; i < board.length; i++){
            	if(board[i][move-1] != 0) {
            		// System.out.println(move+"인형을 만났네 : "+ board[i][move-1]);
                    if(!stack.isEmpty() && stack.peek().equals(board[i][move-1])){
                        stack.pop();
                        answer +=2;                        
                    } else {
                        stack.add(board[i][move-1]);
                    }
                    //뽑았으니까 0으로
            		board[i][move-1] = 0;
                    
            		break; //포문브레이크      		
            	}
            	          	
            }               
        }
        // System.out.println(stack);
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}},
				new int[] {1, 5, 3, 5, 1, 2, 1, 4}));
		System.out.println(solution2(new int[][] {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}},
				new int[] {1, 5, 3, 5, 1, 2, 1, 4}));
	}

}
