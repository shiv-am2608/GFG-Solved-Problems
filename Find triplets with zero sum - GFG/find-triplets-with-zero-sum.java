// { Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
    public boolean twoSum(int arr[],int n,int target,int start)
    {
        HashSet<Integer>hs=new HashSet<Integer>();
        for(;start<n;start++)
        {
            if(hs.contains(target-arr[start]))
                return true;
            hs.add(arr[start]);
        }
        return false;
    }
	public boolean findTriplets(int arr[] , int n)
    {
        //add code here.
        for(int i=0;i<n-2;i++)
        {
            if(twoSum(arr,n,-arr[i],i+1))
                return true;
        }
        return false;
    }
}