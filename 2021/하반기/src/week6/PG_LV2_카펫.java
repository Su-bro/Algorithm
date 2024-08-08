package week6;

public class PG_LV2_카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int size = brown+yellow;
        for(int i = 3; i<size; i++){
            int col = i;
            if(size%col != 0) continue;
            int row = size/col;
            if((col-2) * (row-2) == yellow  ){
                answer[0] = row;
                answer[1] = col;
                return answer;
            }
        }
        
        return answer;
    }

}
