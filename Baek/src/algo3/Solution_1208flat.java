package algo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//import java.util.Scanner;
import java.util.StringTokenizer;


public class Solution_1208flat {
	static int N;	
	
	
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		for(int t=1;t<=10;t++)
		{
			String b = br.readLine();
			StringTokenizer st = new StringTokenizer(b);
			//N = sc.nextInt();
			N= Integer.parseInt(st.nextToken());
			String b2 = br.readLine();
			StringTokenizer st2 = new StringTokenizer(b2);
			int arr[] = new int[100];
			for(int i = 0; i<100; i++) {
				//arr[i]=sc.nextInt();
				arr[i]=Integer.parseInt(st2.nextToken());
			}
			flatt(arr,0);				
			System.out.println("#"+t+" "+(arr[99]-arr[0]));
		}
	}	
	public static void flatt(int arr[], int idx) {
		if(idx==N) {
			Arrays.sort(arr);
			return;
		}
		Arrays.sort(arr);
		arr[0]++;
		arr[99]--;
		flatt(arr,idx+1);
	}

}

/*
834
42 68 35 1 70 25 79 59 63 65 6 46 82 28 62 92 96 43 28 37 92 5 3 54 93 83 22 17 19 96 48 27 72 39 70 13 68 100 36 95 4 12 23 34 74 65 42 12 54 69 48 45 63 58 38 60 24 42 30 79 17 36 91 43 89 7 41 43 65 49 47 6 91 30 71 51 7 2 94 49 30 24 85 55 57 41 67 77 32 9 45 40 27 24 38 39 19 83 30 42 


*/