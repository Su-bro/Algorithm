package week10;
import java.util.*;



public class Solutuion1 {	
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        //아이디별 int 부여
        Map<String, Integer> usermap = new HashMap<String, Integer>();
        //신고 2차원배열
        int[][] reportmap = new int[id_list.length][id_list.length];
        //Map에 아이디입력
        for(int i=0; i<id_list.length; i++){
            usermap.put(id_list[i],i);
        }
        //report별로
        for(int i=0; i<report.length; i++){ 
            String[] rp = report[i].split(" ");
            int from = usermap.get(rp[0]);
            int to = usermap.get(rp[1]);
            reportmap[to][from] = 1;
            // System.out.println(rp[0]+","+rp[1]);
            // System.out.println(from+","+to);            
        }
        // for(int[] r : reportmap){
        //     System.out.println(Arrays.toString(r));
        // }
        for(int i = 0; i<reportmap.length; i++){
            int sum = 0;
            for(int j = 0; j<reportmap[0].length; j++){
                sum += reportmap[i][j];
            }
            if(sum>=k){
                for(int j = 0; j<reportmap[0].length; j++){
                    if(reportmap[i][j] == 1){
                        answer[j]++;
                    }
                }
            }
            
        }        
        
        return answer;
    }
    

}
