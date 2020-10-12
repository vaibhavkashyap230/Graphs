// https://www.algoexpert.io/questions/River%20Sizes

import java.util.*;

class Program
{
	private static int dfs(int i,int j,int mat[][],boolean visited[][])
	{
		if(i<0 || i>=mat.length || j<0 || j>=mat[0].length)
			return 0;
		if(visited[i][j]==true || mat[i][j]==0)
			return 0;
		
		visited[i][j] = true;
		return 1 + dfs(i-1,j,mat,visited) + dfs(i+1,j,mat,visited) + dfs(i,j-1,mat,visited) + dfs(i,j+1,mat,visited);
	}
	
  public static List<Integer> riverSizes(int[][] mat)
	{
		boolean visited[][] = new boolean[mat.length][mat[0].length];
		List<Integer> res = new ArrayList<Integer>();
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat[0].length;j++)
			{
				if(visited[i][j]==false && mat[i][j]==1)
				{
					int temp = dfs(i,j,mat,visited);
					res.add(temp);
				}
			}
		}
    return res;
  }
}
