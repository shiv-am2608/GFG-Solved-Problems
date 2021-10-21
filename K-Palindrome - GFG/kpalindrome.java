// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String input_line[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            int k = Integer.parseInt(input_line[1]);
            String str = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.kPalindrome(str, n, k));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int kPalindrome(String str, int n, int k)
    {
        // code here
        String str2="";
        for(int i=str.length()-1;i>=0;i--)
            str2+=str.charAt(i);
            
        int dp[][]=new int[n+1][n+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(str.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return n-dp[n][n]<=k?1:0;
    }
}