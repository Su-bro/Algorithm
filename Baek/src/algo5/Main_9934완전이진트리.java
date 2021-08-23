package algo5;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_9934완전이진트리 {

    //트리 어레이리스트
    private static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("트리.txt"));
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        //트리 초기화
        for (int i = 0; i <= k; i++) {
        	//깊이만큼 트리 어레이리스트 안에 어레이스트 추가
            tree.add(new ArrayList<>());
        }
        
        //노드수 = 2의 k제곱 -1
        
        int nodes = (int) Math.pow(2, k) - 1; 
        
        int[] buildings = new int[nodes];

        
        for (int i = 0; i < nodes; i++) {
            buildings[i] = sc.nextInt();
        }
        
        //노드수/2 , 건물배열 , 깊이 , 레벨
        sol(nodes / 2, buildings, k, 1);

        for (int i = 1; i <= k; i++) {
        	//트리 레벨 호출
            ArrayList<Integer> treelv = tree.get(i);
            //레벨 안에 있는 요소 출력
            for (int building : treelv) {
                System.out.print(building + " ");
            }
            System.out.println();
        }
    }
    private static void sol(int index, int[] buildings, int k, int level) {
        if (level > k) { //레벨이 깊이보다 크면 리턴
            return;
        }

        //트리 어레이리스트 안에 있는 level 인덱스의 어레이리스트 호출
        ArrayList<Integer> treelv = tree.get(level);
        treelv.add(buildings[index]); //빌딩의 인덱스 요소를 집어넣는다.
        tree.set(level, treelv); //트릐의 level번 인덱스값 바꾼다.

        // 깊이 - 레벨 -1 제곱한 temp 
        int temp = (int) Math.pow(2, (k - level - 1));
        // leftIndex는 인덱스 - temp
        int leftIndex = index - temp;
        int rightIndex = index + temp;

        //0보다 클경우
        if (leftIndex >= 0) {
        	sol(leftIndex, buildings, k, level + 1);
        	//좌측 인덱스 상대로
        }
        if (rightIndex < buildings.length) {
        	sol(rightIndex, buildings, k, level + 1);
        	//우측 인덱스 상대로
        }
    }
}

/* 4
 2  5
1 3 6 7

4 2 5 
*/

