package week6;

import java.util.*;

public class PG_LV2_짝지어제거하기 {
	
    public int solution(String s)
    {
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(st.isEmpty()){
                st.add(s.charAt(i));
            }
            else if(s.charAt(i) ==  st.peek()){
                st.pop();
            }
            else if(s.charAt(i) != st.peek()){
                st.add(s.charAt(i));
            }
        }
        if(st.size()>0){
            return 0;
        }        
        
        return 1;
    }

}

