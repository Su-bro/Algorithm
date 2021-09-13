package week5;

public class PG_LV2_124나라 {
    //1,2,4 밖에 없다면 3진수로 계산해보자
    public String solution(long n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        //나누어떨어졌을때0이나오면 4 나머지는 1,2
        String[] num = {"4","1","2"}; 
        while(n >0){            
            sb.append(num[(int)n%3]); 
            //일반적인 3진법계산으로 3의배수를 나누면 0, 1이 떨어진다.
            //4를 반환하고 1을빼자.
            if(n%3==0) n = (n/3)-1;
            else n /= 3;
        }
        String str = sb.reverse().toString();
        return str;
    }

}
