// https://classroom.codingninjas.com/app/classroom/me/1108/content/39589/offering/441206/problem/1724

import java.util.Scanner;

public class Solution
{
	private static int get_min(int weight[],boolean done[])
	{
		int min = Integer.MAX_VALUE,cur = -1;
		for(int i=0;i<weight.length;i++)
		{
			if(weight[i]<min && done[i]==false)
			{
				min = weight[i];
				cur = i;
			}
		}
		return cur;
	}
    
	private static void prims(int mat[][],int parent[],int weight[],boolean done[],int cur)
	{
		for(int i=0;i<mat.length;i++)
		{
			if(mat[cur][i]!=0 && done[i]==false)
			{
				if(mat[cur][i]<weight[i])
				{
					weight[i] = mat[cur][i];
					parent[i] = cur;
				}
			}
		}
		done[cur] = true;
		int ncur = get_min(weight,done);
		if(ncur!=-1)
		{
			prims(mat,parent,weight,done,ncur);
		}
	}
    
	public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
    	int vertex = s.nextInt(),m = s.nextInt();
    	int mat[][] = new int[vertex][vertex];
    	for(int i=0;i<m;i++)
    	{
    		int a = s.nextInt(),b = s.nextInt(), x = s.nextInt();
    		mat[a][b] = x;
    		mat[b][a] = x;
    	}
    	s.close();
    	int parent[] = new int[vertex];
    	int weight[] = new int[vertex];
    	boolean done[] = new boolean[vertex];
    	weight[0] = 0;
    	parent[0] = -1;
    	for(int i=1;i<vertex;i++)
    	{
    		weight[i] = Integer.MAX_VALUE;
    	}
    	prims(mat,parent,weight,done,0);
    	for(int i=1;i<vertex;i++)
    	{
    		System.out.println(Math.min(i,parent[i])+" "+Math.max(i,parent[i])+" "+weight[i]);
    	}
	}
}