package week10;

/*
숫자를 만나면 len++
last숫자 저장
(를 만나면 [i-1, len-1] 푸시, len=0

)를 만나면 int[] a = st.pop()
len = (len * a[0]) + a[1]
*/
import java.util.*;
public class Main_1662압축stack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] s = str.split("");
		Stack<int[]> st = new Stack<>();
		int len = 0;
		int last = 0;
		for(int i = 0; i<s.length; i++) {
			if(!s[i].equals("(") && !s[i].equals(")")) {
				len++;
				last = Integer.parseInt(s[i]);
			}
			if(s[i].equals("(")) {
				st.push(new int[] {last,len-1});
				len = 0;
			}
			if(s[i].equals(")")) {
				int[] a = st.pop();
				len = (len*a[0]) + a[1];
			}
		}
		System.out.println(len);
		
	}
}

