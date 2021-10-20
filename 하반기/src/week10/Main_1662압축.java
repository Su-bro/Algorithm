package week10;

import java.util.*;

/*
접근방법
1. 스트링 스플릿
2. 마지막 '(' 위치 체크
3. ')'가 등장했을때, 만약 '('가 바로 앞에 있었으면
		1. 마지막 '('의 위치보다 앞에 있는 문자열 어펜드
		2. ')'보다 뒤에 있는 문자열 어펜드
   
   아니라면
        1. 마지막 '('의 위치보다 앞에 있는 문자열 어펜드
        2. 마지막 '('의 위치 뒤부터 ')' 의 위치 앞까지문자열을 더함 String add
        3. '('의 위치 앞에있는 숫자만큼 append 반복
        4. ')'보다 뒤에 있는 문자열 어펜드
        
4. 마지막 '('의 위치가 0보다 크다면 (압축풀게 있었다면) 재귀
5. '(' 가 나온적이 없다면 압축이 전부 해제된것, str의 length() 리턴
*/
public class Main_1662압축 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();		
		sol(str);
	}
	private static void sol (String str) {
		StringBuilder sb = new StringBuilder();
		String[] s = str.split("");		
//		System.out.println(Arrays.toString(s));
		int lastopen = 0;
		for(int i = 0; i<s.length; i++) {
			if(s[i].equals("(")) lastopen = i;
			if(s[i].equals(")")) {				
				if(i == lastopen+1){
					sb.append(str.substring(0, i-2));
					sb.append(str.substring(i+1,s.length));
//					System.out.println(sb.toString());
					break;
				}
				else {
					sb.append(str.substring(0, lastopen-1));
//					System.out.println("앞글자어펜드:"+sb.toString());
					int mult = Integer.parseInt(s[lastopen-1]);					
					String add = "";
					for(int j = lastopen+1; j<i; j++) {
						add +=s[j];
					}
					for(int m = 0; m<mult; m++) {
						sb.append(add);
//						System.out.println(add+"어펜드:"+sb.toString());
					}
					sb.append(str.substring(i+1,s.length));
					break;
				}				
			}
			
		}
//		System.out.println(sb.toString());
		
		if(lastopen!=0) sol(sb.toString());
		if(lastopen == 0) System.out.println(str.length());
	}

}