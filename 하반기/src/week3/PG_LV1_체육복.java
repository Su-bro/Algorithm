package week3;

import java.util.Arrays;

public class PG_LV1_체육복 {
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        //전체배열
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = 1;
            
        }
        for(int r : reserve){
            arr[r-1] = 2;
        }
        for(int l : lost){
            arr[l-1]--;
        }
        
        for(int i = 0; i<n; i++){
            if(arr[i] == 0){
                if(i-1>=0 && arr[i-1]==2){
                    arr[i] = 1;
                    arr[i-1] = 1;
                }else if(i+1<n && arr[i+1]==2){
                    arr[i] = 1;
                    arr[i+1] = 1;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        for(int i : arr){
            if(i>0) answer++;
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(6,new int[] {2,4,6}, new int[] {1,4}));
	}
	
	

}
