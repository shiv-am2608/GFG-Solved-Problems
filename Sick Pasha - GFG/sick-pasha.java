// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int arr [][] = new int[N][2];
		    for(int i = 0;i<N;i++){
	            line = br.readLine();
		        String[] elements = line.trim().split("\\s+");
		        arr[i][0] = Integer.parseInt(elements[0]);
		        arr[i][1] = Integer.parseInt(elements[1]);    
	        }
            line = br.readLine();
	        String[] elements = line.trim().split("\\s+");
	        int K = Integer.parseInt(elements[0]);
		    int Q = Integer.parseInt(elements[1]);
		    int queries [] = new int[Q];
		    for(int i =0;i<Q;i++){
		        queries[i] = Integer.parseInt(br.readLine());
		    }
		    
		    Complete obj = new Complete();
		    ArrayList<Boolean> ans;
		    ans = obj.QueryComputation(N, arr, K, Q, queries);
    	    for(boolean i: ans)
    	    {
    	        if(i == true)
    	            System.out.println("Yes");
    	        else
    	            System.out.println("No");
    	    }
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Complete{
    
   
    // Function for finding maximum and value pair
    public static void preCompute(int freq[],int arr[][])
    {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            int left=arr[i][0];
            int right=arr[i][1];
            freq[left]++;
            freq[right+1]--;
            min=Math.min(min,left);
            max=Math.max(max,right);
        }
        for(int i=min;i<=max;i++)
            freq[i]+=freq[i-1];
    }
    public static ArrayList<Boolean> QueryComputation (int n, int arr[][], int k, int q, int queries[]) {
        //Complete the function
        int freq[]=new int[200005];
        preCompute(freq,arr);
        ArrayList<Boolean>ans=new ArrayList<Boolean>();
        for(int i:queries)
        {
            if(k<=freq[i])
                ans.add(true);
            else
                ans.add(false);
        }
        return ans;
    }
    
    
}

