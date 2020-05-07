https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1/

class DetectCycle
{
    private static boolean cycle(ArrayList<ArrayList<Integer>> mat,int cur,int par,boolean visited[])
    {
        if(visited[cur])
            return true;
            
        visited[cur] = true;
        ArrayList<Integer> temp = mat.get(cur);
        for(int i : temp)
        {
            if(i!=par)
            {
                if(cycle(mat,i,cur,visited))
                    return true;
            }
        }
        return false;
    }
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
            {
                if(cycle(list,i,-1,visited))
                return true;
            }
        }
        return false;
    }
}