package algo_10;

import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
     Scanner input = new Scanner(System.in);
            
            int a = input.nextInt();
            int b = input.nextInt();
            
            int[] arr = new int[a];
            for(int i = 0; i< a; i++)
            {
                int userInput = input.nextInt();
                arr[i] = userInput;
            }
            
            
            System.out.println(countNum(arr,b));
    }
    public static int countNum(int[] arr, int num)
        {
            Stack<Integer> s = new Stack<>();
            int count = 0;
            int temp = 0;
            for(int i =0; i< arr.length;i++)
            {
                if(s.size() != num)
                {
                    s.push(arr[i]);
                    //System.out.print(arr[i] + " ");
                }
                if(s.size() == num )
                {
                    temp = s.pop();
                    s.clear();
                    count++;
                    s.push(temp);
                    //System.out.println();
                }
                
            }
            
            if(s.size() > 1)
            {
                return count + 1;
            }else
            {
                return count;
            }
            
        }
}
