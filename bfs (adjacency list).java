https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

/*
*ArrayList<ArrayList<Integer>> list: represent graph containing vertices
                                    and edges between them
*vis[]: boolean array to represent visited vertex
*s: starting vertex 
*/
class Traversal
{
    static void bfs(int s, ArrayList<ArrayList<Integer>> m, boolean v[], int nov)
    {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        v[s]=true;
        while(!q.isEmpty())
        {
            System.out.print(q.peek()+" ");
            for(int i : m.get(q.peek()) )
            {
                if(!v[i])
                {q.add(i);
                v[i]=true;}
            }
            q.poll();
        }
    }
}