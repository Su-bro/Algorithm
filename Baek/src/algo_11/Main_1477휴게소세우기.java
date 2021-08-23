package algo_11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main_1477휴게소세우기 {
	static int N, M, L, h[];

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/algo_11/휴게소.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		h = new int[N + 2];
		h[0] = 0; // 시작구간
		h[N + 1] = L; // 끝구간
		for (int i = 1; i < N + 1; i++) {
			h[i] = sc.nextInt();
		}

		Arrays.sort(h);
		// System.out.println(Arrays.toString(h));
		int left = 1;
		int right = Integer.MAX_VALUE - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			int sum = 0;

			for (int i = 1; i < N + 2; i++) {
				if (h[i] > h[i - 1])
					sum += (h[i] - h[i - 1] - 1) / mid;
			}

			if (sum > M)
				left = mid + 1;
			else
				right = mid - 1;
		}

		System.out.println(left);

	}

}
