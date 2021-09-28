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
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int solve(String s,int i,int j,int isTrue,int dp[][][])
    {
        if(i>j)
            return 0;
        if(i==j)
        {
            if(isTrue==1)
            {
                return s.charAt(i)=='T'?1:0;
            }
            else
                return s.charAt(i)=='F'?1:0;
        }
        if(dp[i][j][isTrue]!=-1)
            return dp[i][j][isTrue];
        int ans=0;
        int left_true=0,left_false=0,right_true=0,right_false=0;
        for(int k=i+1;k<j;k+=2)
        {
            if(dp[i][k-1][1]!=-1)
                left_true=dp[i][k-1][1];
            else
            {
                left_true=solve(s,i,k-1,1,dp);
            }
            
            if(dp[i][k-1][0]!=-1)
                left_false=dp[i][k-1][0];
            else
            {
                left_false=solve(s,i,k-1,0,dp);
            }
            
            if(dp[k+1][j][1]!=-1)
                right_true=dp[k+1][j][1];
            else
            {
                right_true=solve(s,k+1,j,1,dp);
            }
            
            if(dp[k+1][j][0]!=-1)
                right_false=dp[k+1][j][0];
            else
            {
                right_false=solve(s,k+1,j,0,dp);
            }
            
            if(s.charAt(k)=='&')
            {
                if(isTrue==1)
                {
                    ans+=left_true*right_true;
                }
                else
                {
                    ans+=(left_true*right_false)+(left_false*right_true)+(left_false*right_false);
                }
            }
            else if(s.charAt(k)=='|')
            {
                if(isTrue==1)
                    ans+=(left_true*right_false)+(left_false*right_true)+(left_true*right_true);
                else
                    ans+=left_false*right_false;
            }
            else
            {
                if(isTrue==1)
                    ans+=(left_false*right_true)+(left_true*right_false);
                else
                    ans+=(left_true*right_true)+(left_false*right_false);
            }
            dp[i][j][isTrue]=ans%1003;
        }
        return ans%1003;
    }
    static int countWays(int N, String S){
        int dp[][][]=new int[N+1][N+1][2];
        for(int rows[][]:dp)
            for(int cols[]:rows)
                Arrays.fill(cols,-1);
        return solve(S,0,N-1,1,dp);
    }
}