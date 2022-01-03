// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b)
    {
        String x = "";
        String y = "";
        for(int i=0; i<a.size(); i++)
            x += a.get(i);
        for(int i=0; i<b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if(ans.size()==0)
                System.out.println(-1);
            else
            {
                Collections.sort(ans, new comp());
                for(int i=0; i<ans.size(); i++)
                {
                    for(int j=0; j<ans.get(i).size(); j++)
                    {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean diff(String x,String y)
    {
        int count=0;
        for(int i=0;i<x.length();i++)
        {
            if(x.charAt(i)!=y.charAt(i))
                count++;
            if(count>1)
                return false;
        }
        return true;
    }
    public void updateDict(HashSet<String>dict,HashSet<String>con)
    {
        for(String x:con)
            dict.remove(x);
    }
    public int wordLadderLength(String startWord, String targetWord, String[] wordList,HashMap<String,ArrayList<String>>hmap)
    {
        // Code here
        HashSet<String>dict=new HashSet<String>();
        for(String x:wordList)
            dict.add(x);
        if(dict.contains(startWord))
            dict.remove(startWord);
        if(!dict.contains(targetWord))
            return 0;
        Queue<String>q=new LinkedList<String>();
        q.offer(startWord);
        int count=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            count++;
            HashSet<String>consider=new HashSet<String>();
            while(size-->0)
            {
                String curr=q.poll();
                hmap.put(curr,new ArrayList<String>());
                if(curr.equals(targetWord))
                    return count;
                for(String x:dict)
                    if(diff(x,curr))
                    {
                        q.offer(x);
                        hmap.get(curr).add(x);
                        consider.add(x);
                    }
            }
            updateDict(dict,consider);
        }
        return 0;
    }
    public void dfs(ArrayList<ArrayList<String>>ans,ArrayList<String>res,String startWord,String endWord,int depth,HashMap<String,ArrayList<String>>hmap)
    {
        if(depth==0)
        {
            if(startWord.equals(endWord))
            {
                res.add(startWord);
                ans.add(new ArrayList<String>(res));
                res.remove(startWord);
            }
            return;
        }
        res.add(startWord);
        for(String x:hmap.get(startWord))
            dfs(ans,res,x,endWord,depth-1,hmap);
        res.remove(startWord);
    }
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        HashMap<String,ArrayList<String>>hmap=new HashMap<String,ArrayList<String>>();
        int depth=wordLadderLength(startWord,targetWord,wordList,hmap);
        ArrayList<ArrayList<String>>ans=new ArrayList<ArrayList<String>>();
        if(depth==0)
            return ans;
        ArrayList<String>res=new ArrayList<String>();
        dfs(ans,res,startWord,targetWord,depth-1,hmap);
        return ans;
    }
}