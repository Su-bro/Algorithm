package week4;

public class PG_LV2_문자열압축 {
    public int solution(String s) {
        int answer = 1000;
        System.out.print(s);
        //1. char배열로 나눈다
        char[] ch = s.toCharArray();
        
        for(int len = 1; len <= s.length()/2+1; len++ ){
            String res= "";
            int remain = 0;
            // 3. 시작점 len칸씩 올라간다
            for(int st = 0; st<= s.length()-len; st+=len){
                
                // 4. 비교할 문자열을 만든다, 몇개나 일치하는지 숫자를 만든다.
                String temp1 = "";
                
                for(int i = 0; i<len; i++){ //l만큼의 길이
                    temp1 += ch[st+i]; //문자열에 더함
                }
                
                // 5. 문자열 뒤에있는 문자열도 비교해본다
                int eqcnt = 0;
                for(int st2 = st+len; st2<= s.length()-len; st2+=len){ //시작점은 비교문자열+len
                    String temp2 = "";
                    for(int i = 0; i<len; i++){ //l만큼의 길이
                        temp2 += ch[st2+i]; //문자열에 더함
                    }
                    if(temp1.equals(temp2)){
                        eqcnt++; //일치하면 eqcnt를 올린다.                       
                    }else{ //일치하지않으면
                        break; //여기서끝내                        
                    }
                }
                if(eqcnt > 0) {
                    res += (eqcnt+1)+temp1;
                    st += len*eqcnt;
                }
                else{
                    res +=temp1;
                }
                    
                remain = s.length() - st - len; //남아있는 문자열은       
                
            } 
            for(int i = 0; i<remain; i++){
                res += ch[s.length()-remain+i];
            }
            // System.out.println(res+","+res.length());
            answer = Math.min(answer, res.length());
        }        
        return answer;
    }

}
