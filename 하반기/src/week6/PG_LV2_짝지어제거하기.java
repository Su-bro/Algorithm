package week6;

import java.util.*;

public class PG_LV2_짝지어제거하기 {
	
    public int solution(String s)
    {
        while(s.length()>2){
            char[] ch = s.toCharArray();
            for(int i = 1; i<ch.length; i++){
                if(ch[i] == ch[i-1]){
                    i++;
                    continue;
                }else{
                    s = "";
                    s += ch[i-1];
                }
            }
            System.out.println(s);
        }
        System.out.println(s);
        return 1;
    }

}

