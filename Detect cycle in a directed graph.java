// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1#

class DetectCycle
{
    static boolean checkCycle(ArrayList<ArrayList<Integer>> gra, boolean done[], boolean cur[], int ind)
    {
        if(cur[ind])
            return true;
        
        if(done[ind])
            return false;
        
        cur[ind] = true;
        ArrayList<Integer> temp = gra.get(ind);
        
        for(int i:temp)
        {
            if(checkCycle(gra,done,cur,i))
                return true;
        }
        
        done[ind] = true;
        cur[ind] = false;
        
        return false;
    }
    
    static boolean isCyclic(ArrayList<ArrayList<Integer>> gra, int v)
    {
        boolean done[] = new boolean[v];
        boolean cur[] = new boolean[v];
        
        for(int i=0;i<v;i++)
        {
            if(checkCycle(gra,done,cur,i))
                return true;
        }
        return false;
    }
}
