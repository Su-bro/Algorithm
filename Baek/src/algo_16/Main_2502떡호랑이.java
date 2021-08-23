package algo_16;

import java.util.*;

public class Main_2502떡호랑이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int D = sc.nextInt();
		int K = sc.nextInt();
		int day[][] = new int[D+1][2];
		day[1][0] = 1; //첫말 준 떡
		day[2][1] = 1; //둘째날 준 떡
		
		for (int i = 3; i <= D; i++) { //3일차부터
			for (int j = 0; j < 2; j++) { //번갈아넣어가며
				day[i][j] = day[i-2][j]+day[i-1][j];				
			}
		}
		System.out.print("첫날에 준 떡 ~ A떡 [");
		for (int i = 0; i < day.length; i++) {
			System.out.print(day[i][0]+",");
		}
		System.out.println("]");
		System.out.print("둘째날에 준 떡 ~ B떡 [");
		for (int i = 0; i < day.length; i++) {
			System.out.print(day[i][1]+",");
		}
		System.out.println("]");
		
		for (int i = 1; i <= K; i++) {
			if((K-day[D][0]*i) % day[D][1] == 0) { //41-3*i  % 5
				System.out.println(i);
				System.out.println((K - day[D][0] * i) / day[D][1]);
				break;
			}
		}
	}

}
