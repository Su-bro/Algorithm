package algo6;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2477참외밭2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int [] length = new int[6];
		int W = 0;
		int w = 0;
		int H = 0;
		int h = 0;
		for(int i = 0; i < 6; i++) {
			int d = sc.nextInt();
			length[i]= sc.nextInt();
			
		}
		for(int i = 0; i < 6; i++) {
			if(i%2==0) {
				if(W<length[i]) {
					W=length[i];
				}			
			}else {
				if(H<length[i]) {
					H=length[i];
				}
			}			
		}
		
		
		
		for(int i = 0; i < 6; i++) {
			if(i%2==0) {
				if(H==length[(i+5)%6]+length[(i+1)%6]) {
					w=length[i];
				}
			}else {
				if(W==length[(i+5)%6]+length[(i+1)%6]) {
					h=length[i];
				}
			}	
		}
		
		//System.out.println(H+" , "+W+" , "+h+" , "+w);
		System.out.println((H*W - h*w)*K);
	}
	

}
