// https://www.interviewbit.com/problems/water-flow/

import java.util.*;

class pair
{
    int a,b;
    public pair(int x,int y)
    {
        this.a=x;
        this.b=y;
    }
}

public class Solution
{
    private void fill(Queue<pair> q,int mat[][],boolean visited[][])
    {
        while(!q.isEmpty())
        {
            pair temp = q.poll();
            
            if(temp.a-1>=0 && mat[temp.a-1][temp.b]>=mat[temp.a][temp.b] && visited[temp.a-1][temp.b]==false)
            {
                q.add(new pair(temp.a-1,temp.b));
                visited[temp.a-1][temp.b]=true;
            }
            
            if(temp.b-1>=0 && mat[temp.a][temp.b-1]>=mat[temp.a][temp.b] && visited[temp.a][temp.b-1]==false)
            {
                q.add(new pair(temp.a,temp.b-1));
                visited[temp.a][temp.b-1]=true;
            }
            
            if(temp.a+1<mat.length && mat[temp.a+1][temp.b]>=mat[temp.a][temp.b] && visited[temp.a+1][temp.b]==false)
            {
                q.add(new pair(temp.a+1,temp.b));
                visited[temp.a+1][temp.b]=true;
            }
            
            if(temp.b+1<mat[0].length && mat[temp.a][temp.b+1]>=mat[temp.a][temp.b] && visited[temp.a][temp.b+1]==false)
            {
                q.add(new pair(temp.a,temp.b+1));
                visited[temp.a][temp.b+1]=true;
            }
        }
    }
    
    public int solve(int[][] mat)
    {
        Queue<pair> q = new LinkedList<pair>();
        boolean bv[][] = new boolean [mat.length][mat[0].length];
        boolean rv[][] = new boolean[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++)
        {
            q.add(new pair(i,0));
            bv[i][0] = true;
        }
        for(int j=1;j<mat[0].length;j++)
        {
            q.add(new pair(0,j));
            bv[0][j] = true;
        }
        fill(q,mat,bv);
        for(int i=0;i<mat[0].length;i++)
        {
            q.add(new pair(mat.length-1,i));
            rv[mat.length-1][i] = true;
        }
        for(int i=0;i<mat.length-1;i++)
        {
            q.add(new pair(i,mat[i].length-1));
            rv[i][mat[i].length-1] = true;
        }
        fill(q,mat,rv);
        int count = 0;
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                if(bv[i][j]==true && rv[i][j]==true)
                    count+=1;
            }
        }
        return count;
    }
}
