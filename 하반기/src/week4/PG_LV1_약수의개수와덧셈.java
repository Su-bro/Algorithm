package week4;

public class PG_LV1_약수의개수와덧셈 {
	public int solution(int left, int right) {
        int answer = 0;
        for(int number = left; number<right+1; number++){
            int count = 0; //기본 2개
            for(int div = 1; div<number+1; div++){ //1부터 number까지 나눠본다
                if(number%div == 0){ //나누어떨어지면
                    count++; //약수 추가
                }
            }
            // System.out.println(number+"의 약수는 "+count+"개");
            if(count%2 == 0){//짝수라면
                answer += number; //더해준다
            }else{ //홀수라면
                answer -= number; //빼준다
            }
        }
        return answer;
    }

}
