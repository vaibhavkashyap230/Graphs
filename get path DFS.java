// https://classroom.codingninjas.com/app/classroom/me/1108/content/39588/offering/441187/problem/1695

import java.util.*;

public class Solution
{
    private static ArrayList<Integer> findPath(int mat[][],int source,int dest,boolean visited[])
    {
        if(visited[source])
            return new ArrayList<Integer>();
        
        visited[source]=true;
        if(source==dest)
        {
        	ArrayList<Integer> res = new ArrayList<Integer>();
        	res.add(dest);
        	return res;
        }
        
        for(int i=0;i<mat.length;i++)
        {
        	if(mat[source][i]==1 && visited[i]==false)
        	{
        		ArrayList<Integer> temp = findPath(mat,i,dest,visited);
        		if(temp.size()>0)
        		{
        			temp.add(source);
        			return temp;
        		}
        	}
        }
        
        return new ArrayList<Integer>();
    }
	public static void main(String[] args)
    {
		Scanner s = new Scanner(System.in);
        int vertex = s.nextInt(), edges = s.nextInt();
        int mat[][] = new int[vertex][vertex];
        for(int i=0;i<edges;i++)
        {
            int start = s.nextInt(),end = s.nextInt();
            mat[start][end] = 1;
            mat[end][start] = 1;
        }
        int source = s.nextInt(),dest = s.nextInt();
        s.close();
        boolean visited[] = new boolean[vertex];
        ArrayList<Integer> result = findPath(mat,source,dest,visited);
        for(int i : result)
        {
            System.out.print(i+" ");
        }
	}
}