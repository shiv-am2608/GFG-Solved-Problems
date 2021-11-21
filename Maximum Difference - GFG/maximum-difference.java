// { Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
			Solution ob = new Solution();
			System.out.println(ob.findMaxDiff(a,n));
		t--;
		}
	}
}// } Driver Code Ends



class Solution
{
    int findMaxDiff(int a[], int n)
    {
	// Your code here
	    int max=Integer.MIN_VALUE;
	    for(int k=0;k<n;k++)
	    {
	        int i=k-1,j=k+1;
	        while(i>=0 && a[i]>=a[k])
	            i--;
	        while(j<n && a[j]>=a[k])
	            j++;
	        int x,y;
	        x=i==-1?0:a[i];
	        y=j==n?0:a[j];
	        max=Math.max(max,Math.abs(y-x));
	    }
	    return max;
    }
}