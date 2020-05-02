// https://practice.geeksforgeeks.org/problems/rotten-oranges/0

import java.util.*;
import java.io.*;

class Pair
{
    public int first,second;
    public Pair(int a, int b)
    {
        this.first = a;
        this.second = b;
    }
}
class GFG
{
	private static void rot(int mat[][], Queue<Pair> q1, Queue<Pair> q2,boolean flag[])
	{
		while(!q1.isEmpty())
		{
			Pair temp = q1.peek();
			if(temp.first-1>=0 && mat[temp.first-1][temp.second]==1)
			{
				mat[temp.first-1][temp.second] = 2;
				q2.add(new Pair(temp.first-1,temp.second));
				flag[0] = true;
			}
			if(temp.first+1<mat.length && mat[temp.first+1][temp.second]==1)
			{
				mat[temp.first+1][temp.second] = 2;
				q2.add(new Pair(temp.first+1,temp.second));
				flag[0] = true;
			}
			if(temp.second+1<mat[0].length && mat[temp.first][temp.second+1]==1)
			{
				mat[temp.first][temp.second+1] = 2;
				q2.add(new Pair(temp.first,temp.second+1));
				flag[0] = true;
			}
			if(temp.second-1>=0 && mat[temp.first][temp.second-1]==1)
			{
				mat[temp.first][temp.second-1] = 2;
				q2.add(new Pair(temp.first,temp.second-1));
				flag[0] = true;
			}
			q1.poll();
		}
	}
	private static boolean check(int mat[][])
	{
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat[i].length;j++)
			{
				if(mat[i][j]==1)
					return true;
			}
		}
		return false;
	}
	public static void main (String[] args)
	{
	    Scanner s = new Scanner(System.in);
	    int test = s.nextInt();
	    while(test-->0)
	    {
	        int r = s.nextInt(), c = s.nextInt();
	        int mat[][] = new int[r][c];
	        Queue<Pair> q1 = new LinkedList<Pair>();
	        Queue<Pair> q2 = new LinkedList<Pair>();
	        for(int i=0;i<r;i++)
	        {
	            for(int j=0;j<c;j++)
	            {
	                mat[i][j] = s.nextInt();
	                if(mat[i][j]==2)
	                {
	                    q1.add(new Pair(i,j));
	                }
	            }
	        }
	        int t=0;
	        boolean flag[] = new boolean[1];
	        while(q1.isEmpty()==false || q2.isEmpty()==false)
	        {
	        	t++;
	        	if(!q1.isEmpty())
	        		rot(mat,q1,q2,flag);
	        	else
	        		rot(mat,q2,q1,flag);
	        	
	        	if(flag[0]==false)
	        		t--;
	        	flag[0]=false;
	        }
	        if(check(mat))
	        {
	        	System.out.println(-1);
	        }
	        else
	        {
	        	System.out.println(t);
	        }
	}
	    s.close();
	}
}