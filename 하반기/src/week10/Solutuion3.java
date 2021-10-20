package week10;

import java.util.*;
import java.util.Map.Entry;

public class Solutuion3 {

	static class Info implements Comparable<Info> {
		String carnum;
		String in;
		String out;

		public Info(String carnum, String in, String out) {
			this.carnum = carnum;
			this.in = in;
			this.out = out;
		}

		@Override
		public String toString() {
			return "Info [carnum=" + carnum + ", in=" + in + ", out=" + out + "]";
		}

		@Override
		public int compareTo(Info o) {
			return this.carnum.compareTo(o.carnum);
		}
	}

	public static int[] solution(int[] fees, String[] records) {

		ArrayList<String> list = new ArrayList<String>();
		Map<String, String[]> map = new HashMap<String, String[]>();
		Map<String, Integer> fee = new HashMap<String, Integer>();
		for (String st : records) {
			String[] rec = st.split(" ");
			if (rec[2].equals("IN")) {
				// 차량번호에 기록한다.
				if (map.get(rec[1]) == null && fee.get(rec[1]) == null)
					list.add(rec[1]);
				map.put(rec[1], new String[] { rec[0], "23:59" });
			} else if (rec[2].equals("OUT")) {
				String intime = map.get(rec[1])[0];
				String outtime = rec[0];
				map.remove(rec[1]);
				int time = caltime(intime, outtime);
				int before = 0;
				if (fee.get(rec[1]) != null) {
					before = fee.get(rec[1]);
				}
				fee.put(rec[1], before + time);
			}
		}
		Collections.sort(list);
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			if (map.get(list.get(i)) != null) {
				int time = caltime(map.get(list.get(i))[0], map.get(list.get(i))[1]);
				map.remove(list.get(i));
				int before = 0;
				if (fee.get(list.get(i)) != null) {
					before = fee.get(list.get(i));
				}
				fee.put(list.get(i), before + time);
			}

//        	System.out.println(list.get(i)+"요금 :"+fee.get(list.get(i)));
			answer[i] = calfee((int) fee.get(list.get(i)), fees);

		}

		return answer;
	}

	private static int calfee(int time, int[] fees) {
		int fee = 0;
		if (time <= fees[0])
			return fees[1];
		int ftime = (time - fees[0]) / fees[2];
		if ((time - fees[0]) % fees[2] != 0)
			ftime++;
		fee = ftime * fees[3] + fees[1];
		return fee;
	}

	private static int caltime(String intime, String outtime) {
		int fee = 0;
		String[] in = intime.split(":");
		String[] out = outtime.split(":");
		int timein = Integer.parseInt(in[0]) * 60 + Integer.parseInt(in[1]);
		int timeout = Integer.parseInt(out[0]) * 60 + Integer.parseInt(out[1]);
		return timeout - timein;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 180, 5000, 10, 600 },
				new String[] { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
						"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" })));

		System.out.println(Arrays.toString(solution(new int[] {120, 0, 60, 591}, new String[] {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"})));
		
		System.out.println(Arrays.toString(solution(new int[] {1, 461, 1, 10}, new String[] {"00:00 1234 IN"})));

	}

}
