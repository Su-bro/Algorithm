package algo2;



import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_트럭다리건너기 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String b= br.readLine();
		StringTokenizer st = new StringTokenizer(b);
		int N=Integer.parseInt(st.nextToken());
		int W=Integer.parseInt(st.nextToken());
		int L=Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>(); //정수형 큐 사용
		int trucks[] = new int[N]; //트럭배열
		int time = 0; //시간 초기화	
		
		String b2= br.readLine();
		StringTokenizer st2 = new StringTokenizer(b2); 		
		for(int t=0; t<N;t++)
		{    //트럭배열
			trucks[t]=Integer.parseInt(st2.nextToken());
		}
		//System.out.println(Arrays.toString(trucks));
		
		
		
		int load = 0; //부하초기화	
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
		//마지막 트럭은 다리의 길이만큼 이동해야함 ( [001]) ->(1[000])
		System.out.println(time+W); //타임+W
		
	}

}

