package algo;
import java.util.Scanner;
public class Sol2_NextWord_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();		
		char[] c = new char[26];		
		c = s.toCharArray();  //char배열로 변환
		sc.close();
		
		//25자 이하일경우 뒤에 중복되지않는 않는 최소알파벳을 붙일 수 있다.
		if(c.length<26) {		
			//char[] -> int[] 변환
			int[] cint = new int[c.length];
			for(int i=0;i<c.length;i++) {
				cint[i] = c[i];			
			}			
			
			//ascii 최소값 탐색
			int ascii = 97;
			
			for(int i=0;i<cint.length;i++) {
				for(int j=0;j<cint.length;j++) {
					if(cint[j]==ascii) ascii+=1;
				}
			}
			
			//정답 출력
			char nextword = (char)ascii;
			System.out.println(s+nextword);		
		}
		
		//26자면 내림차순이 아니게되는 주소에서 자른다
		else {		
			//내림차순확인
			int i = c.length-1;
			while( i>0 && c[i-1] >= c[i] ) --i;
			//0이면 끝까지 내림차순
			if(i==0) {
				System.out.println(-1);
				System.exit(0);
			}
			
			int j = c.length-1;
			while(c[i-1]>=c[j]) --j;		
			
			c[i-1] = c[j];
			char[] cc = new char[i];
			for(int k=0;k<i;k++) {			
				cc[k]=c[k];
			}
			s= new String(cc);
			System.out.println(s);
		}			
	}
}
///zyxwvutsrqponmlkjihgfedcba
//abcdefghijklmnopqrstuvwzyx