package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str= br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int Y=Integer.parseInt(st.nextToken());
        int X=Integer.parseInt(st.nextToken());

        char[][] arr = new char[Y][X];
        for(int i=0;i<Y;i++) arr[i]=br.readLine().toCharArray();        
        //최소거리찾기
        //밑에서부터 돌면서 땅찾기
        int dist = 99;
        for(int j =X-1;j>=0;j--) {
            boolean flag = false;
            int tmp = 0;
            for(int i=Y-1;i>0;i--) {
                if(arr[i][j]=='#') {
                    if(arr[i-1][j]=='#') {
                        tmp=0;
                    }
                    if(arr[i-1][j]=='.')tmp++;
                    if(arr[i-1][j]=='X') {
                        flag = true;
                    }
                }
                if(arr[i][j]=='.') {
                    if(arr[i-1][j]=='#') {
                        tmp = 0;
                    }
                    if(arr[i-1][j]=='.')tmp++;
                    if(arr[i-1][j]=='X') {
                        flag = true;
                        break;
                    }
                }

            }
            if(flag==true&&dist>tmp)dist=tmp;

        }
        //System.out.println(dist);
        //무벼앳(밑에서부터 올라오면서 X가 있으면 .로 바꾸고 dist만큼 밑에 X로)
        for(int i=Y-1;i>=0;i--) {
            for(int j=X-1;j>=0;j--) {
                if(arr[i][j]=='X') {
                    arr[i][j]='.';
                    arr[i+dist][j]='X';
                }
            }
        }
        //출력
        for(int i =0;i<Y;i++) {
            System.out.println(new String(arr[i]));
        }
        br.close();
    }
}