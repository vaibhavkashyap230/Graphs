// https://practice.geeksforgeeks.org/problems/circle-of-strings/0

import java.util.*;

class GFG
 {
    
    private static boolean check(HashMap<Character,ArrayList<Integer>> gp,String a[],HashMap<Integer,Integer> unvisited,int cur)
    {
        if(unvisited.size()==0 && a[cur].charAt(0)==a[0].charAt(0))
            return true;
        
        if(!unvisited.containsKey(cur))
            return false;
        
        unvisited.remove(cur);
        String temp = a[cur];
        if(!gp.containsKey(temp.charAt(temp.length()-1)))
            return false;
        ArrayList<Integer> paths = gp.get(temp.charAt(temp.length()-1));
        for(int i=0;i<paths.size();i++)
        {
            if(check(gp,a,unvisited,paths.get(i)))
                return true;
        }
        unvisited.put(cur,1);
        
        return false;
    }
    
	public static void main (String[] args)
    {
     	Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int n = sc.nextInt();
            String a[] = new String[n];
            for(int i=0;i<n;i++)
            {
                a[i] = sc.next();
            }
            HashMap<Character,ArrayList<Integer>> gp = new HashMap<>();
            HashMap<Integer,Integer> unvisited = new HashMap<Integer,Integer>();
            for(int i=0;i<n;i++)
            {
            	unvisited.put(i,1);
            }
            for(int i=0;i<n;i++)
            {
                if(gp.containsKey(a[i].charAt(0)))
                    gp.get(a[i].charAt(0)).add(i);
                else
                {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(i);
                    gp.put(a[i].charAt(0),temp);
                }
            }
            if(check(gp,a,unvisited,0))
                System.out.println(1);
            else
                System.out.println(0);
        }
        sc.close();
    }
}
