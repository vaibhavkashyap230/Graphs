// https://practice.geeksforgeeks.org/problems/find-whether-path-exist/0

import java.util.*;

class GFG
 {
    private static boolean dfs(int mat[][],int si,int sj,int ei,int ej,boolean visited[][])
    {
        if(si<0 || si>=mat.length || ei<0 || ei>=mat.length || sj<0 || sj>=mat.length || ej<0 || ej>=mat.length)
            return false;
        
        if(visited[si][sj])
            return false;
        
        if(si==ei && sj==ej)
            return true;
        
        if(mat[si][sj]==0)
            return false;
        
        visited[si][sj] = true;
        
        return dfs(mat,si-1,sj,ei,ej,visited) || dfs(mat,si+1,sj,ei,ej,visited) || dfs(mat,si,sj-1,ei,ej,visited) || dfs(mat,si,sj+1,ei,ej,visited);
    }
     
	public static void main (String[] args)
	 {
     	Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int n = sc.nextInt();
            int mat[][] = new int[n][n];
            int si=0,sj=0,ei=0,ej=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                   mat[i][j] = sc.nextInt();
                   if(mat[i][j]==1)
                   {
                       si = i;
                       sj = j;
                   }
                   if(mat[i][j]==2)
                   {
                       ei = i;
                       ej = j;
                   }
                }
            }
            boolean visited[][] = new boolean[n][n];
            if(dfs(mat,si,sj,ei,ej,visited))
                System.out.println(1);
            else
                System.out.println(0);
        }
        sc.close();
	 }
}
