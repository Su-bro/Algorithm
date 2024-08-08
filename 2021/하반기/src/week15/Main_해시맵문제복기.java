package week15;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main_해시맵문제복기 {

	/*
	 * 기존에 사용한 알고리즘 : 방법1. 기존 유저가 신기록을 기록했을 때 이미 1등이라면 패스 1등이 아닐 때 Value 기준으로 정렬한
	 * 해시맵 엔트리 리스트에서 앞선 인덱스의 Value보다 클 경우, map에 기록을 추가한 후 해당 Key의 index번호를 구해서 K안에
	 * 있을경우 스코어보드 갱신, answer++ 함
	 * 
	 * 방법2. GetKth로 랭크에 든 점수 중 가장 낮은 점수보다 높을 경우 랭크에 올랐다, answer++함
	 * 
	 * 
	 * 왜 틀렸는가? 방법1의 경우 만약 K(스코어보드 출력수)가 3라면 A가 새로운 스코어 6을 기록할 때 기존 C, E 가 6점이므로 스코어
	 * 보드에 A의 점수가 기록되지 않는다. 하지만 map에 put 한 후 GetMyRank 메소드에 의해 재정렬될 경우 A의 랭크 즉
	 * index가 3이되어 스코어보드를 갱신한것으로 취급하여 틀렸다
	 * 
	 * 방법2의 경우 기존의 A의 등수가 K안에 들어있을경우 해당 방법을 적용하면 스코어보드가 변하지 않았는데 변한것으로 체크하게된다.
	 * 
	 * 
	 * 어떻게 해결할까? : 방법1,2를 조건문으로 둘다 썼어야했다
	 * 
	 * 
	 * 만약 GetMyRank 가 K보다 크다면 (스코어보드 밖에 있다면) GetKth 로 K등의 점수를 가져온뒤 비교, 새로운 점수가 더 크다면
	 * answer++ 해주고
	 * 
	 * GetMyRank가 K보다 작다면(이미 랭크에 들어있다면) GetCompScore로 A보다 한 등수 위에 있는 유저의 점수를 가져온뒤
	 * 비교, 새로운 점수가 더 크다면 answer++ 해야했다
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("A", 4);
		map.put("B", 1);
		map.put("C", 6);
		map.put("D", 5);
		map.put("E", 6);
		map.put("F", 7);
		map.put("G", 2);
		map.put("H", 8);
		List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
		list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
		System.out.println(list);
		// [H=8, F=7, C=6, E=6, D=5, A=4, G=2, B=1]

		map.put("A", 6);
		list = new LinkedList<>(map.entrySet());
		list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
		System.out.println(list);
		// [H=8, F=7, A=6, C=6, E=6, D=5, G=2, B=1]

	}	

}


class Solution {

//    해시맵사용
//
//    1. id(K) 가 null인가 -> 새로운유저다.
//        1-1. 해시 size가 K보다 작다 -> 보드에 새 기록 answer++
//        1-2. 해시 size가 K보다 크다 -> k등의 V보다 크다면 보드갱신 answer++
//
//    2. id(K) 가 null이 아닌가 -> 기존 유저가 새로운 V를 기록함
//        2-1. 새로운 점수가 가존의 본인 V보다 작다면 pass
//        2-2. V보다크다면 V갱신
//            2-2-1. K등의 V보다 크다면 보드갱신 answer++ 

	public int solution(int K, String[] rec) {
		int answer = 0;
		Map<String, Integer> map = new HashMap<>();
		for (String r : rec) {
			String[] tmp = r.split(" ");
			String id = tmp[0];
			int score = Integer.parseInt(tmp[1]);
			// 1.
			if (map.get(id) == null) {
				System.out.println("*** 새로운 유저 기록");
				if (map.size() < K) { // 1-1.
					System.out.println("해시 size가 K보다 작다 -> 보드에 새 기록 answer++");
					map.put(id, score);
					answer++;
				} else { // 1-2.
					System.out.println("해시 size가 K보다 크다");
					int Kth_score = GetKth(map, K);
					System.out.println(K + "등의 점수:" + Kth_score);
					if (Kth_score < score) { // K위의 V보다 score가 크다면
						System.out.println("랭킹보드 갱신");
						answer++;
					}
					map.put(id, score);
				}
			}

			// 2.
			else {
				System.out.println("*** 기존 유저의 새로운 점수");
				if (score < map.get(id)) {// 2-1.
					System.out.println("유저의 기존 기록보다 낮으므로 무시한다");
					continue;
				}
				// 2-2.
				System.out.println("유저의 최고기록 갱신");
				// 내가 1등이라면 패스한다
				int MyRank = GetMyRank(map, id);
				if (MyRank == 0) {
					map.put(id, score);
					continue;
				}

				// 1등이 아닐때
				int compscore = GetCompScore(map, id);
				int compRank = GetMyRank(map, GetCompId(map, id));
				if (compRank < K) {
					System.out.println(" 내 앞사람 점수:" + compscore);
					if (score > compscore) {
						System.out.println("역전했다");
						map.put(id, score);
						answer++;

					} else
						map.put(id, score);
				}
			}
		}
		return answer;
	}

	static int GetKth(Map<String, Integer> map, int K) { // K등의 점수를 구하는 메소드
		List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
		list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
		if (list.size() < K) {
			return list.get(list.size() - 1).getValue();
		} else
			return list.get(K - 1).getValue();
	}

	static int GetMyRank(Map<String, Integer> map, String id) { // 나의 등수
		int a = 0;
		List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
		list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getKey().equals(id)) {
				a = i;
			}
		}
		return a;
	}

	static int GetCompScore(Map<String, Integer> map, String id) {
		int a = 1;
		List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
		list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getKey().equals(id)) {
				a = i;
			}
		}
		return list.get(a - 1).getValue();
	}

	static String GetCompId(Map<String, Integer> map, String id) {
		int a = 1;
		List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
		list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getKey().equals(id)) {
				a = i;
			}
		}
		return list.get(a - 1).getKey();
	}

}
