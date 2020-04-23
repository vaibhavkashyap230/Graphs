// https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

class Traversal
{
    static void dfs(int i, ArrayList<ArrayList<Integer>> m, boolean v[])
    {
        if(v[i])
			return;
		
		System.out.print(i+" ");
		v[i]=true;
		ArrayList<Integer> c = m.get(i);
		for(int x=0;x<c.size();x++)
		{
			dfs(c.get(x),m,v);
		}
    }
}
