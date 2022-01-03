// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
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
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends


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
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
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
            while(size-->0)
            {
                String curr=q.poll();
                if(curr.equals(targetWord))
                    return count;
                HashSet<String>consider=new HashSet<String>();
                for(String x:dict)
                    if(diff(x,curr))
                    {
                        q.offer(x);
                        consider.add(x);
                    }
                updateDict(dict,consider);
            }
        }
        return 0;
        
    }
}