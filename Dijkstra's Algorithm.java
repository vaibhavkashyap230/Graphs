// https://classroom.codingninjas.com/app/classroom/me/1108/content/39589/offering/441211/problem/1725

import java.util.Scanner;

class vertex
{
	int value,weight;
	boolean done;
	public vertex(int x)
	{
		this.value = x;
		this.weight = Integer.MAX_VALUE;
		this.done = false;
	}
}

public class Solution
{
	private static int getmin(vertex v[])
	{
		int min = Integer.MAX_VALUE,cur = -1;
		for(int i=0;i<v.length;i++)
		{
			if(v[i].weight<min && v[i].done==false)
			{
				min = v[i].weight;
				cur = i;
			}
		}
		return cur;
	}
	
	private static void dijkstra(int mat[][], vertex v[],int cur)
	{
		for(int i=0;i<mat.length;i++)
		{
			if(mat[cur][i]!=0 && v[i].done==false)
			{
				v[i].weight = Math.min(v[i].weight,v[cur].weight+mat[cur][i]);
			}
		}
		v[cur].done = true;
		int ncur = getmin(v);
		if(ncur!=-1)
		{
			dijkstra(mat,v,ncur);
		}
	}
    
	public static void main(String[] args)
    {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		vertex[] v = new vertex[n];
		for(int i=0;i<n;i++)
		{
			v[i] = new vertex(i);
		}
		v[0].weight = 0;
		v[0].done = true;
		int mat[][] = new int[n][n];
		int m = s.nextInt();
		for(int i=0;i<m;i++)
		{
			int a = s.nextInt(),b = s.nextInt(),x = s.nextInt();
			mat[a][b] = x;
			mat[b][a] = x;
		}
		s.close();
		dijkstra(mat,v,0);
        for(int i=0;i<n;i++)
        {
            System.out.println(v[i].value+" "+v[i].weight);
        }
	}
}