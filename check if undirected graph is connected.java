// https://classroom.codingninjas.com/app/classroom/me/1108/content/39588/offering/441192/problem/1697

import java.util.Scanner;

public class Solution
{
	private static void dfs(int mat[][],int cur,boolean v[])
	{
		if(v[cur])
			return;
		
		v[cur] = true;
		for(int i=0;i<mat.length;i++)
		{
			if(mat[cur][i]==1 && v[i]==false)
			{
				dfs(mat,i,v);
			}
		}
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
        s.close();
        boolean visited[] = new boolean[vertex];
        dfs(mat,0,visited);
        for(int i=0;i<vertex;i++)
        {
        	if(!visited[i])
        	{
        		System.out.println("false");
        		return;
        	}
        }
        System.out.println("true");
	}
}