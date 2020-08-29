// https://practice.geeksforgeeks.org/problems/topological-sort/1

class TopologicalSort
{
    static void fill(ArrayList<ArrayList<Integer>> adj, int cur,boolean visited[],Stack<Integer> st)
    {
        if(visited[cur])
            return;
        
        visited[cur] = true;
        ArrayList<Integer> temp = adj.get(cur);
        for(int i : temp)
        {
            fill(adj,i,visited,st);
        }
        st.push(cur);
    }
    
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N)
    {
        Stack<Integer> st = new Stack<Integer>();
        boolean visited[] = new boolean[N];
        for(int i=0;i<N;i++)
        {
            fill(adj,i,visited,st);
        }
        int res[] = new int[N];
        for(int i=0;i<N;i++)
        {
            res[i] = st.pop();
        }
        return res;
    }
}
