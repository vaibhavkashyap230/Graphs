// https://classroom.codingninjas.com/app/classroom/me/1108/content/39588/offering/441184/problem/1693

import java.util.Scanner;

public class Solution
{
	private static boolean path(int m[][],boolean v[],int c,int d)
    {
        if(v[c])
            return false;
        
        v[c]=true;
        if(c==d)
            return true;
        
        for(int i=0;i<m.length;i++)
        {
            if(m[c][i]==1)
            {
                if(path(m,v,i,d))
                    return true;
            }
        }
        return false;
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
        int source = s.nextInt();
        int dest = s.nextInt();
        s.close();
        boolean visited[] = new boolean[n];
        System.out.println(path(m,visited,source,dest));
	}
}