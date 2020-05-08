// https://classroom.codingninjas.com/app/classroom/me/1108/content/39588/offering/441195/problem/529

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
    public boolean check(int mat[][],pair cur,int current,int dir)
	{
		if(cur.a<0 || cur.a>=mat.length)
			return false;
		if(cur.b<0 || cur.b>=mat[0].length)
			return false;
		if(mat[cur.a][cur.b]==-2)
			return true;
		if(mat[cur.a][cur.b]!=current)
			return false;
		
		mat[cur.a][cur.b] = -2;
		
		boolean res = false;
		if(dir!=2)
		res = check(mat,new pair(cur.a-1,cur.b),current,1);
		if(dir!=1)
		res = res | check(mat,new pair(cur.a+1,cur.b),current,2);
		if(dir!=4)
		res = res | check(mat,new pair(cur.a,cur.b-1),current,3);
		if(dir!=3)
		res = res | check(mat,new pair(cur.a,cur.b+1),current,4);
		
		mat[cur.a][cur.b] = -1;
		return res;
	}
    
	int solve(String[] board , int n, int m)
	{
        int mat[][] = new int[n][m];
		for(int i=0;i<n;i++)
		{
			String s = board[i];
			int temp[] = new int[m];
			for(int j=0;j<m;j++)
			{
				temp[j] = s.charAt(j)-'A';
			}
			mat[i] = temp;
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(mat[i][j]!=-1)
				{
					if(check(mat,new pair(i,j),mat[i][j],0))
					{
						return 1;
					}
				}
			}
		}
		return 0;
	}
}