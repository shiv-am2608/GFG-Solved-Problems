// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution ob = new Solution();
            
            System.out.println(ob.minFlips(S));
                        
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public int minFlips(String S) {
        // Code here
        char ch[]=S.toCharArray();
        int min1=0,min2=0;
        for(int i=0;i<ch.length;i++)
        {
            if(i%2==0 && ch[i]=='0')
                min1++;
            if(i%2==1 && ch[i]=='1')
                min1++;
        }
        for(int i=0;i<ch.length;i++)
        {
            if(i%2==1 && ch[i]=='0')
                min2++;
            if(i%2==0 && ch[i]=='1')
                min2++;
        }
        return Math.min(min1,min2);
    }
}