package week4;
import java.util.*;
public class PG_LV2_단체사진찍기 {
    static char[] ch = {'A','C','F','J','M','N','R','T'};
    static char[] sel;
    static int cnt;
    static boolean[] isSel;    
    
    public void permutation(int idx, String[] data){
        if(idx==8){             
            int check = 0;
            for(String c : data){
                char[] com = c.toCharArray();
                int a1 = 0;
                int a2 = 0;
                for(int i = 0; i<8; i++){
                    if(sel[i] == com[0]) a1 = i;
                    else if(sel[i] == com[2]) a2 = i;
                }
                if(com[3] == '='){ 
                    if(Math.abs(a1-a2) != com[4]-'0'+1) return;                  
                }else if(com[3] == '>'){
                    if(Math.abs(a1-a2)<=com[4]-'0'+1) return;
                }else if(com[3] == '<'){
                    if(Math.abs(a1-a2)>=com[4]-'0'+1) return;
                }  
                check++; 
            }
            if(check==data.length) {
            	cnt++;
            }            
            return;
        }
        for(int i = 0; i<8;i++){
            if(isSel[i]) continue;
            sel[idx] = ch[i];
            isSel[i] = true;
            permutation(idx+1,data);
            isSel[i] = false;            
        }
        
        
    }
    public int solution(int n, String[] data) { 
        int answer = 0;
        cnt = 0;
        sel = new char[8];
        isSel = new boolean[8];
        permutation(0,data);
        answer = cnt;
        return answer;
    }

}
