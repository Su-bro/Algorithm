package week5;
import java.util.*;

public class PG_LV2_전화번호목록 {
	
    public boolean solution(String[] phone_book) {
        boolean answer = true;        
        Map<String,Boolean> map = new HashMap<String,Boolean>();       
        Arrays.sort(phone_book);        
        for(String st : phone_book){
            for(int i = 1; i<=st.length(); i++){
                if(map.get(st.substring(0,i))!=null){
                    return false;
                }                
            }
            map.put(st,false);
        }
        return answer;
    }

}
