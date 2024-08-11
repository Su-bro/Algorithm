package PS42577;

import java.util.*;
public class Solution {


    public boolean solution(String[] pb) {
        boolean answer = true;
        Arrays.sort(pb, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(pb));
        for (int i = 0; i < pb.length; i++) {
            for (int j = i+1; j < pb.length; j++) {
                if (pb[j].length() > pb[i].length() &&
                        pb[j].startsWith(pb[i])) {
                    return false;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] phone_book = {"97674223", "1195524421", "119"};
        System.out.println(sol.solution(phone_book));
    }
}
