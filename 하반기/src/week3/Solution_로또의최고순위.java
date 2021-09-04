package week3;

public class Solution_로또의최고순위 {
	
	public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int blank = 0;
        int eq = 0;
        for(int i = 0; i<6; i++){
            if(lottos[i] == 0) blank++;
            for(int j = 0; j<6; j++){
                if(lottos[i] == win_nums[j]){
                    eq++;
                }
            }
        }
        int rank[] = {6,6,5,4,3,2,1};
        answer[1] = rank[eq];
        answer[0] = rank[blank+eq];
        return answer;
    }

}
