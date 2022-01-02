// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java

//Back-end complete function Template for Java

class Solution{
    
    public static int count4Divisibiles(int arr[], int n ) 
    { 
        // Complete the function
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(hmap.containsKey(4-(arr[i]%4==0?4:arr[i]%4)))
                count+=hmap.get(4-(arr[i]%4==0?4:arr[i]%4));
            if(hmap.containsKey(arr[i]%4))
                hmap.put(arr[i]%4,hmap.get(arr[i]%4)+1);
            else
                hmap.put(arr[i]%4,1);
        }
        return count;
    }
    
}


// { Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    
		    int arr[] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int index = 0;index < sizeOfArray; index++){
		        arr[index] = Integer.parseInt(elements[index]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.count4Divisibiles(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}


  // } Driver Code Ends