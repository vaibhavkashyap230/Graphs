// https://classroom.codingninjas.com/app/classroom/me/1108/content/39588/offering/441195/problem/528

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
    boolean find(char mat[][],String str,pair cur)
    {
        if(str.length()==0)
            return true;
        
        if(cur.a<0 || cur.a>=mat.length || cur.b<0 || cur.b>=mat[cur.a].length)
            return false;
        if(mat[cur.a][cur.b]=='.')
            return false;
        
        if(mat[cur.a][cur.b]==str.charAt(0))
        {
            str = str.substring(1);
        }
        else
        {
            return false;
        }
        char temp = mat[cur.a][cur.b];
        mat[cur.a][cur.b] = '.';
        
        
        boolean res =find(mat,str,new pair(cur.a-1,cur.b))| //up
                 	 find(mat,str,new pair(cur.a+1,cur.b))| //down
                 	 find(mat,str,new pair(cur.a,cur.b-1))| //left
                 	 find(mat,str,new pair(cur.a,cur.b+1))| //right
                 	find(mat,str,new pair(cur.a-1,cur.b-1))| //top-left
                 	find(mat,str,new pair(cur.a-1,cur.b+1))| //top-right
                 	find(mat,str,new pair(cur.a+1,cur.b-1))| //bottom-left
                 	find(mat,str,new pair(cur.a+1,cur.b+1));//botttom-right
        mat[cur.a][cur.b] = temp;
        
        return res;
    }
	int solve(String[] Graph , int n, int m)
	{
        char mat[][] = new char[Graph.length][];
        for(int i=0;i<Graph.length;i++)
        {
            String s = Graph[i];
            char temp[] = new char[s.length()];
            for(int j=0;j<s.length();j++)
            {
                temp[j] = s.charAt(j);
            }
            mat[i] = temp;
        }
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                if(find(mat,"CODINGNINJA",new pair(i,j)))
                    return 1;
            }
        }
        return 0;
	}
}