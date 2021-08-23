package algo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main_단어뒤집기 {	
	
//	원래 원했던 구성 :                   for문 문자열 배열 스캔
//		유한 상태머신 state 에 따라 동작구성, n[i+1]에 따른 다음 상태로의 이동
//		s1 ->(if a) -> s2 -> (if b) -> s1
//		문제점 : i+1 레인지 아웃
	
	
	/**단어뒤집기 함수지정*/	 
	public static String reverseString(String s) {
		//스트링버퍼로 받아온 스트링 리버스, 스트링화
		    return ( new StringBuffer(s) ).reverse().toString();
		  }	
	/**메인*/	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str= br.readLine();
		
		//입력받은 스트링을 Array화
		char[] strCAry = str.toCharArray();
		
		//상태 초기== 0;
		// 0 - 화살괄호 밖에 있는 상태
		// 1 - 화살괄호 내부에 들어온 상태
		int state = 0;
		
						
		// 기록변수 초기화		
		String record = "";
		//스트링 배열 스캔하며
		for(int i = 0; i<strCAry.length;i++) {
			
			/** 화살괄호를 만났을때, 괄호 내부 동작*/
			if(strCAry[i]=='<') { 
				// '<' 를 만나면 기록한것 리버스하여 출력
				System.out.print(reverseString(record));
				record = ""; //레코드 초기화
				state=1; // 화살괄호 내부에 들어온 상태
				// '<' 출력
				System.out.print(strCAry[i]);	
				
				// '>' 를 만나면
			}else if(strCAry[i]=='>') {
				state=0; // 화살괄호 밖에 있는 상태
				System.out.print(strCAry[i]);	
				
			}else if(state==1) {
				// '<' 출력
				System.out.print(strCAry[i]);
				
			}
			
			/** 화살괄호가 없을 때, 괄호 외부 동작*/
			else {	//띄어쓰기를 만나면
				if(strCAry[i]==' ') {
					//기록된 레코드 리버스하여 출력
					System.out.print(reverseString(record)+' ');
					record = "";  //초기화
				}
				else { //레코드 기록
					record+=strCAry[i];
				}			
			}			
		}
		//포문이 끝나면 레코드 출력
		System.out.print(reverseString(record));		
	}
}

//   <   space   >space space space<    spa   c e>