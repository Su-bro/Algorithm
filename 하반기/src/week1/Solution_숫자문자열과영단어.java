package week1;

public class Solution_숫자문자열과영단어 {
	public int solution(String s) {
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

}
