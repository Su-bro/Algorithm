package algo2;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Truck_test {	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //트럭대수
		int W = sc.nextInt(); //다리길이
		int L = sc.nextInt(); //최대하중
		Queue<Integer> q = new LinkedList<>();
		int trucks[] = new int[N]; //트럭배열
		int time = 0; //시간 초기화		
		//[7, 4, 5, 6]
		
		for(int t=0; t<N;t++)
		{    //트럭배열
			trucks[t]=sc.nextInt();
		}
		//System.out.println(Arrays.toString(trucks));
		
		
		
		int load = 0; //   부하 초기화		
		int n =0; //트럭넘버
		
		while(n<N) { //트럭의 개수동안
			if(q.size()>=W) {//큐가 다리길이만큼(꽉차면)
				//큐의 첫값 반환, 부하감소
				load -= q.poll();				
			}
			if(q.isEmpty()) 
			{ //다리가 비어있으면					
				q.offer(trucks[n]);//큐에 트럭넣고
				load = load+trucks[n];//부하증가
				time++; //시간++
				n++;//다음트럭
				
			}else //다리에 트럭이 있으면	
			{ 	
				if(load+trucks[n]>L) //다음트럭을 못넣으면
				{
					q.offer(0);//큐에 0넣기
					time++; //시간증가
					
					
				}else //넣을수있으면
				{
					q.offer(trucks[n]);//큐에 트럭넣고
					load = load+trucks[n];//부하증가
					time++; //시간++
					n++;//다음트럭
				}				
			}		
		}
		System.out.println(time+W);
		
	}

}

