package algo_10;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_9935문자열폭발 {
	static ArrayList<Character> target;
	static char[] boom;
	static boolean go,flag;
	
	public static void main(String[] args) throws IOException {				
		target = new ArrayList<Character>();		
		System.setIn(new FileInputStream("문자열폭발.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++) {
			target.add(str.charAt(i));
		}
		System.out.println(target);
		
		str = br.readLine();		
		boom = new char[str.length()];
		boom = str.toCharArray();
		System.out.println(boom);		
		flag = true;
		while(flag){
			flag=false;			
			for(int i = 0; i < target.size(); i++) {				
				if(target.get(i)==boom[0]) {
					go=true;					
					for(int j = 1; j<boom.length; j++) {
						if((i+j)<target.size()  && target.get(i+j)==boom[j] && go) {
							go=true;							
							continue;
						}else {
							go=false;							
							break;
						}						
					}
					if(go) {
						flag = true;					
						for(int k = i; k<i+boom.length; k++) {
							target.remove(i);
						}
						System.out.println(target);
						break;					
					}				
				}				
			}
		}		
		for(char c : target) {
			sb.append(c);
		}
		if(sb.length()==0) System.out.println("FRULA");
		else System.out.println(sb);

		
			
	}

}
