// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        char str[]=s.toCharArray();
        char ptr[]=p.toCharArray();
        int freq[]=new int[256];
        int count=0;
        for(char ch:ptr)
        {
            if(freq[ch]==0)
                count++;
            freq[ch]++;
        }
        int i=0,j=0,ans=Integer.MAX_VALUE,start=-1;
        while(j<s.length())
        {
            freq[str[j]]--;
            if(freq[str[j]]==0)
                count--;
            while(count==0)
            {
                if(ans>j-i+1)
                {
                    ans=Math.min(ans,j-i+1);
                    start=i;
                }
                freq[str[i]]++;
                if(freq[str[i]]>0)
                    count++;
                i++;
            }
            j++;
        }
        if(ans==Integer.MAX_VALUE)
            return "-1";
        return s.substring(start,start+ans);
    }
    
}