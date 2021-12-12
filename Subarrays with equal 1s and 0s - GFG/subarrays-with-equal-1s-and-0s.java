// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;
class Driverclass
 {
	public static void main (String[] args) {
	   
	   Scanner in = new Scanner(System.in);
	   int t= in.nextInt();
	   while(t-->0){
	       
	       int n = in.nextInt();
	       int [] arr= new int[n];
	       for(int i=0;i<n;i++) {
	           arr[i] = in.nextInt();
	       }
	       System.out.println(new Solution().countSubarrWithEqualZeroAndOne(arr, n));
	   }
	 }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        // add your code here
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        int presum=0;
        int count=0;
        for(int i=0;i<n;i++)
        {
            presum+=arr[i]==1?1:-1;
            if(presum==0)
                count++;
            if(hmap.containsKey(presum))
            {
                count+=hmap.get(presum);
                hmap.put(presum,hmap.get(presum)+1);
            }
            else
                hmap.put(presum,1);
        }
        return count;
    }
}


