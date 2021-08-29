package algo6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import sun.java2d.marlin.ArrayCacheConst;

public class Main_1205조커 {
	static int N,J,cnt,max,min,size;
	static boolean[] check;		
	public static <T> void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		PriorityQueue<Integer> q = new PriorityQueue<>();
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
		System.out.println(list);
		
		size = list.get(list.size()-1)+1;
		
		check = new boolean[size];
		
		System.out.println(check.length);
		
		for(Integer i : list) {
			check[i]=true;
		}
		for(int i = 1; i < size; i++) {
			
		}
		
		for(int k = 1; k < size; k++) {
			System.out.print("["+k+":"+check[k]+"]");				
		}
		System.out.println();
		
		for(int i = 1; i < check.length-J; i++) {
			boolean[] tmp = Arrays.copyOf(check, size);			
			for(int j = 0; j < J; j++) {
				if(!check[i+j]) {
					tmp[i+j]=true;
				}else {
					i++;
					j--;
				}
			}
			
			for(int k = 1; k < size; k++) {
				System.out.print("["+k+":"+tmp[k]+"]");				
			}
			System.out.println();
			countTrue(tmp,1);			
		}
	}
	
	private static void countTrue(boolean[] tmp,int idx) {
		
		for(int i = idx; i < tmp.length; i++) {
			if(tmp[i]) {
				if(i+1<tmp.length && tmp[i+1]) {
					cnt++;
				}
			}
			
		}
		
	}

}
