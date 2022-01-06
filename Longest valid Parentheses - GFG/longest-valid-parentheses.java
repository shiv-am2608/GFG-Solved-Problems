// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String s){
        // code here
        int left=0,right=0,max=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
                left++;
            else
                right++;
            if(left==right)
                max=Math.max(max,left*2);
            if(right>left)
            {
                left=0;
                right=0;
            }
        }
        left=0;
        right=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)=='(')
                left++;
            else
                right++;
            if(left==right)
                max=Math.max(max,left*2);
            if(left>right)
            {
                left=0;
                right=0;
            }
        }
        return max;
    }
}