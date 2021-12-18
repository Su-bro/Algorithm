package week16;

import java.util.*;
import java.io.*;

public class Main_4889_안정적인문자열 {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    int t = 1;
	    while(true) {
	        char[] input = br.readLine().toCharArray();

	        if(input[0]=='-') break;

	        int answer = 0;
	        Stack<Character> st = new Stack<>();

	        for (int i = 0; i < input.length; i++) {
	            if(input[i]=='}') {
	                if(st.size()==0) { //닫는 괄호(})이고 여는 괄호가 없으면 치환하고 카운트 업
	                    answer ++;
	                    input[i] = '{';
	                    st.push(input[i]);
	                } else st.pop(); //닫는 괄호(})이고 여는 괄호가 담겨있으면 pop
	            } else st.push(input[i]); //여는 괄호({)면 push
	        }

	        answer += st.size()/2; //스택에 남았다 = 여는 괄호 수 (바꿔야되는 괄호의 수*2)
	        System.out.printf("%d. %d\n", t, answer);
	        t++;
	    }
	}

}
