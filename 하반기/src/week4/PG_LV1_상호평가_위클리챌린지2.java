package week4;

public class PG_LV1_상호평가_위클리챌린지2 {
	public String solution(int[][] scores) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int mean = 0;
        for(int i = 0; i < scores.length; i++){
            int myscore = scores[i][i];
            int max = 0;
            int min = 101;
            int sum = 0;
            for(int j = 0; j<scores.length; j++){
                if(j!=i) {
                    sum += scores[j][i];
                    max = Math.max(max,scores[j][i]);
                    min = Math.min(min,scores[j][i]);
                }
            }            
            if(myscore > max || myscore < min){
                System.out.println(max+","+min);
                mean = sum/(scores.length-1);
            }else{
                sum += myscore;               
                mean = sum/scores.length;
            }
            if(mean>=90) sb.append("A");
            else if(mean>=80) sb.append("B");
            else if(mean>=70) sb.append("C");
            else if(mean>=50) sb.append("D");
            else sb.append("F");
        }
        // System.out.println(sb.toString());
        return sb.toString();
    }

}
