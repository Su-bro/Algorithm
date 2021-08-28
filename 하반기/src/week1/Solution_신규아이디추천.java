package week1;

public class Solution_신규아이디추천 {
	
	public String solution(String new_id) {        
        String answer = "";
        //소문자로 치환
        new_id = new_id.toLowerCase();
        //System.out.println(new_id);
        //소문자, 숫자, -,_,. 제외하고 제거
        String id = "";
        for(int i = 0; i<new_id.length(); i++){
            char ch = new_id.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                id += ch;
            }
            if(ch >= '0' && ch <= '9'){
                id += ch;
            }
            else if(ch == '-' || ch == '_' || ch == '.'){
                id+=ch;
            }
        }
        System.out.println(id);
        
        //연속된 마침표 하나로
        boolean isDot = false;
        String id2 = "";
        for(int i = 0; i<id.length(); i++){
            char ch = id.charAt(i);
            if(ch == '.'){
                if(!isDot){                    
                    id2 += ch;                    
                    isDot = true;
                }
            }else{
                id2 += ch;
                isDot = false;
            }
        }
        System.out.println(id2);
        
        //new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        String id3 = "";
        for(int i = 0; i<id2.length(); i++){
            char ch = id2.charAt(i);
            if(ch == '.'){
                if(i != 0 && i != id2.length()-1){
                    id3 += ch;
                }
            }
            else id3 += ch;
        }        
        
        //new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(id3.length() == 0){
            id3 += "a";
        }
        System.out.println(id3);
        
        //new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        String id4 = "";
        if(id3.length() >= 16){
            for(int i=0; i<15; i++){
                char ch = id3.charAt(i);
                if(ch != '.' || i != 14){
                    id4+=ch;
                }
                
            }
            System.out.println(id4);
            answer = id4;
        }        
        //new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.       
        else if(id3.length() <= 2){
            int plus = 3 - id3.length();
            char ch = id3.charAt(id3.length()-1);
            for(int i = 0; i<plus; i++){
                id3 += ch;
            }
            System.out.println(id3);
            answer = id3;
        }
        else{
            answer = id3;
        }
        
        
        
        return answer;
    }
	

}
