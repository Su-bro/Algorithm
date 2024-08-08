package week1;

public class Solution_숫자문자열과영단어 {
	public static int solution(String s) {
        int answer = 0;
        String ans_str = "";
        String[] nums = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        String str = "";        
        for(int i = 0; i<s.length(); i++){            
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                ans_str += ch;
            }
            else if(ch >='a' && ch <= 'z'){
                str += ch;
                for(int j = 0; j<nums.length; j++){
                    if(str.equals(nums[j])){
                        ans_str += j;
                        str = "";
                    }
                }
            }
            
        }
        answer = Integer.parseInt(ans_str);
        return answer;
    }
	public static int solution2(String s) {

	    String[]  num= {"0","1","2","3","4","5","6","7","8","9"};
	    String[] word= {"zero" , "one" , "two" , "three" , "four" , "five" , "six" , "seven" , "eight" , "nine"};
	        for (int i = 0 ; i <10 ; i++){
	            s = s.replace(word[i] , num[i]);
	        }
	        return Integer.parseInt(s);
	    }
	public static void main(String[] args) {
		System.out.println(solution("one4seveneight"));
		System.out.println(solution("23four5six7"));
		System.out.println(solution("2three45sixseven"));
		System.out.println(solution("123"));
		System.out.println(solution2("one4seveneight"));
		System.out.println(solution2("23four5six7"));
		System.out.println(solution2("2three45sixseven"));
		System.out.println(solution2("123"));
	}

}
