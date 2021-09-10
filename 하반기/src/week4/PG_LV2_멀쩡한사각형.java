package week4;

public class PG_LV2_멀쩡한사각형 {

	public long solution(long w, long h) {
		long answer = 0;

		for (int i = 0; i < w; i++) {
			answer += h * i / w;
		}

		return answer * 2;
	}

}
