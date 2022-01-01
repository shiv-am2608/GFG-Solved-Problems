// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int count=0;
        int freq[]=new int[256];
        int start=0,length=-1;
        for(int i=0;i<s.length();i++)
        {
            int ch=(int)s.charAt(i);
            if(freq[ch]==0)
                count++;
            freq[ch]++;
            if(count==k)
                 length=Math.max(length,i-start+1);
            while(count>k)
            {
                int rem=(int)s.charAt(start);
                freq[rem]--;
                if(freq[rem]==0)
                    count--;
                start++;
            }
        }
        return length;
    }
}