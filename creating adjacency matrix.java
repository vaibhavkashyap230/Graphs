public class Solution
{
    public static void main(String args[])
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
    	
    	for(int i=0;i<n;i++)
    	{
    		for(int j=0;j<n;j++)
    		{
    			System.out.print(m[i][j]+" ");
    		}
    		System.out.println();
    	}
    	s.close();
    }
}