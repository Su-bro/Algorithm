package algo6;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2477참외밭 {
	static int n;
	static int[][] tmp = new int[6][2];
	static int[] ori = new int[4];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int x = 0;
		int y = 0;
		for(int i = 0; i < 6; i++) {
			tmp[i][0]=sc.nextInt()-1; //모든 입력을 저장하는 2차배열
			tmp[i][1]=sc.nextInt();
			//원본 밭의 길이를 저장
			ori[tmp[i][0]]+=tmp[i][1];
		}
		//System.out.println(Arrays.toString(ori));
		int flag = 0;
		for(int i = 0; i < 6; i++){
			
			int idx = tmp[i][0]; //tmp[i]의 0은 인덱스
			int length = tmp[i][1]; // 1 은 길이
			if(i+1<5 && (length+tmp[i+1][1]==ori[0] || length+tmp[i+1][1]==ori[2])) {
				x=tmp[i+1][1];
				y=tmp[i+2][1];
				break;
			}
			if(ori[idx]!=length && flag==0) {
					if(i==0) {
						x=length;
						y=tmp[i+1][1];
						break;
					}
					x = ori[idx]-length;
					y = tmp[i+1][1];
					break;
			}
		}
		//System.out.println(x+" "+y);
		
		int dif = (ori[0]*ori[2])-(x*y);
		System.out.println(dif*n);
		
	}

}
