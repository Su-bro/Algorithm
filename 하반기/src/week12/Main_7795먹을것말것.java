package week12;

import java.io.*;
import java.util.*;

public class Main_7795먹을것말것 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int ans = 0;
			int Asize = Integer.parseInt(st.nextToken());
			int Bsize = Integer.parseInt(st.nextToken());
			Integer A[] = new Integer[Asize]; // 객체로 만들어야해
			Integer B[] = new Integer[Bsize];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < Asize; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < Bsize; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(B, Comparator.reverseOrder());
			Arrays.sort(A, Comparator.reverseOrder());
			System.out.println("#testcase"+(tc+1));
			System.out.println("A:"+Arrays.toString(A));
			System.out.println("B:"+Arrays.toString(B));			
			for (int i = 0; i < Asize; i++) {
				int a=0;
				for (int j = a; j < Bsize; j++) {
					if (A[i] > B[j]) {
						ans += (Bsize - j);
						System.out.println(A[i] + " is bigger than " + B[j]+ " ans:" + ans);
						a=j;
						break;
					}
				}

			}
			System.out.println(ans);
		}
	}

}

/*
2
5 3
8 1 7 3 1
3 6 1
3 4
2 13 7
103 11 290 215


*/