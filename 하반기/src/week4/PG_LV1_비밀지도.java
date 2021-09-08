package week4;

public class PG_LV1_비밀지도 {
	public String generatebinary(int num, int len){
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while(num > 0){
            sb.append((num%2));
            num /= 2;
            cnt++;
        }
        for(int i = 0; i<len-cnt; i++){
            sb.append("0");
        }
        return sb.reverse().toString();
    }
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i<n; i++){
            String str1 = generatebinary(arr1[i],n);
            String str2 = generatebinary(arr2[i],n);
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<n; j++){
                if(str1.charAt(j) == '0' && str2.charAt(j) == '0') {
                    sb.append(" ");
                }else{
                    sb.append("#");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }

}
