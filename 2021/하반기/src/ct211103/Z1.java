package ct211103;

import java.util.*;
import java.io.*;
/*
n	result
2	3
3	12
*/
public class Z1 {
	public static void main(String[] args) throws Exception {
		long n = 100000;
		long ans = solution(n);
		System.out.println(ans);
	}
    /*
    n=1  {}
    n=2 {3}
    n=3 {4,8}
    n=4 {5,10,15}
    -> 규칙
    n+1 * 1,2,3...n-1    
    */
    public static long solution(long n) {
        long answer = 0;
        for(int i =1; i<n; i++){
            answer+=(n+1)*i;
        }
        return answer;
    }
}
