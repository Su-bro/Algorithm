package week13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_14226이모티콘 {
	static class Info{
		int display;
		int clipboard;
		int time;
		public Info(int display, int clipboad, int time) {
			super();
			this.display = display;
			this.clipboard = clipboad;
			this.time = time;
		}		
	}
	
	static int S;
	static boolean[][] v; 
	static Queue<Info> q;
	/*
	 중복되는경우는 고려하지않는다
	 (한칸 지웠을 때 그게 이미 클립보드에 있다면 굳이 복사할필요없잖아)
	 
	1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
	2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
	3. 화면에 있는 이모티콘 중 하나를 삭제한다.
	*/
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		S = sc.nextInt();	
//		System.out.println(S);
		v = new boolean[1001][1001];
		q = new LinkedList<Info>();
		
		//화면에 1개, 클립 0개
		v[1][0] = true; 
		q.add(new Info(1, 0, 0));
		
		while(!q.isEmpty()) {			
			Info now = q.poll();			
			if(now.display >= S) { //S개이상을 뿌리고있으면
				System.out.println(now.time); //지금시간 출력
				return;
			}
			//복사 -> display를 clipboard로 복사한다.
			if(!v[now.display][now.display]) { //
				q.offer(new Info(now.display, now.display, now.time+1));
			}
			//붙여넣기 -> clipboard를 display에 복사한다. 단, 클립보드에 1개 이상 있을때
			//이미 S개 있다면 화면에 클립보드를 붙여넣을 필요가 없어.
			//이전에 클립보드에 있던 내용은 덮어쓰기
			if(now.clipboard > 0 && now.display + now.clipboard <= S && !v[now.display+now.clipboard][now.clipboard]) {
				//디스플레이에 클립보드를 붙여넣기, 시간++;
				q.offer(new Info(now.display+now.clipboard, now.clipboard, now.time+1));
				v[now.display+now.clipboard][now.clipboard]=true;
			}
			
			//하나 빼버리기 단, 화면에 1개 이상 있을때나 빼버려야지
			if(now.display> 0 && !v[now.display-1][now.clipboard]) {
				q.offer(new Info(now.display-1, now.clipboard, now.time+1));
				v[now.display-1][now.clipboard]=true;
			}
			
		}		
	}
}
