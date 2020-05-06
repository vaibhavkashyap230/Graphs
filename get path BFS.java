// https://classroom.codingninjas.com/app/classroom/me/1108/content/39588/offering/441189/problem/1696

import java.util.*;

public class Solution
{
    private static ArrayList<Integer> findPath(int mat[][],int source,int dest)
    {
        Queue<Integer> q = new LinkedList<Integer>();
    	int parent[] = new int[mat.length];
    	for(int i=0;i<mat.length;i++)
    	{
    		parent[i] = -1;
    	}
    	boolean visited[] = new boolean[mat.length];
    	visited[source] = true;
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	
    	q.add(source);
    	while(!q.isEmpty())
    	{
    		int temp = q.poll();
    		for(int i=0;i<mat.length;i++)
    		{
    			if(mat[temp][i]==1 && visited[i]==false)
    			{
    				parent[i] = temp;
    				q.add(i);
    				visited[i] = true;
    				if(i==dest)
    					break;
    			}
    		}
    	}
    	
    	int cur = dest;
    	while(cur!=-1)
    	{
    		result.add(cur);
    		cur = parent[cur];
    	}
    	return result;
    }
	public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int vertex = s.nextInt(), edges = s.nextInt();
        int mat[][] = new int[vertex][vertex];
        for(int i=0;i<edges;i++)
        {
            int start = s.nextInt(),end = s.nextInt();
            mat[start][end] = 1;
            mat[end][start] = 1;
        }
        int source = s.nextInt(),dest = s.nextInt();
        s.close();
        ArrayList<Integer> result = findPath(mat,source,dest);
        if(result.size()<2)
        	return;
        for(int i : result)
        {
            System.out.print(i+" ");
        }
	}
}