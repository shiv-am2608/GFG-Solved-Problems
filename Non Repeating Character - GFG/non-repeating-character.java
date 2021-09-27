// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S)
    {
        //Your code here
        int freq[][]=new int[2][256];
        Arrays.fill(freq[0],-1);
        for(int i=0;i<S.length();i++)
        {
            if(freq[0][S.charAt(i)]==-1)
                freq[0][S.charAt(i)]=i;
            freq[1][S.charAt(i)]++;
        }
        int ans=S.length()+1;
        char res='$';
        for(int i=0;i<256;i++)
        {
            if(freq[1][i]==1 && ans>=freq[0][i])
            {
                ans=Math.min(ans,freq[0][i]);
                res=(char)i;
            }
        }
        return res;
    }
}


