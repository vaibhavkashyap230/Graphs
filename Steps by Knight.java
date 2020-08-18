// https://practice.geeksforgeeks.org/problems/steps-by-knight/0

import java.util.*;

class pair
{
    int x,y;
    public pair(int a,int b)
    {
        this.x = a;
        this.y = b;
    }
}

class GFG
{
    
    private static boolean check(Queue<pair> q1,Queue<pair> q2,int tx,int ty,int n,boolean visited[][])
	{
		while(q1.isEmpty()==false)
		{
			pair temp = q1.poll();
			if(temp.x==tx && temp.y==ty)
			{
				return true;
			}
			
			if(temp.x-2>=0 && temp.y-1>=0 && visited[temp.x-2][temp.y-1]==false)
			{
				q2.add(new pair(temp.x-2,temp.y-1));
				visited[temp.x-2][temp.y-1] = true;
			}
			
			if(temp.x-2>=0 && temp.y+1<n && visited[temp.x-2][temp.y+1]==false)
			{
				q2.add(new pair(temp.x-2,temp.y+1));
				visited[temp.x-2][temp.y+1] = true;
			}
			
			if(temp.x+2<n && temp.y-1>=0 && visited[temp.x+2][temp.y-1]==false)
			{
				q2.add(new pair(temp.x+2,temp.y-1));
				visited[temp.x+2][temp.y-1] = true;
			}
			
			if(temp.x+2<n && temp.y+1<n && visited[temp.x+2][temp.y+1]==false)
			{
				q2.add(new pair(temp.x+2,temp.y+1));
				visited[temp.x+2][temp.y+1] = true;
			}
			
			if(temp.x-1>=0 && temp.y-2>=0 && visited[temp.x-1][temp.y-2]==false)
			{
				q2.add(new pair(temp.x-1,temp.y-2));
				visited[temp.x-1][temp.y-2] = true;
			}
			
			if(temp.x-1>=0 && temp.y+2<n && visited[temp.x-1][temp.y+2]==false)
			{
				q2.add(new pair(temp.x-1,temp.y+2));
				visited[temp.x-1][temp.y+2] = true;
			}
			
			if(temp.x+1<n && temp.y-2>=0 && visited[temp.x+1][temp.y-2]==false)
			{
				q2.add(new pair(temp.x+1,temp.y-2));
				visited[temp.x+1][temp.y-2] = true;
			}
			
			if(temp.x+1<n && temp.y+2<n && visited[temp.x+1][temp.y+2]==false)
			{
				q2.add(new pair(temp.x+1,temp.y+2));
				visited[temp.x+1][temp.y+2] = true;
			}
		}
		return false;
	}
    
	public static void main (String[] args)
	 {
     	Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int n = sc.nextInt(), kx = sc.nextInt()-1, ky = sc.nextInt()-1;
            int tx = sc.nextInt()-1, ty = sc.nextInt()-1;
            if(kx==tx && ky==ty)
            {
            	System.out.println(0);
            	continue;
            }
            Queue<pair> q1 = new LinkedList<pair>();
            Queue<pair> q2 = new LinkedList<pair>();
            boolean visited[][] = new boolean[n][n];
            visited[kx][ky] = true;
            int count[] = {0};
            q1.add(new pair(kx,ky));
            while(q1.isEmpty()==false || q2.isEmpty()==false)
            {
            	if(!q1.isEmpty())
            	{
            		if(check(q1,q2,tx,ty,n,visited)==false)
            			count[0]+=1;
            		else
            			break;
            	}
            	else
            	{
            		if(check(q2,q1,tx,ty,n,visited)==false)
            			count[0]+=1;
            		else
            			break;
            	}
            }
            if(count[0]==0)
            	System.out.println(1);
            else
            	System.out.println(count[0]);

        }
        sc.close();
	 }
}
