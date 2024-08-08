package algo_10;

import java.util.Arrays;
import java.util.Scanner;
  
public class Main_1863 {
      
    static int n;
    static int[] religion = new int[50001]; // 종교 배열, 학생 수가 50000이하이므로 배열 크기를 설정한다.. 안하면 런타임 에러
    static int[] rank = new int[50001]; // 랭크 배열
      
    public static void main(String[] args){
  
        Scanner sc = new Scanner(System.in);
          
        n = sc.nextInt(); // 학생 수
          
        int[] res = new int[50001]; // 부모 개수 배열
        int ans = 0; // 부모 개수
          
        makeSet(); 
          
        int m = sc.nextInt(); // 같은 종교를 가진 학생 쌍의 수
              
        for(int i = 0; i < m; i++) {
            union(sc.nextInt(), sc.nextInt());
        }
          
        for(int i = 1; i <= n; i++) {
            if(religion[i] > 0) {
                res[religion[i]]++;
            }
        }
          
        for(int i = 1; i <= n; i++) {
            if(res[i] > 0) {
                ans++;
            }
        }
          
        System.out.println(ans);
    }
      
    // 학생 수 만큼 배열을 채움
    static void makeSet() {
        for(int i = 1; i <= n; i++) {
            religion[i] = i;
        }
    }
      
    // 같은 종교인 학생을 같은 집합으로 만듦
    static void union(int x, int y) {
        x = findSet(x);
        y = findSet(y);
          
        if(x == y) {
            return;
        }
          
        if(rank[x] > rank[y]) {
            religion[x] = y;
        }else{
            if(x > y) {
                religion[x] = y;
                  
            }else {
                religion[y] = x;
            }
              
            if(rank[x] == rank[y]) {
                if(x > y) {
                    rank[x]++;
                      
                }else {
                    rank[y]++;
                }
            }
        }
          
        return;
    }
      
    // 각 종교에서 대표 학생 찾기
    static int findSet(int idx) {
        if(idx == religion[idx]) {
            return idx;
        }
          
        return religion[idx] = findSet(religion[idx]);
    }
}
