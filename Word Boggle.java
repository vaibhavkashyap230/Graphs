// https://practice.geeksforgeeks.org/problems/word-boggle/0

import java.util.*;

class GFG
{
    private static boolean find(String s,int i,int j,char mat[][],boolean visited[][])
	{
		if(s.length()==0)
			return true;
		
		if(i<0 || j<0)
			return false;
		if(i>=mat.length || j>=mat[0].length)
			return false;
		
		if(s.charAt(0)!=mat[i][j])
			return false;
		
		if(visited[i][j])
			return false;
		
		visited[i][j] = true;
		boolean a = find(s.substring(1),i-1,j,mat,visited);
		boolean b = find(s.substring(1),i+1,j,mat,visited);
		boolean c = find(s.substring(1),i,j-1,mat,visited);
		boolean d = find(s.substring(1),i,j+1,mat,visited);
		boolean e = find(s.substring(1),i-1,j-1,mat,visited);
		boolean f = find(s.substring(1),i-1,j+1,mat,visited);
		boolean g = find(s.substring(1),i+1,j-1,mat,visited);
		boolean h = find(s.substring(1),i+1,j+1,mat,visited);
		visited[i][j] = false;
		return a|b|c|d|e|f|g|h;
	}
	
	private static boolean find(String s,char mat[][])
	{
		int r = mat.length,c = mat[0].length;
		boolean visited[][] = new boolean[r][c];
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				if(mat[i][j]==s.charAt(0))
				{
					boolean res = find(s,i,j,mat,visited);
					if(res)
						return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
        	int n = sc.nextInt();
        	String a[] = new String[n];
        	for(int i=0;i<n;i++)
        	{
        		a[i] = sc.next();
        	}
        	int r = sc.nextInt(),c = sc.nextInt();
        	char mat[][] = new char[r][c];
        	for(int i=0;i<r;i++)
        	{
        		for(int j=0;j<c;j++)
        		{
        			mat[i][j] = sc.next().charAt(0);
        		}
        	}
        	Arrays.sort(a);
        	HashMap<String,Integer> hm = new HashMap<>();
        	boolean f = true;
        	for(String i : a)
        	{
        		if(!hm.containsKey(i) && find(i,mat))
        		{
        		    System.out.print(i+" ");
        		    f = false;
        		    hm.put(i,1);
        		}
        	}
        	if(f)
        	    System.out.println(-1);
        	else
        	    System.out.println();
        }
        sc.close();
    }
}
