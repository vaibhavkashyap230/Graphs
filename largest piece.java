// https://classroom.codingninjas.com/app/classroom/me/1108/content/39588/offering/441195/problem/556

class pair
{
	int a,b;
	public pair(int x,int y)
	{
		this.a = x;
		this.b = y;
	}
}

public class solution
{
    private static int connect(int mat[][],pair cur,int gmax[],int max)
	{
		if(cur.a<0 || cur.a>=mat.length)
			return max;
		if(cur.b<0 || cur.b>=mat[cur.a].length)
			return max;
		if(mat[cur.a][cur.b]==0)
			return max;
		
		mat[cur.a][cur.b] = 0;
		max+=1;
		gmax[0] = Math.max(gmax[0],max);
		max = connect(mat,new pair(cur.a-1,cur.b),gmax,max);
		max = connect(mat,new pair(cur.a+1,cur.b),gmax,max);
		max = connect(mat,new pair(cur.a,cur.b-1),gmax,max);
		max = connect(mat,new pair(cur.a,cur.b+1),gmax,max);
		return max;
	}
    public int solve(int n,String cake[])
    {
        int mat[][] = new int[n][];
        for(int i=0;i<n;i++)
        {
            int temp[] = new int[cake[i].length()];
            for(int j=0;j<cake[i].length();j++)
            {
                if(cake[i].charAt(j)=='1')
                    temp[j] = 1;
                else
                    temp[j] = 0;
            }
            mat[i] = temp;
        }
        int gmax[] = {0};
        for(int i=0;i<n;i++)
        {
        	for(int j=0;j<mat[i].length;j++)
        	{
        		if(mat[i][j]==1)
        			connect(mat,new pair(i,j),gmax,0);
        	}
        }
        return gmax[0];
    }
}