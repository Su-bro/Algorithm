package algo_14;

import java.util.Scanner;

public class Solution_3238이항계수 {
	
	static long n,r,f[]=new long[300000];
	static int t,p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <=T; tc++) {
			n = sc.nextLong();
			r = sc.nextLong();
			p = sc.nextInt();
			f[0] = 1;
			for (int i = 1; i < p; i++) {
				f[i] = (f[i-1]*i) % p;
			}
			long ans = 1L;
			
			while(n!=0 || r!=0) {
				long a = n%p;
				long b = r%p;
				if(a<b) ans = 0;
				if(ans ==0) break;
				ans *= f[(int) a];
				ans %= p;
				ans *= mpow((f[(int) b]*f[(int) (a-b)]) % p, p-2);
				ans %= p;
				n /= p;
				r /= p;
			}			
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static long mpow(long a, long b) {
		long res = 1L;
		while(b!=0) {
			if((b&1) != 0) {
				res *=a;
				res %= p;
			}
			a *= a;
			a %= p;
			b /= 2;			
		}		
		return res;
	}	

}
