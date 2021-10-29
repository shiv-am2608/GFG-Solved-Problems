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
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


//User function Template for Java
class TrieNode
{
    boolean isPresent=false;
    TrieNode arr[]=new TrieNode[26];
}
class Trie
{
    TrieNode root;
    Trie()
    {
        root=new TrieNode();
    }
    void insert(String str)
    {
        TrieNode curr=root;
        for(int i=0;i<str.length();i++)
        {
            int index=str.charAt(i)-'a';
            if(curr.arr[index]==null)
                curr.arr[index]=new TrieNode();
            curr=curr.arr[index];
        }
        curr.isPresent=true;
    }
    TrieNode getNode(String str)
    {
        TrieNode curr=root;
        for(int i=0;i<str.length();i++)
        {
            int index=str.charAt(i)-'a';
            if(curr.arr[index]==null)
                return null;
            curr=curr.arr[index];
        }
        return curr;
    }
    ArrayList<String> suggestion(String str)
    {
        ArrayList<String>res=new ArrayList<String>();
        TrieNode curr=getNode(str);
        if(curr==null)
        {
            res.add("0");
            return res;
        }
        ArrayList<String>post=new ArrayList<String>();
        String temp="";
        dfs(curr,post,temp);
        for(String i:post)
            res.add(new String(str+i));
        return res;
    }
    void dfs(TrieNode curr,ArrayList<String>ans,String temp)
    {
        if(curr==null)
            return;
        if(curr.isPresent)
            ans.add(new String(temp));
        for(int i=0;i<26;i++)
        {
            if(curr.arr[i]==null)
                continue;
            temp+=(char)(i+'a');
            dfs(curr.arr[i],ans,temp);
            temp=temp.substring(0,temp.length()-1);
        }
    }
}
class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // code here
        Trie root=new Trie();
        for(String x:contact)
            root.insert(x);
        ArrayList<ArrayList<String>>res=new ArrayList<ArrayList<String>>();
        for(int i=1;i<=s.length();i++)
        {
            ArrayList<String>ans=root.suggestion(s.substring(0,i));
            res.add(new ArrayList<String>(ans));
        }
        return res;
    }
}