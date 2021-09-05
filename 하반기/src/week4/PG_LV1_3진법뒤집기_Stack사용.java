package week4;

import java.util.Stack;

public class PG_LV1_3진법뒤집기_Stack사용 {
	
	public int solution(int n) {
        int answer = 0;     
        Stack<Integer> stack = new Stack<Integer>();
        while(n!=0){
            stack.add(n%3);
            n = n/3;
        }
        int mul = 1;
        while(!stack.isEmpty()){
            // System.out.print(stack.pop());
            answer += stack.pop() * mul;
            mul = mul*3;
        }
            
        return answer;
    }
	
	

}
