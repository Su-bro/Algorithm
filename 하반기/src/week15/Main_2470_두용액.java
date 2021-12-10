package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++) {
            int n=Integer.parseInt(st.nextToken());
            arr[i]=n;
        }
        Arrays.sort(arr);
        int left=0;
        int right=arr.length-1;
        int ans=Integer.MAX_VALUE;
        int l=0,r=0;
        while(left<right) {
            int sum=arr[left]+arr[right];
            int tmp=Math.abs(sum);
            if(tmp<ans) {
//              System.out.println(tmp);
                ans=tmp;
                l=left;
                r=right;
            }
            if(sum==0)break;
            if(sum>0)right--;
            else if(sum<0)left++;

        }

        System.out.println(arr[l]+" "+arr[r]);

    }

}