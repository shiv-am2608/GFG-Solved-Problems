// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String arr[] = read.readLine().split(" ");

            Solution ob = new Solution();
            String[] res = ob.findPrefixes(arr,N);
            
            for(int i=0; i<res.length; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class TrieNode
{
    TrieNode children[];
    int count[];
    TrieNode()
    {
        children=new TrieNode[26];
        count=new int[26];
    }
}
class Solution {
    static String[] findPrefixes(String[] arr, int N) {
        // code here
        TrieNode root=new TrieNode();
        for(int i=0;i<N;i++)
        {
            String str=arr[i];
            TrieNode curr=root;
            for(int j=0;j<str.length();j++)
            {
                int idx=str.charAt(j)-'a';
                if(curr.children[idx]==null)
                    curr.children[idx]=new TrieNode();
                curr.count[idx]++;
                curr=curr.children[idx];
            }
        }
        String ans[]=new String[N];
        int c=0;
        for(int i=0;i<N;i++)
        {
            String str=arr[i];
            TrieNode curr=root;
            String s="";
            for(int j=0;j<str.length();j++)
            {
                int idx=str.charAt(j)-'a';
                s+=str.charAt(j);
                if(curr.count[idx]==1)
                {
                    ans[c++]=s;
                    break;
                }
                curr=curr.children[idx];
            }
        }
        return ans;
    }
};