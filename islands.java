// https://classroom.codingninjas.com/app/classroom/me/1108/content/39588/offering/441195/problem/555

public class solution
{    
    private void connect_dfs(int mat[][],int cur,boolean visited[])
    {
        if(visited[cur])
            return;
        
        visited[cur] = true;
        for(int i=0;i<mat[cur].length;i++)
        {
            if(mat[cur][i]==1 && visited[i]==false)
                connect_dfs(mat,i,visited);
        }
    }
    
    public int solve(int n,int m,int u[],int v[])
    {
        int mat[][] = new int[n][n];
        for(int i=0;i<m;i++)
        {
            mat[u[i]-1][v[i]-1] = 1;
            mat[v[i]-1][u[i]-1] = 1;
        }
        boolean visited[] = new boolean[n];
        int t = 0;
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                t+=1;
                connect_dfs(mat,i,visited);
            }
        }
        return t;
    }
}