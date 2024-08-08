package week10;

import java.util.Arrays;

public class Solutuion2 {

	public static int solution(int n, int k) {
		int answer = 0;
		// k진수로 변환
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			sb.append(n % k);
			n /= k;
		}
		char[] ch = sb.reverse().append("0").toString().toCharArray();
		String nums = "";
		long num = (long) 0;
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == '0') {
				boolean isPrime = false;
				if (nums.length() > 0) {
					num = Long.parseLong(nums);
					if (num > 1) {
						boolean check = true;
						for (long p = 2; p * p <= num; p++) {
							if (num % p == 0) {
								check = false;
								break;
							}
						}
						if (check)
							isPrime = true;
					}
				}
				if (isPrime) {
					answer++;
				}
				nums = "";
			} else {
				nums += ch[i];
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		
		//야 어디서 터지냐?
		for(int i = 1000000; i >= 1; i--) {
			for(int j = 3; j<=10; j++) {
				System.out.println(solution(i, j));
			}
		}

	}
}
