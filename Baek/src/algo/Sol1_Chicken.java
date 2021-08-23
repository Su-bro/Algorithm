package algo;

import java.util.Scanner;
class Sol1_Chicken {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		int A=sc.nextInt();
		int B=sc.nextInt();
		int C=sc.nextInt();
		int X=sc.nextInt();
		int Y=sc.nextInt();
		int price = 0;
		int price2 = 0;
		/* 양념+후라이드 가격이 반반2마리 가격보다 비쌀 경우
        반반치킨을 양 후 둘중 적은 치킨 마리수*2만큼 구매*/
		if(A+B>=C*2) { 
			if(X>=Y) { // X가 더 크면 Y만큼 반반치킨*2 구매, X-Y만큼 구매
				price = (Y*C*2)+((X-Y)*A);
			}else {
				price = (X*C*2)+((Y-X)*B);
			}
		}else {  //반반치킨이 더 비싸면 그냥 마리수만큼 구매, 프라이스1
			price = (A*X)+(B*Y);
		}
		//조건이 최소인 만큼 반반치킨만 사서 치킨이 오바되도 상관없음 
		
		
        // 반반치킨만 사서 더 쌀 경우는 프라이스2
		if(X>=Y) {
			price2 = X*C*2;
		}else {
			price2 = Y*C*2;
		}
		
		price = Math.min(price, price2);// 프라이스1,2중 작은것이 정답
		System.out.println(price);
		sc.close();
	}
}


