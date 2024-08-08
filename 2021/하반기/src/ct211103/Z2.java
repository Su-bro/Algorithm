package ct211103;
/*
[[1, 0, 5],[2, 2, 2],[3, 3, 1],[4, 4, 1],[5, 10, 2]]	[1,3,4,2,5]
[[1, 0, 3], [2, 1, 3], [3, 3, 2], [4, 9, 1], [5, 10, 2]]	[1,3,2,4,5]
[[1, 2, 10], [2, 5, 8], [3, 6, 9], [4, 20, 6], [5, 25, 5]]	[1,2,4,5,3]
 */

import java.util.*;

public class Z2 {
	public static void main(String[] args) {
		int[][] data = new int[][] {{1, 0, 5},{2, 2, 2},{3, 3, 1},{4, 4, 1},{5, 10, 2}};
		int[] ans = solution(data);
		System.out.println(Arrays.toString(ans));
		
	}
    public static int[] solution(int[][] data) {
        int[] answer = new int[data.length];
        int time=0;
        int pages=0;
        int done = 0;
        int[] now = new int[3];    
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2){
                return o1[2]-o2[2];
            }
        });
        while(done<data.length){ //작업해야하는 문서 수 만큼 
            // System.out.println(time+"초 작업시작");  
            //현재 시각에 요청되는 문서 찾기
            for(int i =0; i<data.length; i++){
                if(data[i][1]==time){ //인쇄요청시각이 현재시각과 일치한다면
                    // System.out.println(data[i][0]+"번문서 큐에 추가");
                    pq.add(data[i]);
                }
            }
            if(pages==0){                
                if(!pq.isEmpty()){
                    // System.out.println("새 문서 출력 시작");
                    now = pq.poll();
                    //출력해야할 페이지 올림
                    pages = now[2];
                }
            }
            //지금 인쇄중인 페이지가 있다면
            if(pages>0) {
                pages--;
                // System.out.println(now[0]+"출력중.. 남은페이지:"+pages);
                if(pages==0){ //출력완료했다면
                    //done번째로 출력한 문서를 저장
                    answer[done] = now[0];                    
                    done++;
                }
            }                
            time++;   
        }
        
        // System.out.println("done");
        return answer;
    }

}
