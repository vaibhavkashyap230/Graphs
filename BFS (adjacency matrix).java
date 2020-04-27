// https://classroom.codingninjas.com/app/classroom/me/1108/content/39588/offering/441179/problem/1699

import java.util.*;

public class Solution
{
    private static void bfs(int m[][], boolean v[],int c)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(c);
		v[c]=true;
		while(!q.isEmpty())
		{
			System.out.print(q.peek()+" ");
			for(int i=0;i<m.length;i++)
			{
				if(m[q.peek()][i]==1 && v[i]==false)
					{
						q.add(i);
						v[i]=true;
					}
			}
			q.poll();
		}
        for(int i=0;i<m.length;i++)
        {
            if(!v[i])
                bfs(m,v,i);
        }
	}
	public static void main(String[] args)
    {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	int m[][] = new int[n][n];
    	int e = s.nextInt();
    	for(int i=0;i<e;i++)
    	{
    		int x = s.nextInt();
    		int y = s.nextInt();
    		m[x][y]=1;
    		m[y][x]=1;
    	}
    	s.close();
        
    	boolean visited[] = new boolean[n];
    	bfs(m,visited,0);
	}
}