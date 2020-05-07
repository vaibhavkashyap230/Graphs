package code;

import java.util.*;

class pair
{
	int a,b;
	public pair(int x,int y)
	{
		this.a = x;
		this.b = y;
	}
}

public class Solution
{
	private static void connect(ArrayList<ArrayList<Integer>> mat, pair cur)
	{
		if(cur.a<0 || cur.a>=mat.size())
			return;
		if(cur.b<0 || cur.b>=mat.get(cur.a).size())
			return;
		if(mat.get(cur.a).get(cur.b)==0)
			return;
		
		mat.get(cur.a).set(cur.b,0);
		connect(mat,new pair(cur.a-1,cur.b));
		connect(mat,new pair(cur.a+1,cur.b));
		connect(mat,new pair(cur.a,cur.b-1));
		connect(mat,new pair(cur.a,cur.b+1));
		connect(mat,new pair(cur.a-1,cur.b-1));
		connect(mat,new pair(cur.a-1,cur.b+1));
		connect(mat,new pair(cur.a+1,cur.b-1));
		connect(mat,new pair(cur.a+1,cur.b+1));
	}
	private static int find(ArrayList<ArrayList<Integer>> mat,int n,int m)
	{
		int res = 0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(mat.get(i).get(j)==1)
				{
					res+=1;
					connect(mat,new pair(i,j));
				}
			}
		}
		return res;
	}
    public static void main(String args[])
    {
	    Scanner s = new Scanner(System.in);
	    int test  = s.nextInt();
	    while(test-->0)
	    {
	    	int n = s.nextInt(), m = s.nextInt();
	    	ArrayList<ArrayList<Integer>> mat = new ArrayList<ArrayList<Integer>>();
	    	for(int i=0;i<n;i++)
	    	{
	    		ArrayList<Integer> temp = new ArrayList<Integer>();
	    		for(int j=0;j<m;j++)
	    		{
	    			temp.add(s.nextInt());
	    		}
	    		mat.add(temp);
	    	}
	    	System.out.println(find(mat,n,m));
	    }
	    s.close();
    }
}