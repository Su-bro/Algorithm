package algo_10;

import java.util.*;
 
public class Solution_1251하나로 {
 
    static class Edge implements Comparable<Edge>{
        int end;
        double cost;
        Edge(int end, double cost){
            this.end = end;
            this.cost = cost;
        }
 
        @Override
        public int compareTo(Edge o){
            if(this.cost > o.cost){
                return 1;
            }
            else if(this.cost == o.cost){
                return 0;
            }
            return -1;
        }
    } 
    static LinkedList<Edge>[] graph; 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt(); 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for(int i=0; i<n; i++){
                x[i] = sc.nextInt();
            }
            for(int i=0; i<n; i++){
                y[i] = sc.nextInt();
            }
            double e = sc.nextDouble();
 
            graph = new LinkedList[n];
            for(int i=0; i<n; i++){
                graph[i] = new LinkedList<>();
            }
            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    double cost = (Math.pow(x[i]-x[j], 2) + Math.pow(y[i]-y[j], 2));
                    graph[i].add(new Edge(j, cost));
                    graph[j].add(new Edge(i, cost));
                }
            }
 
            double ans = Math.min(Double.MAX_VALUE, prim(0, n));
            System.out.println("#"+test_case+" "+Math.round(ans*e));
        }
    } 
    private static double prim(int start, int n){
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
 
        double sum = 0;
        while(!queue.isEmpty()){
            int now = queue.poll();
 
            for(Edge edge : graph[now]){
                if(!visited[edge.end]){
                    pq.offer(edge);
                }
            }
 
            while(!pq.isEmpty()){
                Edge nowEdge = pq.poll();
                if(!visited[nowEdge.end]){
                    sum += nowEdge.cost;
                    queue.offer(nowEdge.end);
                    visited[nowEdge.end] = true;
                    break;
                }
            }
        }
 
        return sum;
    }
 
}