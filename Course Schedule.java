// https://leetcode.com/problems/course-schedule/

import java.util.*;

class Solution
{
    private boolean hasCycle(ArrayList<ArrayList<Integer>> graph,int curr,HashMap<Integer,Integer> unexp,HashMap<Integer,Integer> exp,HashMap<Integer,Integer> cur)
    {
        if(exp.containsKey(curr))
            return false;
        if(cur.containsKey(curr))
            return true;
        
        cur.put(curr,1);
        ArrayList<Integer> temp = graph.get(curr);
        for(int i : temp)
        {
            if(hasCycle(graph,i,unexp,exp,cur))
                return true;
        }
        cur.remove(curr);
        exp.put(curr,1);
        return false;
    }
    
    public boolean canFinish(int n, int[][] edges)
    {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<edges.length;i++)
        {
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        HashMap<Integer,Integer> unexp = new HashMap<>();
        HashMap<Integer,Integer> exp = new HashMap<>();
        HashMap<Integer,Integer> cur = new HashMap<>();
        
        for(int i=0;i<n;i++)
        {
            unexp.put(i,1);   
        }
        
        for(int i=0;i<n;i++)
        {
            if(hasCycle(graph,i,unexp,exp,cur))
                return false;
        }
        return true;
    }
}
