// https://practice.geeksforgeeks.org/problems/shortest-source-to-destination-path/0

import java.util.*;

class triplet
{
    int x,y,cost;
    public triplet(int x,int y,int z)
    {
        this.x = x;
        this.y = y;
        this.cost = z;
    }
}

class GFG
{
	public static void main (String[] args)
	{
     	Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int m = sc.nextInt(), n = sc.nextInt();
            int mat[][] = new int[m][n];
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    mat[i][j] = sc.nextInt();
                }
            }
            int x = sc.nextInt(), y = sc.nextInt();
            if(mat[0][0]==0)
            {
                System.out.println(-1);
                continue;
            }
            boolean visited[][] = new boolean[m][n];
            visited[0][0] = true;
            Queue<triplet> q = new LinkedList<triplet>();
            int result = -1;
            q.add(new triplet(0,0,0));
            while(q.size()>0)
            {
                triplet temp = q.poll();
                
                if(temp.x==x && temp.y==y)
                {
                    result = temp.cost;
                    break;
                }
                
                if(temp.x-1>=0 && mat[temp.x-1][temp.y]==1 && visited[temp.x-1][temp.y]==false)
                {
            		q.add(new triplet(temp.x-1,temp.y,temp.cost+1));
            		visited[temp.x-1][temp.y] = true;
                }
                    
                if(temp.x+1<m && mat[temp.x+1][temp.y]==1 && visited[temp.x+1][temp.y]==false)
                {
            		q.add(new triplet(temp.x+1,temp.y,temp.cost+1));
            		visited[temp.x+1][temp.y] = true;
                }
                    
                if(temp.y-1>=0 && mat[temp.x][temp.y-1]==1 && visited[temp.x][temp.y-1]==false)
                {
            		q.add(new triplet(temp.x,temp.y-1,temp.cost+1));
            		visited[temp.x][temp.y-1] = true;
                }
                    
                if(temp.y+1<n && mat[temp.x][temp.y+1]==1 && visited[temp.x][temp.y+1]==false)
                {
            		q.add(new triplet(temp.x,temp.y+1,temp.cost+1));
            		visited[temp.x][temp.y+1] = true;
                }
            }
            System.out.println(result);
        }
        sc.close();
	 }
}
