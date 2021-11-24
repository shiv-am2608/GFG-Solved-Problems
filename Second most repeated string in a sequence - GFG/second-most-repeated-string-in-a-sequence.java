// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            for(int i = 0;i<n;i++)
                arr[i] = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.secFrequent(arr, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    String secFrequent(String arr[], int N)
    {
        // your code here
        HashMap<String,Integer>hmap=new HashMap<String,Integer>();
        for(String str:arr)
        {
            if(hmap.containsKey(str))
                hmap.put(str,hmap.get(str)+1);
            else
                hmap.put(str,1);
        }
        int first=Integer.MIN_VALUE,second=Integer.MAX_VALUE;
        String fans="",sans="";
        for(Map.Entry<String,Integer>t:hmap.entrySet())
        {
            if(t.getValue()>first)
            {
                second=first;
                first=t.getValue();
                sans=fans;
                fans=t.getKey();
            }
            else if(t.getValue()>second)
            {
                second=t.getValue();
                sans=t.getKey();
            }
        }
        return sans;
    }
}