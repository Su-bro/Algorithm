package week4;

import java.util.*;
public class PG_LV1_실패율_Double_Comparator주의 {
	public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] now = new int[N+1];
        int[] clear = new int[N+1];
        for(int s : stages){
            if(s < N+1){
                now[s] +=1;
                for(int i = 1; i<=s; i++){
                    clear[i] +=1;
                }
            }else{
                for(int i = 1; i<N+1; i++){
                    clear[i] +=1;
                }
            }            
        }
        // System.out.println(Arrays.toString(now));
        // System.out.println(Arrays.toString(clear));
        double[][] rate = new double[N][2];
        for(int i = 0; i<N; i++){
            rate[i][1] = i+1;
            if(clear[i+1] != 0){ //0인경우 에러
                rate[i][0] = (double) now[i+1]/clear[i+1];
            }
            // System.out.println(Arrays.toString(rate[i]));
        }
        Arrays.sort(rate, new Comparator<double[]>(){
            @Override
            public int compare(double[] o1, double[] o2){
                if(o1[0] == o2[0]){
                    if(o1[1]>o2[1]) return 1;
                    else return -1;
                }
                if(o1[0]>o2[0]) return -1;
                else return 1;
            }
        });
        for(int i = 0; i<N; i++){
            // System.out.println(Arrays.toString(rate[i]));
            answer[i] = (int)rate[i][1];
        }
        
        
        return answer;
    }

}
