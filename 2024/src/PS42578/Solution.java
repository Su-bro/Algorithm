package PS42578;

import java.util.*;

public class Solution {

        public int solution(String[][] clothes) {
            int answer = 1;

            Map<String, Integer> map = new HashMap<>();
            for (String[] c : clothes) {
                map.put(c[1], map.getOrDefault(c[1], 0) + 1);
            }
            for (int count : map.values()) {
                answer *= (count+1);
            }
            return answer - 1;
        }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(sol.solution(new String[][] {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }
}