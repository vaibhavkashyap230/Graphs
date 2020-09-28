// https://practice.geeksforgeeks.org/problems/minimum-swaps/1

class tri
{
    int num,pos;
    boolean visited;
    public tri(int a,int b)
    {
        this.num = a;
        this.pos = b;
        this.visited = false;
    }
}

class comp implements Comparator<tri>
{
    public int compare(tri a,tri b)
    {
        return a.num-b.num;
    }
}

class GfG
{
	public int minSwaps(int[] ar, int n)
	{
	    tri a[] = new tri[n];
	    for(int i=0;i<n;i++)
	    {
	        a[i] = new tri(ar[i],i);
	    }
	    
	    	    Arrays.sort(a,new comp());
	    int count=0;
	    for(int i=0;i<n;i++)
	    {
	    	if(a[i].visited || i==a[i].pos)
	    		continue;
	    	
	    	int cur=i,length=0;
	    	while(!a[cur].visited)
	    	{
	    		length+=1;
	    		a[cur].visited = true;
	    		cur=a[cur].pos;
	    	}
	    	count+=length-1;
	    }
	    return count;
	}
}
