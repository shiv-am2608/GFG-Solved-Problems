// { Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} // } Driver Code Ends


//User function Template for Java

class Solution{
    static int countMin(String str)
    {
        // code here
        String s="";
        for(int i=str.length()-1;i>=0;i--)
            s+=str.charAt(i);
        int dp[][]=new int[str.length()+1][str.length()+1];
        for(int i=0;i<=str.length();i++)
            for(int j=0;j<=str.length();j++)
            {
                if(i==0 || j==0)
                    continue;
                if(s.charAt(i-1)==str.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        return str.length()-dp[str.length()][str.length()];
    }
}