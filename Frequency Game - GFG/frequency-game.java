// { Driver Code Starts
// Initial Template for Java

import java.util.*;

// Position this line where user code will be pasted.

// Driver class with main function
class GFG {
    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        // Iterating over testcases
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Geeks obj = new Geeks();
            System.out.println(obj.LargButMinFreq(arr, n));
        }
    }
}// } Driver Code Ends


// User function Template for Java

// Helper class to find largest number with minimum frequency
class Geeks {
    // Function to find largest number with minimum frequency
    public static int LargButMinFreq(int arr[], int n) {
        // Your code here
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
        {
            if(hmap.containsKey(arr[i]))
                hmap.put(arr[i],hmap.get(arr[i])+1);
            else
                hmap.put(arr[i],1);
        }
        int min=n+1;
        int ans=-1;
        for(Map.Entry<Integer,Integer>t:hmap.entrySet())
        {
            if(t.getValue()<min)
            {
                min=t.getValue();
                ans=t.getKey();
            }
            else if(t.getValue()==min && t.getKey()>ans)
                ans=t.getKey();
        }
        return ans;
    }
}