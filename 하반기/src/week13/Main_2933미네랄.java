package week13;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 아이디어 
 * 
 * 막대기를 던질 때마다, 클러스터가 끊겨서 떨어질 클러스터가 생성되는지 검사해주고, 바르게 내려준다.
 * 
 * 바닥에 붙어 있는 미네랄 클러스터는 떨어질 일이 없이 고정되어 있다.
 * 그러므로 막대기가 미네랄을 없앤 이후, 바닥 행에 있는 미네랄에 대해 BFS를 수행해서 Land 미네랄 클러스터를 구한다.
 * 
 * Land 미네랄 클러스터를 구했으면, 그 이외의 분리된 클러스터가 있는지 BFS를 돌려준다.
 * 이외의 분리된 클러스터가 존재한다면 맵에서 지우고 맵과 같은 크기의 불린 배열에 표기해준다.
 * 
 * 불린 배열에 표기된 클러스터와 땅에 붙어있는 Land미네랄 사이 간격의 최솟값을 구해서 그만큼만 내려준다.
 * 
 */
public class Main_2933미네랄 {

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        for(int i=0; i<R; i++)  map[i]=br.readLine().toCharArray();

        int N = Integer.parseInt(br.readLine());

        //막대 던지기 과정 N번
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++) {
            int r=R-Integer.parseInt(st.nextToken());

            //왼쪽에서 던질때
            if(n%2==0) {
                for(int j=0; j<C; j++) if(map[r][j] == 'x') {
                    map[r][j] = '.';
                    break;
                }
            }
            //오른쪽에서 던질 때
            else {
                for(int j=map[r].length-1; j>=0; j--) if(map[r][j] == 'x') {
                    map[r][j] = '.';
                    break;
                }
            }

            //바닥에 닿아있는 미네랄 클러스터 확인 BFS
            int[] dr = {0, 1, 0, -1};   //우 하 좌 상
            int[] dc = {1, 0, -1, 0};   //우 하 좌 상
            boolean[][] v = new boolean[R][C];

            for(int j=0; j<C; j++) {
                if(!v[R-1][j] && map[R-1][j] == 'x')    {
                    landBFS(new Point(R-1,j), map, v, dr, dc);
                }
            }

            //떨어질 클러스터 확인 및 복사
            L:for(int i=0; i<R; i++)    for(int j=0; j<C; j++) {
                if(map[i][j] == '.') continue;

                //바닥과 이어져 있지 않은 클러스터인 경우 -> 문제의 제한조건 상, 분리된 떨어질 클러스터이다.
                //클러스터 체크 및 중력기능으로 떨어뜨려준다.
                else if(!v[i][j] && map[i][j] == 'x') {
                    boolean[][] v2 = new boolean[R][C];
                    clusterBFS(new Point(i,j), map, v2, dr, dc);
                    moveClusterDown(map,v2);

                    break L;    //조건상 두개 이상 클러스터가 떨어지는 경우가 없으므로
                }
            }
        }//for N 구문 끝

        printAns(map);
    }

    //분리된 클러스터 정보가 담긴 boolean[][]v2 배열과 map 배열을 입력으로 받아서 분리된 클러스터를 중력작용으로 내려주는 펑션
    //map의 마지막 행부터 시작해서 0행까지 순회하면서 가장 마지막에 나온 x(가장 높은 x)를 저장해주고, 분리된 클러스터마다 최솟값인지 판별해서 갱신해준다.  
    private static void moveClusterDown(char[][] map, boolean[][] v2) {
        int minDistance = Integer.MAX_VALUE;

        for(int j=0; j<map[0].length; j++) {
            int topLandR = map.length;  //가장 높은 땅의 행 값 저장할 변수

            //행의 가장 아래부터 맨 위까지 순회
            for(int i=map.length-1; i>=0; i--) {
                //미네랄인 경우 최고높이 땅 갱신
                if(map[i][j] == 'x')    topLandR = i;
                //분리된 클러스터인 경우 클러스트 행값과 가장 높은 땅의 차이가 최솟값인지 판별
                else if(v2[i][j]) {
                    minDistance = Integer.min(minDistance, topLandR-i);
//                  break;  //반례는 없었지만, 미네랄이 ㄷ 모양으로 서로 어긋나 있는 경우를 위해 완전탐색 하도록 주석처리
                }
            }
        }

        //클러스터를 내려줄때는 가장 먼저 땅이나 미네랄에 닿는 순간까지만 내려줘야 하므로
        //순회하면서 전체에 대한 높이차 최솟값을 구해준다.
        for(int i=0; i<map.length; i++) for(int j=0; j<map[0].length; j++) {
            if(v2[i][j] == true) map[i+minDistance-1][j] = 'x';
        }
    }

    //BFS에 쓰기 위해 만든 좌표정보 객체
    static class Point{
        int r,c;

        public Point(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }
    }

    //땅에 붙어 있는 미네랄을 시작점으로 하는 BFS
    private static void landBFS(Point point, char[][] map, boolean[][] v, int[] dr, int[] dc) {
        Queue<Point> q = new LinkedList<>();
        q.offer(point);
        v[point.r][point.c] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int d=0; d<4; d++) {
                int nr=p.r+dr[d]; int nc=p.c+dc[d];
                if(isSafe(nr,nc,map) && !v[nr][nc] && map[nr][nc] == 'x') {

                    q.offer(new Point(nr,nc));
                    v[nr][nc] = true;
                }
            }
        }
    }

    //땅에 붙어있는 미네랄 BFS가 끝난 후, 그 외의 분리되어 있는 cluster가 있는지 검사하는 BFS
    //분리된 클러스터가 있는 경우, 맵에서 지워주고, boolean 배열에 그 위치를 표시해준다.
    private static void clusterBFS(Point point, char[][] map, boolean[][] v2, int[] dr, int[] dc) {

        Queue<Point> q = new LinkedList<>();
        q.offer(point);
        v2[point.r][point.c] = true;
        map[point.r][point.c] = '.';

        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int d=0; d<4; d++) {
                int nr=p.r+dr[d]; int nc=p.c+dc[d];
                if(isSafe(nr,nc,map) && !v2[nr][nc] && map[nr][nc] == 'x') {

                    q.offer(new Point(nr,nc));
                    v2[nr][nc] = true;
                    map[nr][nc] = '.';
                }
            }
        }
    }

    //경계값 체크 펑션
    private static boolean isSafe(int nr, int nc, char[][] map) {
        if(nr>=0 && nr<map.length && nc>=0 && nc<map[0].length) return true;
        return false;
    }

    //결과 맵을 출력하는 펑션
    private static void printAns(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
            }System.out.println();
        }
    }

    //for test
    private static void printBoolean(boolean[][] v) {
        System.out.println();
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                if(v[i][j]) System.out.print("v ");
                else System.out.print(". ");
            }System.out.println();
        }System.out.println();
    }

    private static void printLand(boolean[][] v, char[][] map) {
        System.out.println();
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                if(v[i][j] && map[i][j] == 'x') System.out.print("x ");
                else System.out.print(". ");
            }System.out.println();
        }System.out.println();
    }

    private static void printMap(char[][] map) {
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }System.out.println();
        }System.out.println();
    }
}