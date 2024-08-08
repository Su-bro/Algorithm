package week6;

public class PG_LV3_징검다리건너기 {
	public static int solution(int[] stones, int k) {
		int answer = 0;
		int low = 0;
		int high = 0;
		for (int i = 0; i < stones.length; i++) {
			high = Math.max(high,stones[i]);
		}
		while(low<=high) {
			int mid = (low+high)/2;
			if(check(mid,stones,k)) { //가능해?
				//가능하면
				answer = mid; //답은 mid지
				low = mid+1; //근데 더 체크할수있나 함 보자고 
			}
			else {//불가능해??
				high = mid-1; // 그럼 하이를 줄여보자
			}
		}		
		return answer;
	}


	public static boolean check(int mid, int[] stones, int k) {
		int zerocnt = 0;
		for (int i = 0; i < stones.length; i++) {
			if(stones[i]<mid ) {
				zerocnt+=1;
				if(zerocnt>=k) return false;
			}
			else zerocnt = 0;			
		}		
		return true;
	}

}
