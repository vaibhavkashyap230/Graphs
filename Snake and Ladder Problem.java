// https://practice.geeksforgeeks.org/problems/snake-and-ladder-problem/0

import java.util.*;

class GFG
 {
	public static void main (String[] args)
	 {
     	Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int graph[] = new int[30];
            for(int i=0;i<30;i++)
            {
                graph[i] = -1;
            }
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
            {
                int a = sc.nextInt()-1, b = sc.nextInt()-1;
                graph[a] = b;
            }
            int cost[] = new int[30];
            for(int i=1;i<30;i++)
            {
            	cost[i] = Integer.MAX_VALUE;
            }
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(0);
            boolean visited[] = new boolean[30];
            while(q.size()>0)
            {
            	int front = q.poll();
            	visited[front]=true;
            	
            	for(int i=1;i<7;i++)
            	{
            		if(front+i<30 && visited[front+i]==false)
            		{
            			cost[front+i] = Math.min(cost[front+i],cost[front]+1);
            			q.add(front+i);
            		}
            	}
            	if(graph[front]!=-1 && visited[graph[front]]==false)
            	{
    					cost[graph[front]] = Math.min(cost[front],cost[graph[front]]);
    					q.add(graph[front]);
            	}
            }
            System.out.println(cost[29]);
        }
        sc.close();
	 }
}
