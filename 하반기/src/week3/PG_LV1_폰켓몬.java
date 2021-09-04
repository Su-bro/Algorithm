package week3;

public class PG_LV1_폰켓몬 {
	public int solution(int[] nums) {
		int answer = 0;
		boolean[] isSel = new boolean[200001];
		for (int sel : nums) {
			if (!isSel[sel]) {
				isSel[sel] = true;
				answer++;
			}
			if (answer == nums.length / 2)
				return answer;
		}
		return answer;
	}

}
