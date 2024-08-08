package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
단순 구현

아이디어 조금
ㄱ 맵을 ㅣ ㅡ 로 분리해서 생각하면
같은 메소드에 r 과 c 값을 반대로 주고, t=2/t=1을 스왑해주면 재활용 가능

또 실제로는 ㅡ맵은 ㅣ맵을 좌우반전하고, 오른쪽으로 90도 회전한 형태인데
답을 구하는데는 좌우반전이 필요 없으므로 그냥 인자만 바꿔줘도 된다.
*/
public class Main_20061모도미노도미노2 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        int[][] map1 = new int[10][4];
        int[][] map2 = new int[10][4];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int nth=0; nth<N; nth++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            splitCmd(t,r,c,map1,map2);

        }
        System.out.println(score +"\n"+ chkBlocks(map1,map2));
    }

    private static int chkBlocks(int[][] map1, int[][] map2) {
        int cnt=0;
        for (int i = 0; i < map2.length; i++) {
            for (int j = 0; j < map2[0].length; j++) {
                if(map1[i][j] != 0) cnt++;
                if(map2[i][j] != 0) cnt++;
            }
        }
        return cnt;
    }

    private static void splitCmd(int t, int r, int c, int[][] map1, int[][] map2) {
        int nr;
        if(t==1) {
            nr  = putBlock(t, r, c, map1);
            eraseBlock(t, nr, map1);

            nr  = putBlock(t, c, r, map2);
            eraseBlock(t, nr, map2);
        }
        else if(t==2) {
            nr  = putBlock(t, r, c, map1);
            eraseBlock(t, nr, map1);

            nr  = putBlock(3, c, r, map2);
            eraseBlock(3, nr, map2);
        }
        else {
            nr  = putBlock(t, r, c, map1);
            eraseBlock(t, nr, map1);

            nr  = putBlock(2, c, r, map2);
            eraseBlock(2, nr, map2);
        }

        procMidArea(map1);
        procMidArea(map2);

    }

    private static void procMidArea(int[][] map) {
        int cnt=0;
        //두 줄 검사
        for(int i=4; i<=5; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j]!=0) {cnt++; break;}
            }
        }

        pullLine(map.length-1, cnt, map);
    }

    //블록끼리 처음 맞닿게 되는 r 좌표 return (세로로 두 줄인 경우, 둘 중 아래 r좌표)
    private static int putBlock(int t, int r, int c, int[][] map) {
        if(t==1) {
            while(r+1<map.length && map[r+1][c]==0) {
                r++;
            }
            map[r][c]=1;
        }
        else if(t==2) {
            while(r+1<map.length && map[r+1][c]==0 && map[r+1][c+1]==0) {
                r++;
            }
            map[r][c]=1;
            map[r][c+1]=1;
        }
        else {
            while(r+1<map.length && map[r+1][c]==0) {
                r++;
            }
            map[r-1][c]=1;
            map[r][c]=1;
        }

        return r;
    }

    static int score;
    private static void eraseBlock(int t, int nr, int[][] map) {
        //세로 두줄 블럭을 내린 경우 두 줄 검사
        if(t==3) {
            int flag=3;

            for(int j=0; j<map[0].length; j++) {
                if(map[nr][j] == 0)     flag&=2;
                if(map[nr-1][j] == 0)   flag&=1;
            }

            //아랫행만 지워지는 경우
            if(flag==1) {
                Arrays.fill(map[nr], 0);
                score++;
                pullLine(nr,1,map);
            }
            //윗행만 지워지는 경우 
            else if(flag==2) {
                Arrays.fill(map[nr-1], 0);
                score++;
                pullLine(nr-1,1,map);
            }
            //두 행 다 지워 지는 경우
            else if(flag==3) {
                Arrays.fill(map[nr], 0);
                score+=2;
                pullLine(nr,2,map);
            }

            return;
        }

        //나머진 한 행만 검사
        for(int j=0; j<map[0].length; j++) {
            if(map[nr][j] == 0) break;

            //행이 채워진 경우 행 삭제
            if(j==map[0].length-1) {
                Arrays.fill(map[nr], 0);
                score++;

                pullLine(nr,1,map);
            }
        }
    }

    private static void pullLine(int r, int num, int[][] map) {
        for (int j = 0; j < map[r].length; j++) {
            for(int i=r; i>3; i--)  map[i][j]=map[i-num][j];
        }
    }
}