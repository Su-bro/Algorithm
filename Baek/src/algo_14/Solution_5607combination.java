package algo_14;

import java.util.Scanner;

public class Solution_5607combination {
	
	static int N,R,Q = 1234567891;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <=T; tc++) {
			N = sc.nextInt();
			R = sc.nextInt();
			
			long ans = nCr(N,R,Q);
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	private static long nCr(int n, int r, int p) {
		if( r == 0) {
			return 1L;
		}
		long[] fac = new long[n+1];
		fac[0] = 1;
		
		for (int i = 1; i <= n; i++) {
			fac[i] = fac[i-1] * i % p;
		}	
		
		return (fac[n]*power(fac[r],p-2,p) % p * power(fac[n-r], p-2,p) % p ) %  p;

	}
	
	private static long power(long x, long y, long p) {
		long res = 1L; 
        x = x % p;           
        while (y > 0) {    
            if (y % 2 == 1) res = (res * x) % p; 
            y = y >> 1;
            x = (x * x) % p; 
        }  
        return res;
	}
}
