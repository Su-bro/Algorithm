package week8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main_BOJ_14891톱니바퀴 {
	
	static int[][] gear= new int[4][8];
	static int Ans;
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("톱니바퀴.txt"));
		Scanner sc = new Scanner(System.in);
		
		//바퀴배열 2차원배열로 저장
		for(int i = 0; i < 4; i++) {
			String str = sc.nextLine();
			String st[] = str.split("");			
			for(int j = 0; j<8; j++) {
				gear[i][j] = Integer.parseInt(st[j]);				
			}
		}
		
		
		int k = sc.nextInt();
		//k번 작업
		for(int i = 0; i < k; i++) {
			//돌리는 바퀴
			int idx = sc.nextInt();
			//돌리는 방향
			int dir = sc.nextInt();
			//idx = 2번톱니바퀴 = 1번 배열
			sol(idx-1,dir);
		}
		
		if (gear[0][0] == 1) {
			Ans += 1;
		}
		if (gear[1][0] == 1) {
			Ans += 2;
		}
		if (gear[2][0] == 1) {
			Ans += 4;
		}
		if (gear[3][0] == 1) {
			Ans += 8;
		}
		System.out.println(Ans);	
	}	
	
	
	
	private static void sol(int idx, int dir) {
		left(idx-1, dir*-1);
		right(idx+1,dir*-1);
		//마지막에 처음놈 로테이트
		rotate(idx,dir);
	}
	
	private static void rotate(int idx, int dir) {
		if(dir==1){
			int[] tmp = new int[8];
			tmp[0]=gear[idx][7];
			for(int j = 1; j < 8; j++) {
				tmp[j]=gear[idx][j-1];
			}
			gear[idx]=tmp;		
		}
		
		if(dir==-1){
			int[] tmp = new int[8];
			tmp[7]=gear[idx][0];
			for(int j = 0; j < 7; j++) {
				tmp[j]=gear[idx][j+1];
			}
			gear[idx]=tmp;		
		}
	}
	
	static void left(int idx, int dir) {
		if (idx < 0)return;
		//양 극이 다르면
		if (gear[idx][2] != gear[idx + 1][6]) {
			//다음 녀석까지 검사해야함(만약 이놈이 돌면 다음놈에서 이놈 검사를 못함)
			//도는 방향을 반대로 바꿔준다.
			left(idx - 1, -dir);
			//다 돌고 끝나면 다시 뒤로 돌아오면서 돌리고
			rotate(idx, dir);
		}
		//같으면 그 아래의 톱니바퀴도 돌지 않기때문에 그대로 끝.
	}

	
	static void right(int idx, int dir) {
		if (idx > 3)return;

		if (gear[idx][6] != gear[idx - 1][2]) {
			right(idx + 1, -dir);
			rotate(idx, dir);
		}
	}
}
//원래 하려던 것 -> rotateL, rotateR 재귀함수를 이용
// 0<idx 왼쪽, idx<3 오른쪽 재귀보내면서 2번 6번 인덱스 검사, 돌리기 or 패스 dir*-1
// 문제점 - 하나의 메소드가 길어지고 코드에 오류가 생김
// 해결방안 - 컨닝
// 느낀점 - 1. 동작설정을 받아주는 구현부, 동작1, 동작2 등으로 메소드를 분할하여 코드를 짜야겠다(오류잡기쉬움)
//        2. 원하는 동작의 메소드를 미리 구상하여 부품처럼 미리 만들어두고 조립하는 방식으로 해결해봐야겠다.

