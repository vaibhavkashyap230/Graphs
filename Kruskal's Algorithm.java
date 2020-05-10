// https://classroom.codingninjas.com/app/classroom/me/1108/content/39589/offering/441201/problem/1723

import java.util.*;

class edge
{
	int v1,v2,weight;
	public edge(int a,int b,int c)
	{
		this.v1 = a;
		this.v2 = b;
		this.weight = c;
	}
}

class edge_sort implements Comparator<edge>
{
	public int compare(edge a,edge b)
	{
		return a.weight-b.weight;
	}
}

public class Solution
{
    private static int union_find(int a,int parent[])
	{
        if(parent[a]==a)
            return a;
		return union_find(parent[a],parent);
	}
    
	public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
		int vertex = s.nextInt(), edges = s.nextInt();
		edge input[] = new edge[edges];
		for(int i=0;i<edges;i++)
		{
			int a = s.nextInt(),b = s.nextInt(), x = s.nextInt();
			input[i] = new edge(a,b,x);
		}
		s.close();
		Arrays.sort(input,new edge_sort());
		int count = 0;
		int parent[] = new int[vertex];
		for(int i=0;i<vertex;i++)
		{
			parent[i] = i;
		}
		int i=0;
		while(count<vertex-1)
		{
            int ap = union_find(input[i].v1,parent);
            int bp = union_find(input[i].v2,parent);
			if(ap!=bp)
			{
				parent[ap] = bp;
				count+=1;
				System.out.println(Math.min(input[i].v1,input[i].v2)+" "+Math.max(input[i].v1,input[i].v2)+" "+input[i].weight);
			}
			i+=1;
		}
	}
}