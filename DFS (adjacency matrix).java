public class DFS
{
	private static void dfs(int m[][],int i,boolean v[])
	{
		if(v[i])
			return;
		
		System.out.print(i+" ");
		v[i]=true;
		for(int x=0;x<m.length;x++)
		{
			if(m[i][x]==1)
			dfs(m,x,v);
		}
	}
}