package week1;

public class Solution_키패드누르기 {
	public static int getdist(int fromY, int fromX, int toY, int toX){        
        int dist = 0;
        dist += Math.abs(fromY - toY);
        dist += Math.abs(fromX - toX);        
        return dist;
    }
    
    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[] pedY = {3,0,0,0,1,1,1,2,2,2};
        int[] pedX = {1,0,1,2,0,1,2,0,1,2};
        int LY = 3;
        int LX = 0;        
        int RY = 3;
        int RX = 2;
        
        // System.out.println("왼손 초기위치 : "+ ped[LY][LX]);
        // System.out.println("오른손 초기위치 : "+ ped[RY][RX]);
        
        for(int i = 0; i<numbers.length; i++){
            //1 4 7은 왼손 사용
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                // answer += "L";
                sb.append("L");
                LY = pedY[numbers[i]];
                LX = pedX[numbers[i]];                
            }
            // 3 6 9는 오른손 사용
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                // answer += "R";
                sb.append("R");
                RY = pedY[numbers[i]];
                RX = pedX[numbers[i]]; 
            }
            // 2 5 8 0일 경우
            else{
                int toY = 0;
                int toX = 0;
                toY = pedY[numbers[i]];
                toX = pedX[numbers[i]];
                int Rdist = getdist(RY,RX, toY, toX);
                int Ldist = getdist(LY, LX,  toY, toX);
                // System.out.println(numbers[i]+"까지 왼손과 오른손의 거리 : "+Ldist+","+Rdist);
                if(Rdist < Ldist){
                    // answer += "R";
                    sb.append("R");
                    RY = toY;
                    RX = toX;
                }else if (Ldist < Rdist){
                    // answer += "L";
                    sb.append("L");
                    LY = toY;
                    LX = toX;
                }else if (Ldist == Rdist){
                    if(hand.equals("right")){
                        // answer += "R";
                        sb.append("R");
                        RY = toY;
                        RX = toX;
                    }else{
                        // answer += "L";
                        sb.append("L");
                        LY = toY;
                        LX = toX;
                    }
                }
                
            }
        }
        
        return sb.toString();
    }
    public static void main(String[] args) {
    	System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
	}

}
