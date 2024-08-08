package week5;
import java.util.*;
public class PG_LV2_오픈채팅방 {
	
	  public String[] solution(String[] record) {         
	        //액션 어레이, dic:{유저아이디,닉네임}
	        ArrayList<String[]> act = new ArrayList<String[]>();
	        Map<String,String> users = new HashMap<String,String>();        
	        for(String s : record){ //record를 스트링배열로
	            String[] st = s.split(" ");
	            if(st[0].equals("Enter")){ //action리스트 추가
	                act.add(new String[]{st[1],"님이 들어왔습니다."});
	                users.put(st[1],st[2]);  ///맵 갱신                  
	            }else if(st[0].equals("Leave")){
	                act.add(new String[]{st[1],"님이 나갔습니다."});
	            }else if(st[0].equals("Change")){
	                users.put(st[1],st[2]);//맵 갱신
	            }
	        }
	        //액션리스트 사이즈만큼 배열생성
	        String[] answer = new String[act.size()];     
	        for(int i=0; i<answer.length; i++){
	            //액션리스트 uid에 해당하는 value와 동작 메세지 저장
	            answer[i] = users.get(act.get(i)[0])+act.get(i)[1];
	        }
	        return answer;
	    }

}
