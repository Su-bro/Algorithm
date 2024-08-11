package PS42579;

import java.util.*;

class Song {
    int sid;
    int cnt;

    public Song(int sid, int cnt) {
        this.sid = sid;
        this.cnt = cnt;
    }

    public String toString() {
        return String.format("(%d, %d)", sid, cnt);
    }
}

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        List<Integer> ans = new ArrayList<>();
        // map = {genres, List<{sid, cnt}>}
        // map2 = {genres, totalPlayCount}
        // keySet iteration
        // 노래 리스트 정렬
        Map<String, Integer> totalCnt = new HashMap<>();
        Map<String, List<Song>> map = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            if (!map.containsKey(genres[i])) {
                map.put(genres[i], new ArrayList<>(List.of(new Song(i, plays[i]))));
                totalCnt.put(genres[i], plays[i]);
            } else {
                map.get(genres[i]).add(new Song(i, plays[i]));
                totalCnt.put(genres[i], totalCnt.get(genres[i]) + plays[i]);
            }
        }
        System.out.println(map);
        System.out.println(totalCnt);

        // totalCntKeys List 정렬 -> 정렬 기준 : totalCnt.get(o2) - totalCnt.get(o1)
        List<String> keys = new ArrayList<>(map.keySet());
        keys.sort((o1, o2) -> totalCnt.get(o2) - totalCnt.get(o1));
        System.out.println("sorted genres : " + keys);

        // 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        //장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
        for (String key : keys) {
            List<Song> songs = map.get(key);
            songs.sort((o1, o2) -> {
                if (o1.cnt == o2.cnt) {
                    return o1.sid - o2.sid;
                }
                return o2.cnt - o1.cnt;
            });
            System.out.println(songs);
            ans.add(songs.get(0).sid);
            if (songs.size() > 1) {
                ans.add(songs.get(1).sid);
            }
        }


        return ans.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500}));
    }
}
