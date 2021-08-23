package algo6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Main_1205조커2 {
	static int N,J,cnt,max,min,size;
	static boolean[] check;		
	public static <T> void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(num==0) {
				J++;
			}else {
				list.add(num);
			}			
		}
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		});
		
		size = list.get(list.size()-1)+1;
		
		check = new boolean[size];
		
		for(Integer i : list) {
			check[i]=true;
		}
		for(int i = 1; i < size; i++) {
			
		}
		
		for(int i = 1; i < check.length-J-2; i++) {
			boolean[] tmp = Arrays.copyOf(check, size);			
			for(int j = 0; j < J; j++) {
				if(!check[i+j]) {
					tmp[i+j]=true;
				}else {
					i++;
					j--;
				}
			}			
			countTrue(tmp,1);				
		}
		System.out.println(cnt);
		
	}
	
	private static void countTrue(boolean[] tmp,int idx) {		
		int tcnt = 0;
		for(int i = idx; i < tmp.length; i++) {			
			if(tmp[i]) {
				tcnt++;
			}else {
				cnt = Math.max(cnt, tcnt);
				tcnt=0;
			}
		}
		
	}

}
